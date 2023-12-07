

import java.util.Scanner;


public class EvenPowersof2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  Integer.parseInt(scn.nextLine());

//        for(int i = 1; i <= n ; i++){
//            if (((i % 2) == 0) || (i == 1)) {
//                System.out.println(String.format( "%.0f", Math.pow(i, 2.0)));
//
//            }
//        }// for


        for(int i = 0; i <= n ; i++){
            if ((i % 2) == 0) {
                System.out.println(String.format("%.0f", Math.pow(2.0, i)));
            }

        }// for

    }// main
}// class
