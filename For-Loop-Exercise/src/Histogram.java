import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Histogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(input.nextLine());
            count++;

            if (currentNumber <= 199) {
                p1++;
            }
            if (currentNumber >= 200 && currentNumber <= 399) {
                p2++;
            }
            if (currentNumber >= 400 && currentNumber <= 599) {
                p3++;
            }
            if (currentNumber >= 600 && currentNumber <= 799) {
                p4++;
            }
            if (currentNumber >= 800 && currentNumber <= 1000) {
                p5++;
            }
        }
        System.out.printf("%.2f%%\n", (double) 100 * p1 / count);
        System.out.printf("%.2f%%\n", (double) 100 * p2 / count);
        System.out.printf("%.2f%%\n", (double) 100 * p3 / count);
        System.out.printf("%.2f%%\n", (double) 100 * p4 / count);
        System.out.printf("%.2f%%\n", (double) 100 * p5 / count);
    }// main

}// class

