package com.company;

import com.sun.webpane.platform.WebPageClient;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import  java.sql.SQLException;
import  java.util.Date;

public class Main {
   public static Connection con=null;  //დამაკავშირებელი კლასი
   public static Statement st=null;   //ბრძანებების კლასი იგივე(Query)
   public static ResultSet rs=null;  // ეს კლასი ინახავს sql-დან დაბრუნებულ ინფორმაციას(record)
    public static JTextField textField1;
    public static  JPasswordField pass;
    public static JLabel  label = new JLabel("მომხამარებელი");
    public static JLabel label2 = new JLabel("პაროლი");
    public static JButton button = new JButton("OK");

    public static void main(String[] args) {







        try{
            Class.forName("com.mysql.jdbc.Driver"); //ვუთითებთ რომ ვმუშაობთ (MYSQL)-დრაივერზე
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306//lessonmysql");
            st = con.createStatement(); //ბრძანებების კლასის შექმნა (Query)

      //String info = "SELECT * FROM persons"; //მონიშნე ყველაფერი persons-ს ბაზიდან
            rs = st.executeQuery("SELECT * FROM Users");  //შეასრულე ბრძანება გადაცემული (Query)-მიხედვით
            while (rs.next()){  //სანამ არის ინფორმაცია
                String name = rs.getString("name"); //აბრუნებს სტრინგად person ბაზაში არსებულ ინფორმაციას

                System.out.println("სახელი " + name );
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

