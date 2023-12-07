
import java.util.Scanner;

public class NumbersN1 {
        /*
            2.	Числата от N до 1 в обратен ред
            Напишете програма, която чете цяло положително число n,
            въведено от потребителя и печата числата от n до 1 в обратен ред.
            Въведеното число n, винаги ще бъде по-голямо от 1.
         */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n =  Integer.parseInt(scn.nextLine());

        for(int i = n; i > 0 ; i--){
            System.out.println(i);
        }// for

    }// main
}// class
