package com.company;

public class Main {

    public static void main(String[] args) {
        Persons person = new Persons();
        Country cou = new Country();
      person.setName("ნიკა");
       // person.setAge(20);
        cou.doJog();
        System.out.println(person.getName());




    }
}

