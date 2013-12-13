package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 11/18/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintText {
    static  int printerCount = 0;
    public static String someTextToPoint;  // სტატიკური ცვლადი


    public PrintText(){   //კონსტრუქტორი
      printerCount++;
    }
      public static void printText(){         //სტატიკ მეთოდში შეუძლებელია არასტატიკური ცვლადების გამოყენება
          someTextToPoint="ტექსტი";
          System.out.println(someTextToPoint);
      }

    public  static void printNumberTon(int n){     //სტატიკური მეთოდი printNumberton რომელსცას გადავცემთ int პარამეტრს
        for(int i=0; i<=n; i++){     //  i ნაკლებია ან ტოლია
            System.out.println(i + " მაგარია");
        }
    }


    }

