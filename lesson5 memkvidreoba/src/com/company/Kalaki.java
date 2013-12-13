package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/11/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kalaki extends Kveyana {      //  kalakis deda aris kvekaan
  public double lon;
  public  double latitude;
  public int year;

    public Kalaki(String n, int a, int p, String r, double l, double la, int y) {
        name = n;
        area = a;
        popularity=p;
        religion =r;
        lon = l;
        latitude = la;
        year =y;
    }

   public String toString(){
      return name + " " + area + " " + popularity + " " + religion+ " "+ lon + " " + latitude +  " " + year;

   }
   public String printAll(){
        return name + " " + area + " " + popularity + " " + religion+ " "+ lon + " " + latitude +  " " + year;
   }

}
