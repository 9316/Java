package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(); //შევქმენით ArrayList კლასის ობიექტი list რომელიც ინახავს int ცვლადებს
        list.add(3);     //მიუხედავად იმისა რომ add მეთოდი რომელიც int ტიპის მნიშვნელობას მიიღებს და ჩაამატებს მნიშვნელობას ArrayList-ში არ არსებობს ჩვენ შეგვიძლია ეს გამოვიყენოთ და ამას ქვია Autoboxing
       int num = list.get(0);    //ამ შემთხვევაში კომპილერი ავტომატურად მოახდენს გადაკასტვას და მოახდენს სასურველი მეთოდის გამოძახებას
        System.out.println(num);
       Number(45);         //autBoxing-ის მეშვეობით პირდაპირ გავადავცით int მნიშვნელობა
        System.out.println(getNum());   //დავაბეჭდინეთ მეთოდი getNum-ი რომელიც აბრუნებს 99
    }

    public static void Number (Integer i ){  //პარამეტრიანი მეთოდი
        System.out.println(i);
    }

    public static  int getNum(){
        return 99;
    }
}
