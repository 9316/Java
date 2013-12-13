package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/16/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Persons implements Struktura{  //person კლასის იმპლიმენტაცია struktur-ლი კლასის მეთოდებით
    private String name;    //privat ცვლადი
    private int age=20;               //
    private String sName="giorgi";



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void doJog() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void speedCalc() {
        ;//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void printInfo() {
       //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    // dizain paternebi
}
