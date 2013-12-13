package com.company;

public class Main {

    public static void main(String[] args) {
        college col = new college();
        col.distance();
        col.speed();
        System.out.println(col.location());
       col.name= "nika";
        System.out.println(col.name);


        Marjanishvili marj = new Marjanishvili();
        marj.distance();
        marj.speed();
        System.out.println(marj.location());

    }

}
