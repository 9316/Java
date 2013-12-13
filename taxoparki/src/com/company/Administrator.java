package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/23/13
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Administrator {

   static int moq;
  static  String name;
   static String lastName;
    public static void admin(){

       while(true){

    Scanner scan = new Scanner(System.in);
    System.out.println("ამოირჩიეთ მოქმედება ");
    System.out.println("1) მომხმარებლის დამატება");
    System.out.println("2) მომხმარებლის ინტერფეისით შესვლა");
    System.out.println("3) სისტემიდან გამოსვლა");
       moq = scan.nextInt();
        String url;
       Scanner scan2= new Scanner(System.in);
               if(moq==1){
           System.out.println("შეიყვანეთ მომხმარებლის სახელი");
             name =scan2.nextLine();
            System.out.println("შეიყვანეთ მომხამარებლის პაროლი");
           lastName=scan2.nextLine();
                url="C:/Users/nikusha/Desktop/panoza.txt";
                 try{
                 Formatter format = new Formatter(url);
                format.format(name);
                     format.format(lastName);

                format.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            System.out.println("მომხმარებელი დაემატა");

    }
        if(moq==2){
           Users.user();
        }


    }
}
}