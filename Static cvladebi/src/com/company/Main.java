package com.company;

public class Main {

    public static void main(String[] args) {

   PrintText p = new PrintText();     //PrintText კლასის ახალი ობიექტი
   PrintText p2 = new PrintText() ;
       //PrintText.printNumberTon(50);

       // p.printText();  //printText მეთოდის გამოძახება


   System.out.println(PrintText.printerCount);  //რადგან გვაქვს 2კლასის ობიექტი

    }
}
