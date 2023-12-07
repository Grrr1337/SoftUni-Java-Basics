

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberSequence {
        /*
            8.	Редица цели числа
            Напишете програма, която чете n на брой цели числа. Принтирайте най-голямото и най-малкото число сред въведените.
        */
    public static void main(String[] args) {

        Integer[] minmax = new Integer[]{0, 0};

        Scanner scn = new Scanner(System.in);
        // От първия ред на входа се въвежда броят числа n.
        Integer n = Integer.parseInt(scn.nextLine());
        // От следващите n реда се въвежда по едно цяло число.
        // int sum = 0;

        Integer inp;
        for(int i = 0; i < n ; i++){
            inp = Integer.parseInt(scn.nextLine());
            if (i == 0) {minmax[0] = inp; minmax[1]=inp;};
            if (minmax[0] > inp) {minmax[0] = inp;};
            if (minmax[1] < inp) {minmax[1] = inp;};
        }// for

        // int sum = list.stream().mapToInt(Integer::intValue).sum();
        // System.out.println(sum);
        System.out.printf("Max number: %s" + "\nMin number: %s", minmax[1], minmax[0]);

    }// main
}// class
