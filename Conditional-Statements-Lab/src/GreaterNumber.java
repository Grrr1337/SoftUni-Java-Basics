
import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        int n1, n2, max;

        Scanner scn = new Scanner(System.in);
        n1 = Integer.parseInt(scn.nextLine());
        n2 = Integer.parseInt(scn.nextLine());

        if (n1 > n2) {
            max = n1;
        } else {
            max = n2;
        }
        System.out.println(max);
    }
}
