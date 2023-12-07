

import java.util.Scanner;

public class SumNumbers {
    /*
        7.	Сумиране на числа
        Да се напише програма, която чете n-на брой цели числа, въведени от потребителя и ги сумира.
        •	От първия ред на входа се въвежда броят числа n.
        •	От следващите n реда се въвежда по едно цяло число.
        Програмата трябва да прочете числата, да ги сумира и да отпечата сумата им.
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        // От първия ред на входа се въвежда броят числа n.
        Integer n = Integer.parseInt(scn.nextLine());
        // От следващите n реда се въвежда по едно цяло число.
        int sum = 0;
        for(int i = 0; i < n ; i++){
           sum += Integer.parseInt(scn.nextLine());
        }// for

        System.out.println(sum);

    }// main
}// class
