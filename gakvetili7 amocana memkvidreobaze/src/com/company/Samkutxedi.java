package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/18/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Samkutxedi extends shape {




    Samkutxedi(int a, int b, String n){
        sigane=a;
        sigrze=b;
        name = n;
}
 @Override
    public void fart() {
     System.out.print(sigrze*sigrze*3.14 + "\t"); //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void perimetr() {
        System.out.print(2*sigrze*3.14 + "\t");
    }
}
