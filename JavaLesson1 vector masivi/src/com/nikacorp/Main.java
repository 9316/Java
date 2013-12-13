package com.nikacorp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/2/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
                                        //ჰედერი


    public static void main(String[] args) {
            ArrayList<Persons>personz = new ArrayList<Persons>();    //arrayList არის ვექტორის მასივი რომელსაც ჭირდება ყოველთვის ახალი ობიექტი
        personz.add(new Persons("nika","nika",45));     // პერსონ კლასს ვამატებთ ახალი პერსონ კლასსის ახალ ობიექტს ვავსებთ კონსტრუკტორით
        Scanner scan = new Scanner(System.in);    //სკანერი არის ნაკადების მართველი კლასსი
        System.out.println("შეიყვანეთ სახელი");
        String name=scan.nextLine(); //name ვანიჭებთ კლავიატურიდან შემოყვანილ int-ს
        System.out.println("შეიყვანეთ გვარი");
        String username = scan.nextLine();     //username  ვანიჭებთ კლავიატურიდან შემოყვილ strings
        System.out.println("შეიყვანეთ ასაკი");
        int yers = scan.nextInt();   //scan არის იგივე  cin კლავიატურიდან და ფაილიდან შემყვანი
        personz.add(new Persons(name,username,yers)); // ვექტორ მასივს ვავსებთ ცვლადებით
        Persons p = new Persons(name,username,yers);   //პერსონს კლასის ობიექტს ვავსებთ ცვლადებით
        personz.add(p);     //ვექტორ მასივის შევსება
        for(int i=0; i<personz.size(); i++){   //i  ითვლის personz მასივის ზომას
            System.out.println(personz.get(i).name);     //ვბეჭვდავთ personz მასივის name ცვლადს
            System.out.println(personz.get(i).username);
            System.out.println(personz.get(i).yers);
        }
        System.out.println(personz);





    }

}
