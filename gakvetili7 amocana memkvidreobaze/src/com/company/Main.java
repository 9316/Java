package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<shape>list=new ArrayList<shape>();
        String url;
        url="C:/Users/nikusha/Desktop/info.txt";
        Scanner scan= null;
        try {
            scan = new Scanner(new File(url));  //scnaeris axal fails gavcemt url misamarts
            String temp;

        while(scan.hasNext()){       //sanam aris informacia
            temp = scan.next();      //temps vanichebt failidan shemosul stringebs
            System.out.println(temp);  //log // bechdavs pailidan shemsul stringebs
                if(temp.equals("tr")){  //tu emtxveva pailidan shemosuli tr
                list.add(new Samkutxedi(scan.nextInt(),scan.nextInt(),"სამკუთხედი"));
                    //list maasivis gadvcemt samkutxedis axal opbieqts da shemdeg gadavcemt sigrzes da siganes
            }

            else if(temp.equals("rec")){
                list.add(new Martkutxedi(scan.nextInt(),scan.nextInt(),"მართკუთხედი"));

            }
            else if(temp.equals("sq")){

                list.add(new Otkutxedi(scan.nextInt(), "კვადრატი"));

            }
        }
        for(shape s:list) {            //iteraciuli cikli
            System.out.print(s.name+ "\t");     //bechdavs s.names saxelebs
            s.fart();                 //partobs
                                       //da perimetrs
            s.perimetr();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
