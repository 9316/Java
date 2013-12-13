package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    public static void main(String[] args) {
        while(true) {       //ციკლი ტრიალებს
            int moq;
        System.out.println("შეიყვანეთ მოქმედება");
        scan = new Scanner(System.in);
        moq=scan.nextInt();
          if(moq==1){
              shekmna();     //მეთოდის გამოძახება
          }
           else if(moq==2){
              chacera();
          }
            else   {
              cakitxva();
          }
    }
    }

        public static void shekmna(){
              try{
                    String filename;
                  String url1;
                  Scanner newscan = new Scanner(System.in) ;     //კსკანერის ობიექტის შექმნა რომელიც ელოდება კლავიატურიდან სტრინგ
                       System.out.println("შეიყვანეთ ფაილის სახელი");
                       filename = newscan.nextLine(); //ფაილის მიენიჭა კლავიატურიდან შემოტანილი სტრინგი

                           url1 = "C:/Users/nikusha/Desktop/" +  filename +".txt" ;  //urls გადაეცემა მისამართი + filename stringi
                           File paili =new File(url1) ;  //ფაილის ოქბიექტს გადავცემთ url მისამართს

                            paili.createNewFile();   // ახალი ფაილის შექმნა


        }
              catch(Exception e){e.printStackTrace();}    //იჭერს შეცდომებს
      }
      public static void chacera(){
          try {
          String url;
          String text;
          Scanner newscan = new Scanner(System.in);    //სკანერი ნაკადური ტექსტის მართველი
          System.out.println("რომელ ფაილში გინდათ ჩაწერა");
          String filename = newscan.nextLine();

          System.out.println("enter text");
          text = newscan.nextLine();
          url="C:/Users/nikusha/Desktop/" + filename +".txt";



                Formatter format= new Formatter(url);  //ტექსტის ფორმატირების კლასი
              format.format(text ); // ფორმატი წერს ტექსტს Filenameshi
              format.close();       //ნაკადების ჩაწერა
          } catch (FileNotFoundException e) {
              e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
          }


      }
    static void cakitxva(){
        try {
        String fileName;

        Scanner newscan = new Scanner(System.in); //სკანერი არის ნაკადური მართველი
        System.out.println("რომელი ფაილის წაკითხვა გინდათ");
        fileName = newscan.next();   // filename ენიჭება კლავიატურიდან შემოტანილი სტრინგი

            Scanner scan2 = new Scanner(new File("C:/Users/nikusha/Desktop/" + fileName + ".txt"));
            while(scan2.hasNext()){       //while cikli სანამ ფაილი არ არის ცარიელი
                System.out.println(scan2.nextLine()); //წაიკითხოს ინფორმაცია
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
  }
