package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            File paili=new File("C:/Users/nikusha/Desktop/nika"); // File კლასის pail ობიექტს გადავცემთ მისამართს
            File[] f= paili.listFiles();   // File კლასის f  მასივი   მიუთითებს pail-ების  სია
            System.out.println("ყველა ფაილი არის ფოლდერში" + paili.getName() + "without directories are ");

            for(int i=0; i<f.length; i++){   //ციკლი რომელიც ტრილაებს f მასივის ზომამდე
                if(f[i].isFile()){         //თუ მასივი f[i]-ი არის დირექტორი
                    String name = f[i].getName();
                    System.out.println(name);    //დაბეჭდე directory  ტიპის ფაილები
                    f[i].delete();
                }
            }


    }
}
