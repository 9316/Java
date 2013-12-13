#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QSqlDatabase>
#include <QtDebug>
#include <QCoreApplication>
#include <QSqlQuery>
#include <QSqlRecord>
#include <QDesktopWidget>
#include <QTableWidgetItem>
#include <authdialog.h>


namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT
    
public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();
    QSqlDatabase db;
    QString fileName;
    QString loginType; //მომმხარებლის ტიპი
    int userCount; //მომხმარებელთა რაოდენობის მთვლელი
    void noEdit(); //ფუნქცია აუქმებს ნებისმიერ ღილაკს თუ სხვა ელემენტის გამოყენების ოფციას
    bool opened; //გახსნილია თუ არა მონაცემთა ბაზის ფაილი
    
private slots:
    void on_actionOpen_triggered();
    
    void on_actionDelete_triggered();

    void on_actionAbout_triggered();

    void on_actionAdd_triggered();

    void onItemChanged(QTableWidgetItem*); //ჩვენი ხელოვნურად შექმნილი სლოტი, იჭერს შეცვლილი QTableWidgetItem-ზე მიმთითებელს


    void on_pushButton_clicked();

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H
