package com.company;


public class Main {
    public static final String PREFS = "PREFS"; //finali არის იგივე კონსტანტა
    public static final double PI = 3.14;      //თავიდან გაკეთებულ ინიციალიზაციაზე Prefs და შემდეგ ვერაფერს ვერ მიანიჭება
   static double a = 4.15;

    public static void main(String[] args) {

        System.out.println(PREFS + " " + " nastroikebi");
        double j =  a +PI ;
        System.out.println(j);
        System.out.println(PI);


    }
}

// hashCode უნიკლაური კოდი ის აბრუნებს  MD5 ეს არის კოდირებული ინფორმაცია