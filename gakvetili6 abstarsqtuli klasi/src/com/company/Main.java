package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Kata>cats =new ArrayList<Kata>(); //კატა კლასის მასივი
        cats.add(new Lomi());        //ლომი კლასის ახალი ობიექტი
        cats.add(new Pantera());
        cats.add(new Saxliskata());

         for(Kata c : cats){  //კატა C ობიექტზე მიმთითებელი ტრილაებს cats ტიპის მასივიში ეს არის იტერატურული ციკლი
             c.dojob();
         }

    }
}
