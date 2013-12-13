package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main {
    public static Connection con = null;  //დაკავშირების კლასი
    public static Statement st = null;  //SQLQuery
    public static PreparedStatement pst =null;
    public static ResultSet rs = null;      //SqlRecord
    public static final String USER = "nika";
    public static final String PASS = "nika123";
    public static final String insertInto = "INSERT INTO Users VALUES ('nika','nika123')";

    public static void main(String[] args) {
	    try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/lessonmysql", USER, PASS);
            st = con.createStatement(); //SqlQuery-ს შექმნა
            rs = st.executeQuery("SELECT * FROM Users");
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
            pst = con.prepareStatement("insert into Users (name, password, id) values (?, ?, 4)");
            pst.setString(1, "irakli");
            pst.setString(2, "ladolado");
            pst.executeUpdate();

            rs = st.executeQuery("SELECT * FROM Users");
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }




        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
