package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Transporti> tran =new ArrayList<Transporti>();
        tran.add(new Sahaerotransporti());
        tran.add(new Saxmeletotransporti());
        tran.add(new Sazgvaotransporti());

       for(Transporti t : tran){
            t.dojob();
           }
    }
}

