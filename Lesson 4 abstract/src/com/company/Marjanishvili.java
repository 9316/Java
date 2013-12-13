package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/9/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Marjanishvili extends AbstractClass{
    @Override         //გადავტვირთ
    public void speed() {
        System.out.println("Max speed is 60km/h");
    }


    @Override
    public void distance() {
        System.out.println("80KM");
    }

    public String location(){
        return "Marjanishvili";
    }
}
