package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/18/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Martkutxedi extends shape {

    Martkutxedi(int a, int b, String n){   //კონსტრუქტორი  გამოიყენება კლასის შესავსებად
        sigane=a;
        sigrze=b;
        name = n;
    }

    @Override
    public void fart() {             //გადატვირთული fartobis მეთოდი
        System.out.print(sigrze*sigane + "\t"); //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void perimetr() {   //გადატვირთული პერიმეტრის მეთოდი
        System.out.print(2*(sigrze+sigane) + "\t");
    }
}
