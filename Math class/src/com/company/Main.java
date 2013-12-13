package com.company;

public class Main {

    public static void main(String[] args) {
	double d1 = Math.random(); //random გვიბრუნებს შემთხვევით აღებულ რიცხვს
        System.out.println(d1);

      int i1 = Math.abs(-100); //abs მეთოდი გვიბრუნებს აბსოლიტრუ მნიშვნელობას გადაცემული რიცხვის
        System.out.println(i1);

      int i2 = Math.round(25.7f); //roudn მეთოდი ამრგვალებს რიცხვებს თუ f-ს არ მივუწერთ იგი აღიქვამს double ტიპად
        System.out.println(i2);

      int i3 = Math.min(45,35); //min მეთოდი გვიბრუნებს ორ რიცხვს შორის უმცირეს
        System.out.println(i3);

      int i4 = Math.max(78, 100);  //max მეთოდი გვიბრუნებს ორ რიცხვს შორის მაქსიმუმს
        System.out.println(i4);

        //Math კლასის ობიექტს ვერ შევქმნით იმიტომ რომ Math კლასის კონსტრუქტორი არის private
        //Math კლას გააჩნია სტატიკური მეთოდები  პირდაირ შეგვიძლია მათი გამოყენება


    }
}
