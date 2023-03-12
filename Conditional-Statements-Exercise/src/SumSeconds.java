
import java.util.Scanner;

public class SumSeconds {

    public static void main(String[] args) {
        int n = 0, minutes, seconds;
        Scanner scn = new Scanner(System.in);
        n += Integer.parseInt(scn.nextLine());
        n += Integer.parseInt(scn.nextLine());
        n += Integer.parseInt(scn.nextLine());

        minutes = n / 60;
        seconds = n % 60;

        System.out.printf((seconds < 10 ? "%d:%02d" : "%d:%d"), minutes, seconds);

    }
}
