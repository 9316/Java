package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/18/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Otkutxedi extends shape {    // ოთკუთხედ კლასს ვუთითებთ რომ ის არის shape-ის შვილი
    Otkutxedi (int a, String n){
        sigrze=a;
        name = n;

    }
    @Override
    public void fart() {                //გადატვირთვა
        System.out.print(sigrze*sigrze + "\t");
    }

    @Override
    public void perimetr() {
        System.out.print(sigrze*4 + "\t");
    }
}
