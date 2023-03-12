import java.util.Scanner;

public class NumberInRange {
    /*
        6.	Число в интервал
        Да се напише програма, която проверява дали въведеното от потребителя число е в интервала [-100, 100] и е различно от 0
        и извежда "Yes", ако отговаря на условията, или "No" ако е извън тях.
     */
    public static void main(String[] args) {
        Double n = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.printf("%s", ((-100 <= n) && (n <= 100) && (n != 0)) ? "Yes" : "No");
    }
}
