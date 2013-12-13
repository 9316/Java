package com.company;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    static JTextField field;   //JtextField ეს არის ტექსტის შესაყვანი ველი(lineEdit);
    static JLabel label;       //ლეიბელი

    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
//
//        String k=scan.next();
//        System.out.println(k.substring(k.length()-1));
//

        try {
            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel()); //პროგრამის იერსახე
        } catch (UnsupportedLookAndFeelException e) {            //იჭერს შეცდომებს
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String name;
        JFrame frame = new JFrame("Hello World");    //ეს არის  მთავარი ფანჯარა
        label = new JLabel("გამარჯობა");
        JButton button = new JButton("ok");
        field = new JTextField();
        field.setPreferredSize(new Dimension(200,20));   //ამით ვანიჭებთ lineEditis ზომას
        button.addActionListener(new ActionListener() {    //ღილაკზე თუ შეიცვალა რაიმე რო დავაჭერთ აფიქსირებს და იძახებს მეთოდს
            @Override
            public void actionPerformed(ActionEvent e) {  //ActionListener ინტერფეისის გადასატვირთი მეთოდი
                if (field.getText().length() > 0) {     //თუ არის true

                    //substring მეთოდის დახმარებით ჩვენ შეგვიძლია სტრიქონის ნაწილი გამოვიყენოთ
                    if(field.getText().substring(field.getText().length()-1).equals("a")){  // ვიყენებთ ტექსტის ბოლო ასოს
                        label.setText(field.getText()+"m");      //იღებს შემოყვანილ ტექსტს ამატებს "მ"-ს და წერს ლეიბელზე
                    }
                } else
                    JOptionPane.showMessageDialog(null, "შეიყვანეთ სახელი");
            }
        });
        frame.setLayout(new FlowLayout());   //ყველაზე მარტივი ლეიაუთის დაყენება
        frame.add(label);                    //ლეიბელის დამატება ფანჯარაზე
        frame.setSize(400, 200);            //ფანჯარის ზომის გაწერა
        frame.setResizable(false);           //უნდა იყოს თუ არა ფანჯარა ზრდადი
        frame.add(button);                  ///ღილაკის დამატება
        frame.add(field);                //ტექსტის ველის დამატება
        frame.setLocationRelativeTo(null);  //აპლიკაციის ცენტრში მოთავსება

        frame.setVisible(true);    //ფანჯრის გამოჩენა

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //გათიშვის ღილაკის მეთოდის მითითება
    }
}
