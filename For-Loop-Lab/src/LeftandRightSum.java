
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeftandRightSum {
    /*
        9.	Лява и дясна сума
        Да се напише програма, която чете 2 * n-на брой цели числа, подадени от потребителя,
        и проверява дали сумата на първите n числа (лява сума) е равна на сумата на вторите n числа (дясна сума).
        При равенство печата " Yes, sum = " + сумата; иначе печата "
        No, diff = " + разликата. Разликата се изчислява като положително число (по абсолютна стойност).

    */
    public static void main(String[] args) {

        Integer[] sum =new Integer[]{0,0};

        // List<Integer> list = new ArrayList<Integer>();

        Scanner scn = new Scanner(System.in);
        // От първия ред на входа се въвежда броят числа n.
        Integer n = Integer.parseInt(scn.nextLine());

        for(int i = 0; i < 2 ; i++) {
            // System.out.printf("i: %s", i);
            for (int j = 0; j < n; j++) {
                // System.out.printf("j: %s", j);
                // mlist.get(i).add(Integer.parseInt(scn.nextLine()));
                sum[i] += Integer.parseInt(scn.nextLine());

            }// for
        }
        Integer diff = sum[0] - sum[1];
        System.out.printf(((diff == 0) ? "Yes, sum = %s" : "No, diff = %s"), ((diff == 0) ? sum[0] : Math.abs(sum[0] - sum[1])));
    }// main

}// class
