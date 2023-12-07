

import java.util.Scanner;

public class Numbers1toNwithStep3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =  Integer.parseInt(scn.nextLine());

        for(int i = 1; i <= n ; i+=3){
            System.out.println(i);
        }// for
    }
}
