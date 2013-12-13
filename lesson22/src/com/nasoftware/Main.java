package com.nasoftware;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    static File file;         // სტატიკურ მეთოდში მეხსიერებიდან არ იშლება არაფერი
    public static void main(String[] args) {




            int moq;
        System.out.println("შეიყვანეთ მოქმედება");
        Scanner scans =new Scanner(System.in) ;  //სკანერს შემოყავს კლავიატურიდან
        moq= scans.nextInt();       // int ცვლადს ენიჭება კლავიატურიდან შემოყვანილი inti

                    if (moq==1) {
            String filename=null;       //   filenam ეს დროებით მივანიჭეთ
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter file name");
            filename = scan.nextLine();
            String url = "C:/Users/nikusha/Desktop/" + filename + ".txt";
            file = new File(url);


            try {
                file.createNewFile();    //ფაილის შექმნის მეთოდი
            } catch (IOException e) {    //ქეჩი
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }


               try {

                     String url1;
                   System.out.println("შეიყვანეთ ფაილის სახელი");
                   Scanner scan1 = new Scanner(System.in) ;     //ნაკადური ტექსტის მართველი
                   url1="C:/Users/nikusha/Desktop" + scan1.next() + ".txt" ;   //urls ვატყობინებთ თუ რომელ ფაილში გვინდა ტექსტის ჩაწერა
                   file = new File(url1); // ფაილს გადავცემთ მისამართს
                    Formatter out = new Formatter(file);      // ფორმატერი წერს ფილში
                    out.format("გამარჯობა\nGAMARJOBA");
                    Scanner scanFile = new Scanner(file);  //ვუთითებთ ფაილს
                    out.close();

                    while(scanFile.hasNext()){  //სანამ არის ინფორმაცია ფაილში
                        System.out.println(scanFile.nextLine());  //დაბეჭდოს ფაილიდან ინფორმაცია
                    }
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
           }
}





    /*  File paili =new File("C:/Users/nikusha/Desktop/nika.txt") ;
        try {
            if(!paili.exists())    '//თუ არ არის ფაილი შექმნილი
                paili.createNewFile();   //შექმენი

            Formatter out = new Formatter(paili);    //ფორმატერი არის ტექსტის ფორმატირების კლასი
            out.format("Hello World");              //ფორმატერი წერს paili-ში hello world

            out.close();

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
         *///
//        try {
//            if(!paili.exists())
//                paili.createNewFile();
//            Scanner scan =new Scanner(paili);
//            while(scan.hasNext()){
//                System.out.println(scan.nextLine());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//
//        }
  //  }


//}
