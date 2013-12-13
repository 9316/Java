package com.company;

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
public class Users extends Administrator {
  static  String date;
   static int taxNumber;
   static int reisisXang;
   static int manzili;
   static int shemosavali;
   static String url;
   static Scanner scan1 = new Scanner(System.in);
    public static void user() {
        System.out.println("შეიყვანეთ თარიღი");
        date = scan1.nextLine();
        System.out.println("შეიყვანეთ სამარშუტო ტაქსის ნომერი");
        taxNumber = scan1.nextInt();
        System.out.println("შეიყვანეთ ერთი რეისის ხანგძლივობა");
        reisisXang = scan1.nextInt();
        System.out.println("შეიყვანეთ სრული მანძილი კილომეტრებში");
        manzili = scan1.nextInt();
        System.out.println("დღის შემოსავალი");
        shemosavali =scan1.nextInt();
          url = "C:/Users/nikusha/Desktop/nikushaa.txt";
        try {
            Formatter format = new Formatter(url);
            format.format(date + " " + taxNumber + " " + reisisXang + " " + manzili + " " + shemosavali );
format.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
