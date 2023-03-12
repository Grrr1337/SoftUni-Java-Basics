

import java.util.Scanner;

public class Number100to200 {
    /*
        Да се напише програма, която чете цяло число, въведено от потребителя и проверява дали е под 100, между 100 и 200 или над 200. Ако числото е:
        •	под 100 отпечатайте: "Less than 100"
        •	между 100 и 200 отпечатайте: "Between 100 and 200"
        •	над 200 отпечатайте: "Greater than 200"

     */
    public static void main(String[] args) {
        String s;
        Scanner scn = new Scanner(System.in);

        Integer inp = Integer.parseInt(scn.nextLine());

        if (inp < 100) {
            s  ="Less than 100";
        } else if (inp > 200) {
            s ="Greater than 200";
        } else {
            s = "Between 100 and 200";
        }
        System.out.println(s);
    }
}
