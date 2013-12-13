package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/9/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractClass {          // აბსტრაქტული კლასის ობიექტის შექმნა შეუძლებელია, მას შეიძლება ქონდეს აბსტრაქტული მეთოდები
    public  String name;                                  //რომლებიც იმპლემენტირების ან გადატვირთვის გარეშე არც არაფერს აბრუნებენ
    public abstract void speed();    //აბსტრაქტული მეთოდი აუცილებლად გადასატვირთია
    public String location(){

       return "Vazha Pshavela";
    }
    public abstract void distance();
}
