package com.company;

public class Main {

    public static void main(String[] args) {

	    Workers.company = "GIG LTD.";   //კომპანიის სახელია თავიდან gig


        Workers w = new Workers("Giorgi", 20, "Sirbiladze");     //შევავსეთ კონსტუქტორის საშვალებით

        Workers w2 = new Workers("Akaki", 45, "Gogrichiani");

        System.out.println(w);       // ეს დაბეჭდავს გიორგი სირბილადძე კომპანია GIG

        w.company="Old Navy LTd";      //კომპანისს სახელი გახდა Old navy

        System.out.println(w2);       //  ეს დაბეჭდავს აკაკი გოგრიჭიანი კომპანია Old NAvy

        System.out.println(w);            // ეს დაბეჭდავს გიორგი სირბილადძე კომპანია Old NAvy


        w2.company = "Kata LTD";            //კომპანია გახდა kata

        System.out.println(Workers.company);      //დაბეჭდავს katas

        Workers w3 = new Workers("giori", 29, "vadachkoria");
        w3.company = "Na software LTD";
        System.out.println(w3);

        System.out.println(w3.company); //ეს დაბეჭდავს კომპანიას Na software




    }
}
