package com.company;

import javax.swing.*;                                //parent  - მშობელი

public class Main {
    static String info = "Hello World";

    public static void main(String[] args) {
        //JOptionPane - მოკლე ტექსტური შეტყობინებების კლასი.მოიცავს სტატიკუ მეთოდებს
        String name = JOptionPane.showInputDialog("შეიყვანეთ თქვენი სახელი");  //showInputDialog არის ტექსტის შესაყვანი დიალოგური ფანჯარა
       if( JOptionPane.showConfirmDialog(null, "ყოფნა არ ყოფნა?!", " შეკითხვა",JOptionPane.YES_NO_OPTION )==
               JOptionPane.YES_OPTION){   // თანხმობის ან უარყოფის დიალოგური ფანჯარა
          JOptionPane.showMessageDialog(null, "გამარჯობა", "ინფომაცია",JOptionPane.INFORMATION_MESSAGE);
       }







       // JOptionPane.showMessageDialog(null, info, "Title", JOptionPane.INFORMATION_MESSAGE);   //ubralod shetyobinebis klasi



    }


}
//statiicis გამოძახება შესაძლებელია ობიქტის შექმნის გარეშე ანუ სტატიკ ცვლადი ეკუთვნის არა კლასის ობიექტს არამედ მთლიანად კლასს
//აბსტარქტულ კლასში შესაძლებელია static ცვლადის შექმნა
