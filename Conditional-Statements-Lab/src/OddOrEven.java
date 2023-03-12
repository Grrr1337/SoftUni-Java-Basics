

import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println((Integer.parseInt(scn.nextLine()) % 2 == 0) ? "even" : "odd");
    }
}
