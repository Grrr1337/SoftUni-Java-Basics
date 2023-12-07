import java.util.Scanner;

public class OddEvenSum {
    /*
        10.	Четна / нечетна сума
        Да се напише програма, която чете n-на брой цели числа, подадени от потребителя и проверява дали сумата от числата на четни позиции е равна на сумата на числата на нечетни позиции.
        •	Ако сумите са равни да се отпечатат два реда: "Yes" и на нов ред "Sum = " + сумата;
        •	Ако сумите не са равни да се отпечат два реда: "No" и на нов ред "Diff = " + разликата.
        Разликата се изчислява по абсолютна стойност.
     */
    public static void main(String[] args) {

        Integer[] sum =new Integer[]{0,0};
        Scanner scn = new Scanner(System.in);
        // От първия ред на входа се въвежда броят числа n.
        Integer n = Integer.parseInt(scn.nextLine());

        Integer inp;
        for(int i = 0; i < n ; i++) {
            inp = Integer.parseInt(scn.nextLine());
            // sum[(((n % 2) == 0) ? 0 : 1)] += inp;
            sum[(((i % 2) == 0) ? 0 : 1)] += inp;
        }//
        Integer diff = sum[0] - sum[1];
        System.out.printf(((diff == 0) ? "Yes\nSum = %s" : "No\nDiff = %s"), ((diff == 0) ? sum[0] : Math.abs(sum[0] - sum[1])));
    }// main
}// class

