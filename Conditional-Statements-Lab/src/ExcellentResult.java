
import java.util.Scanner;

public class ExcellentResult {

    /*
        Напише конзолна програма, която чете оценка (цяло число),
        въведена от потребителя и отпечатва "Excellent!" ако оценката е 5 или по-висока.
    */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        if (!(scn.hasNextInt()))
            return;

        // int grade  = Integer.parseInt(scn.nextLine());
        if (scn.nextInt() >= 5) {
            System.out.println("Excellent!");
        }
    }
}
