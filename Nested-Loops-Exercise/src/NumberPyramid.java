import java.util.Iterator;
import java.util.Scanner;

public class NumberPyramid {
    /*
    Напишете програма, която чете цяло число n, въведено от потребителя, и отпечатва пирамида от числа като в примерите:
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Integer n = Integer.parseInt(scn.nextLine().toString());

        int current = 1;
        boolean isBigger = false;

        for (int rows = 0; rows <= n ; rows++) { // How Many Rows
            for (int cols = 0; cols <= rows ; cols++) { // How Many Items
                if (current > n) {
                    isBigger = true;
                    break;
                }
                System.out.print(current + " ");
                current++;
            }// for
            if (isBigger) { break; }
            System.out.println();
        }// for

    }// main
}// class


