package com.company;

import com.sun.org.apache.xpath.internal.operations.And;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

     String name = JOptionPane.showInputDialog(null,"შეიყვანეთ სახელი ");
     String password=JOptionPane.showInputDialog( null, "შეიყვანეთ პაროლი ");
        if(name.equals("nika") && password.equals("1")){
            System.out.println("ავტრიზაცია წარმატებულია");
        }
        else {
            System.out.println("ავტროიზაცია წარუმატებელია");

        }

    }
}
