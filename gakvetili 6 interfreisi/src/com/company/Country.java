package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/16/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Country implements Struktura { //კლასსი Country-ის იმპლიმენტაცია strukturuli  ინტერფრეის მეთოდებით

    @Override           //გადატვირთვა doJog მეთოდის
    public void doJog() {
        System.out.println("giaa");//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override    //   გადატირთვა speedCalc მეთოდის
    public void speedCalc() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override        //გადატვირთვა  PrintInfo მეთოდის
    public void printInfo() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
