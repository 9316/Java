#include "authdialog.h"
#include "ui_authdialog.h"
#include <QMessageBox>
authDialog::authDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::authDialog)
{
    ui->setupUi(this);
    auth=false;
    log = QSqlDatabase::addDatabase("QSQLITE");
    log.setDatabaseName("/home/alex/login"); //კითხულობს home დირექტორიიდან ლოგინ ბაზას
    log.open(); //ხსნის ბაზას
    setWindowTitle("ავტორიზაცია");
}

authDialog::~authDialog()
{
    delete ui;
    log.close();
}

void authDialog::on_pushButton_clicked()
{
    QString user,pass;
    user = ui->lineEdit->text(); //ანიჭებს user სტრინგს ტექსტს ლაინედიტიტდან
    pass= ui->lineEdit_2->text();
    QSqlQuery qry;
    //მონიშნე სახელი პაროლი და ტიპი უზერ ცხრილიდან
    if(qry.exec("SELECT username, password, type FROM Users WHERE username=\'"+
                user + "\' AND password=\'" + pass + "\'")){
        if(qry.next()){
            auth=true; //ავტორიზაცია წარმატებულია ბულ ცვლადი
        }
        else
            auth=false;
    }
    if(auth){
        this->close();
    }
    else{
        QMessageBox::warning(this,"შეცდომა","ხელახლა შეიყვანეთ სახელი და პაროლი");
    }


}
