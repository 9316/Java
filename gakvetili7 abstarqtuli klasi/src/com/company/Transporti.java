package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/18/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Transporti {
    public String name;
    public String speed;

    public  void dojob(){
        System.out.println("ტრანსპორტის მოძრაობა");

   }

   Transporti(String n, String s){
       name=n;
       speed=s;
   }
    Transporti(){
                      //imitom gavketet uparameto konstuktori rom konstruktori memkvidreobit ar gadaecema
    }

    @Override
    public String toString() {
        return name+ speed;

    }
}
