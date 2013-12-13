package com.company;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

/**
 * ალექსანდრე პატარიძე
 * Date: 9/22/13
 * Time: 7:57 PM
 */
public class GuiMain{
    private JTable table1;
    private JPanel panel1;
    private JToolBar toolbar;
    private JButton buttonSearch;
    private JScrollPane scroller;
    private JButton buttonAdd;
    Connection c = null;       //დაკავშირების კლასი
    Statement st = null;       //QSqlQuery
    String searchMed;
    TableRowSorter<TableModel> sorter= null;
    String newMedName;
    String newMedDescr;
    JTextField fieldName;
    JTextField fieldDescr;
    DefaultTableModel model;


    public GuiMain(){
        try{
            Class.forName("org.sqlite.JDBC");             //ვმუშაობთ sqlite მონაცემთა ბაზაზე
            c= DriverManager.getConnection("jdbc:sqlite:/home/alex/medicines.db");    //ვუკავშირდებთ ბაზას


            c.setAutoCommit(true); //ცვლილებების ავტომატურად ჩაწერა ბაზაში
            st = c.createStatement(); //    QSqlQuery-ის შექმნა

            String sql;
            sql = "SELECT id, name, description, price, amount FROM med;";
            ResultSet rs = st.executeQuery(sql);   //QSqlRecord ინახავს მონაცემთა ბაზიდან დაბრუნებულ ინფორმაციას

        //    table1.setModel(DbUtils.resultSetToTableModel(rs)); //ცხრილის მოდელის ავტომატურად გენერირება

            ResultSetMetaData rd = rs.getMetaData();  //სქლ-იდან დაბრუნებული ინფორმაციის ზოგადი მონაცემები
            Vector columns =new Vector();         //ვექტორის შექმნა
            Vector data = new Vector();
            int columnCount = rd.getColumnCount();   //სქლ-ის ცხრილის სვეტების რაოდენობა
            for(int i=1; i<=columnCount; i++){
                columns.addElement(rd.getColumnName(i));    ///ვექტორში სვეტების სახლების ჩამატება
            }
            while(rs.next()){
                Vector row = new Vector(columnCount);  //სტრიქონების ვექტორის შექმნა
                for(int i=1; i<=columnCount; i++){
                    row.addElement(rs.getObject(i));   //სქლ-იდან დაბრუნებ
                }
                data.addElement(row);              //DATA ვექტორში სტრიქონების       ვექტორის დამატება
            }
            model = new DefaultTableModel(data, columns){   //ცხრილის კლასის ობიექტის შექმნა
                @Override
                public boolean isCellEditable(int row, int column) {      // DefaultTableModel-ის კლასის მეთოდის გადატვირთვა იმისთვის რომ არ იყოს რედაქტირებადი
                    return false;
                }
                public Class getColumnClass(int column){
                    Class returnValue;
                    if((column>=0) && (column<getColumnCount())){
                        returnValue = getValueAt(0,column).getClass();
                    }
                    else{
                        returnValue=Object.class;
                    }
                    return returnValue;

                }
            };

            TableColumn col;      //ცხრილის სვეტის ობიექტი
            for(int i=0; i<table1.getColumnCount(); i++){
                col=table1.getColumnModel().getColumn(i);   //ცხრილის ყველა სვეტი ენიჭება col-ს
                col.setMaxWidth(250);                      //მაქსიმალური სიგანე 250
            }

            table1.setModel(model);  //სვინგის ცხრილის ძირითადი ცხრილის მოდელი, რომელიც დაფუძნებულია data და columns ვექტორებზე
            sorter = new TableRowSorter<TableModel>(model);  //QSqlProxyModel -ის მსგავსი
            table1.setRowSorter(sorter);             //სორტერს ვაყენებთ სტრიქნების გასაფილტრად

            table1.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("სახელი");   //მესამე სვეტს ვარქმევტ "სახელი"-ს

            //table1.getTableHeader().getColumnModel().removeColumn(table1.getColumnModel().getColumn(0)); // ვშლით პირველ სვეტს ცხრილში

            table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //მხოლოდ ერთის მონიშვნის უფლება


            ActionListener search = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    searchMedMeth();
                }
            };



            table1.addKeyListener(new KeyListener() {    //კლავიატურის მომსენი ცხირლზე
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == 'f')
                        searchMedMeth();
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
            buttonSearch.addActionListener(search);

            buttonAdd.addActionListener(new ActionListener() {
                void addNewMedMeth(){
                    newMedName = fieldName.getText();
                    newMedDescr = fieldDescr.getText();
                    String sql = "INSERT INTO med (name, description) VALUES ('" +  newMedName + "','" + newMedDescr + "');";
                    try {
                        if(!st.execute(sql)){ //თუ არ დააბრუნა შეცდომა
                            String []data = {"","",newMedName,newMedDescr};      //შექმენი სტრინგების ახალი მასივი
                            model.addRow(data);               //მოდელს დაამატე მასივი
                            System.out.println(sql);

                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                @Override
                public void actionPerformed(ActionEvent e) {

                    JFrame frameAdd = new JFrame("წამლის დამატება");
                    JPanel panelAdd  = new JPanel(new GridLayout(3,2));  //პანელი იყენებ გრიდ ლეიაუტს
                    ActionListener actionAddMed = new ActionListener() { //ექშენ ლისენერის ობიექტის შექმნა
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            addNewMedMeth();                    //წამლის დამატების მეთოდი
                        }
                    };

                    fieldName = new JTextField();
                    fieldDescr = new JTextField();
                    JLabel labelName = new JLabel("წამლის სახელი");
                    JLabel labelDesc = new JLabel("წამლის აღწერა");
                    panelAdd.add(labelName);           //პანელზე ობიექტების დამატებები
                    panelAdd.add(fieldName);
                    panelAdd.add(labelDesc);
                    fieldDescr.addKeyListener(new KeyListener() {     //კლავიატურის მომსმენის დამატება
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                            if(e.getKeyCode()==KeyEvent.VK_ENTER)   //თუ დაჭერილია ენტერი
                                addNewMedMeth();            //წამლის დამატების მეთოდი
                        }
                    });
                    panelAdd.add(fieldDescr);
                    JButton buttonAddNewMed = new JButton("დამატება");
                    panelAdd.add(new JSeparator());  //ადგილის გამომყოფი ობიექტის დამატება პანელზე
                    panelAdd.add(buttonAddNewMed);



                    buttonAddNewMed.addActionListener(actionAddMed);  //წამლის დამატების ღილაკზე ლისენერის დადება
                    frameAdd.setContentPane(panelAdd);       //მთავარი შიგთავსი მოთავსებულია პანელზე

                    frameAdd.setSize(new Dimension(250,100));     // ზომების მიცემა
                    frameAdd.setVisible(true);
                }
            });

        }
        catch (Exception e){
            e.printStackTrace();
        }
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount()==2) {             //თუ დაკლიკულია ორჯერ
                    System.out.println("ახალი JFrame იქნება აქ");
                }
            }
        });

    }

    public void searchMedMeth(){
        String search = JOptionPane.showInputDialog(null, "შეიყვანეთ წამლის სახელი");
        if(search.length()==0)         //თუ არაფერი არაა შემოყვანილი
            sorter.setRowFilter(null);   //ფილტრი გათიშულია
        else
            sorter.setRowFilter(RowFilter.regexFilter(search)); //ფილტრი დაფუძნებულია search-ზე
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("GuiDB");
        JMenuBar menu = new JMenuBar();           //ფაილ მენიუ
        JMenu file = new JMenu("ფაილი");        //ცალკე მენიუ
        JMenuItem menuExit = new JMenuItem("გამოსვლა"); //მენიუს ერთ-ერთი ელემენტი
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(menuExit);
        menu.add(file);
        frame.setJMenuBar(menu);
        frame.setContentPane(new GuiMain().panel1);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
