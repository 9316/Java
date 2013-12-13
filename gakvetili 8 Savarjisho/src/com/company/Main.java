package com.company;

public class Main {                     //for(;;) ეს არის  while(true) სამუდამო ციკლი

    public static void main(String[] args) {
        for(int i=1; i<11; i++){  //ციკლი ტრილიალებს 10მდე
            for(int j=1; j<=i; j++){ // თავიდან ურდრის  int i=1 და j ნაკლებია ან ტოლია i გაზარდე ყოველ ჯერზე
                System.out.print(8); //დავაბეჭდინეთ 8

            }
            System.out.println();  //გადაგვყავს შემდეგ ხაზე ეკრანზე გამოსული ტექსტი   //გადადის int i-ზე და ზრდის ერთით

        }


    }
}
