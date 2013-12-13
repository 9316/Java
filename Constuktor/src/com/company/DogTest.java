package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 11/13/13
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DogTest {
    String name;
    int age;

    public DogTest(String name, int age) {       //კონსტუქტორი
      this.name =name;
        this.age=age;
    }
    public  DogTest(){

    }

    @Override
    public String toString() {
        return name + age;
    }
}
