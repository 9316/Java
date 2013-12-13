package com.nikacorp;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/2/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Persons {
    String name;      //შევქმენით  ცვლადები
    String username;
    int yers;

    public Persons(String n, String u, int y) {   //კონსტუქტორი
        name= n;
        username=u;
        yers=y;
    }
    @Override
    public String toString(){  //    tostring არის ჩვენ მიერ გადატვიღტული დედა კლასსის(object)-ის to string

        return name + " " + username + " " + yers;
    }
}
