#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFileDialog>
#include <QMessageBox>
#include <QLabel>
#include <QSqlRecord>
#include <QtDebug>
#include <QWidgetAction>
#include <QList>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    authDialog login; //ავტორიზაციის ბლოკის ობიექტი
    login.setModal(true); //დამოკიდებულია MainWindow-ზე
    login.exec();
    opened = false; //არ არის გახსნილი ბაზა
    ui->setupUi(this);
    setWindowTitle("Userbase Editor v0.31"); //სახელის დარქმევა

    if(!login.auth){ //თუ ავტორიზაცია წარუმატებელია
       noEdit(); //ყველაფრის გაუქმება
       QMessageBox::warning(0, "შეცდომა", "პროგრამის გამოყენება შეუძლებელია");
    }
    userCount = 0; //რაოდენობა = 0
    //ერთმანეთს უკავშირდება ცხრილის სიგნალი რომელიც გადაცემს შეცვლილ ელემენტს ჩვენს სლოტს
    connect(ui->tableWidget,SIGNAL(itemChanged(QTableWidgetItem*)),this,SLOT(onItemChanged(QTableWidgetItem*)));
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_actionOpen_triggered()
{
    opened = false; //არ არის გახსნილი ბაზა
    QString username,password,type;
    fileName = QFileDialog::getOpenFileName(this, tr("Open DB"), "/home/alex");
    db = QSqlDatabase::addDatabase("QSQLITE");
    db.setDatabaseName(fileName);
    db.open();
    QSqlQuery qry;
    qry.exec("SELECT * FROM Users"); //მონიშნე ყველაფერი მომხმარებლებიდან
    QSqlRecord rec = qry.record(); //ჩაიწერე დაბრუნებული მონაცემები
    int i=0; //???
    ui->tableWidget->setRowCount(0); //დასაწყისში აუქმებს ყველა სვეტს
    while(qry.next()){ //ცხრილის შევსება
        username = qry.value(rec.indexOf("username")).toString();
        password = qry.value(rec.indexOf("password")).toString();
        type = qry.value(rec.indexOf("type")).toString();
        ui->tableWidget->setRowCount(ui->tableWidget->rowCount()+1);
        ui->tableWidget->setItem(i,0,new QTableWidgetItem(username));
        ui->tableWidget->setItem(i,1,new QTableWidgetItem(password));
        ui->tableWidget->setItem(i,2,new QTableWidgetItem(type));
        i++; //????
    }
    userCount = ui->tableWidget->rowCount(); //მომხმარებლების რაოდენობა
    ui->label->setText(" მომხარებელთა რაოდენობაა " + QString::number(userCount)); //ლეიბელზე ტექსტი დაყენება
    opened = true; //ბაზა გახსნილია
}


void MainWindow::noEdit(){ //ყველა ელემენტის გაუქმება
    ui->actionAbout->setDisabled(true); //გააუქმე ღილაკი "პროგრამის შესახებ"
    ui->actionDelete->setDisabled(true);//გააუქმე ღილაკი "წაშლა"
    ui->actionOpen->setDisabled(true);//გააუქმე ღილაკი "გახსნა"
    ui->tableWidget->setDisabled(true);//გააუქმე ცხრილი
    ui->pushButton->setDisabled(true);//გააუქმე ღილაკი "ძებნა"
    ui->lineEdit->setDisabled(true);//გააუქმე ტექსტის ველი
    ui->actionAdd->setDisabled(true);//გააუქმე ღილაკი "დამატება"
}


void MainWindow::on_actionDelete_triggered() //წაშლი ღილაკის გამოძახებისას
{
    QSqlQuery qry; //სქლ-ის ბრძანების ობიექტი
    QString user,pass,type; //საჭირო სტრინგები
    //QItemSelectionModel არის მონიშვნის ტიპების კლასი, მას ენიჭება ცხრილი მონიშვნის ტიპი
    QItemSelectionModel* selectionModel = ui->tableWidget->selectionModel();
    //ინდექსების მასივს ენიჭება ამორჩეული სვეტების ინდექსები
    QModelIndexList selected = selectionModel->selectedRows();

    for(int i= 0; i< selected.count();i++){
        QModelIndex index = selected.at(i); //მოდელის ინდექსის კლასის ობიექტს ენიჭება selected მასივიდან გადმოცემული ინდექსი
        //ამოშალე Users ცხრილიდან მომხმარებელი და პაროლი მონიშნული სვეტიდან
        QString str = "DELETE FROM Users WHERE id=%1";
        if(qry.exec(str.arg(index.row()+1))){
            QMessageBox::information(this,"ამოშლა", "მონაცემი ამოშლილია");
            ui->tableWidget->removeRow(index.row()); //ამოშალე სტრიქონი ცხრილიდან
            userCount--;
            ui->label->setText(" მომხარებელთა რაოდენობაა " + QString::number(userCount));
        }
    }
}

void MainWindow::on_actionAbout_triggered()
{
    QMessageBox::information(this,"პროგრამის შესახებ", "პროგრამა დაწერილია ...");
}

void MainWindow::on_actionAdd_triggered()
{
    QSqlQuery qry;
    //ჩასვი Users-ში ახალი სტრიქონი ცარიელი მნიშვნელობებით
    if(qry.exec("INSERT INTO Users (username,password,type) VALUES (' ', ' ', ' ');")){
        ui->tableWidget->setRowCount(ui->tableWidget->rowCount()+1); //დაამატე სტრიქონი ცხრილში
        userCount ++;
        ui->label->setText(" მომხარებელთა რაოდენობაა " + QString::number(userCount));
    }
}

void MainWindow::onItemChanged(QTableWidgetItem *edited){
    if(opened){ //თუ გახსნილია
        QSqlQuery qry;
        int rowid = edited->row()+1;
        qDebug()<<rowid;
        if(edited->column()==0){
            //განაახლე Users დააყენე username სადაც id უდრის rowid-ს
            //ui->tableWidget->item(edited->row(),0)->text() იღებს მონაცემებს შესაბამის სვეტიდან და დარექტირებული სტრიქონიდანბ
            QString str = "UPDATE Users SET username=\'"+ui->tableWidget->item(edited->row(),0)->text()+"\' WHERE id=%1;";
            if(qry.exec(str.arg(rowid))){
                qDebug()<<"Edited";
            }
        }
        else if(edited->column()==1){
            QString str = "UPDATE Users SET password=\'"+ui->tableWidget->item(edited->row(),1)->text()+"\' WHERE id=%1;";
            if(qry.exec(str.arg(rowid))){
                qDebug()<<"Edited";
            }
        }
        else if(edited->column()==2){
            QString str = "UPDATE Users SET type=\'"+ui->tableWidget->item(edited->row(),2)->text()+"\' WHERE id=%1;";
            if(qry.exec(str.arg(rowid))){
                qDebug()<<"Edited";
            }
        }
    }
}


void MainWindow::on_pushButton_clicked()
{
    //QTableWidgetItem ტიპის მასივი list. ui->lineEdit->text()-იდან იღებს ტექსტს ამოწმებს თუ არის ეს
    // ტექსტი ცხრილში შემდეგ კი ავსებს list ცხრილს დამთხვეული QTableWidgetItem-ებით
    QList<QTableWidgetItem*> list=ui->tableWidget->findItems(ui->lineEdit->text(),Qt::MatchContains);
    for(int i=0; i<list.count(); i++){
      //  ui->tableWidget->selectRow(list.at(i)->row());

      //  list.at(i)->setBackground(Qt::red);
        list.at(i)->setSelected(true); //მონიშნე დამთხვეული ელემენტები
    }
}

