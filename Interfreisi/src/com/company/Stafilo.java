package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 11/11/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Stafilo implements Cveni,banani{   //ინტერფეის კლასების იმპლიმენტაია


    @Override
    public void myJuic() {
        System.out.println("გააკეთე წვენი..");
    }

    public void grow(){
        System.out.println("სტაფილო იზრდება..");
    }
@Override
    public void tropic() {
    System.out.println("ბანანი");
    }
}
