import java.util.Scanner;

public class Combinations {
    /*
        3.	Комбинации
        Напишете програма, която изчислява колко решения в естествените числа (включително и нулата) има уравнението:
        x1 + x2 + x3 = n
        Числото n е цяло число и се въвежда от конзолата.
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Object inp = scn.nextLine();
        Integer n = Integer.parseInt(inp.toString());

        Integer counter = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if ((i+j+k) == n) { counter++; }
                }// for
            }// for
        }// for
        System.out.println(counter);
    }// main
}// class
