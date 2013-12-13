package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/16/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Struktura{    //სტრუქტურის (ინტერპრეისი) ობიქტის შექმნა არ შეიძლება , და ნებისმიერი მეთოდი არის აბსტრაქტული და უნდა გადავტვირთოდ მეთოდები იმპლიმენტირბულ კლასში

    void doJog();         //მეთოდები
    void speedCalc();
    void printInfo(); //ინფორმაციის დასაბეჭდი მეთოდი აუცილებლად უნდა გადაიტვირთოს პერსონს კლასის შესაბამისად

}
