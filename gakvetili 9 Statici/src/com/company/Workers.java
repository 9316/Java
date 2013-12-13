package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: nikusha
 * Date: 10/23/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Workers {
    String name;
    String lastName;
    static String company; //სტატიკური ცვლადი  ობიექტის შექმნის გარეშეც შეგვიძლია გამოზახება  მინიჭება და სტატიკური ცვლადი ეკუთვნის მთლიანად კლასს
    int age;

    public Workers(String name, int age, String lastName) {  //პარამეტრიანი კონსტრუქტორი
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }
    public Workers(){
                          //უპარამეტრო
    }

    @Override
    public String toString() {
        return "Workers{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", company name=" + company +
                '}';
    }
}
