package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/24/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class hello extends Users {
  static  String name;
  static  String pass;
   static String keyname;
   static String keysurname;





     public static void helloo(){
         while(true) {
         Scanner scan = new Scanner(System.in);
         System.out.println("1) ადმინისტრატორით შესვლა");
         System.out.println("2) ჩვეულებრივი მომხმარებლით შესვლა");
         System.out.println("ამოირჩიეთ მოქმედება");
           moq = scan.nextInt();
         if(moq==1){
             Scanner newScaner = new Scanner(System.in) ;
             System.out.println("შეიყვანეთ ადმინისტარტორის სახელი");
             name=newScaner.nextLine();
             System.out.println("შეიყვანეთ ადმინისტარტორის პაროლი");
               pass= newScaner.next();
             if(name.equals("admin") && pass.equals("admin")){
                admin();
             }
            else System.out.println("პაროლი არასწორია");
         }
         if(moq==2){


    }
     }
}
}