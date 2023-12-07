import java.util.Scanner;

public class EqualSumsEvenOddPosition {
        /*
            2.	Еднакви суми на четни и нечетни позиции
            Напишете програма, която чете от конзолата две шестцифрени цели числа в
            диапазона от 100000 до 300000.
            Винаги първото въведено число ще бъде по малко от второто.
            На конзолата да се отпечатат на 1 ред разделени с интервал всички числа,
            които се намират между двете, прочетени от конзолата числа и отговарят на следното условие:
            •	сумата от цифрите на четни и нечетни позиции да са равни. Ако няма числа, отговарящи на условието на конзолата не се извежда резултат.
        */

    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static boolean Check ( String s1 ){

        int[] evenOrOdd = new int[]{0, 0};
        for (int i = 0; i < s1.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(s1.charAt(i)));
            if ((i % 2) == 0) { evenOrOdd[0] += digit; }// if
            else { evenOrOdd[1] += digit; }// else
        }// for
        if (evenOrOdd[0] == evenOrOdd[1]) {
            return true;
        }
        return false;
    }// public static boolean Check

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Object inp1 = scn.nextLine();
        Object inp2 = scn.nextLine();


        Integer n1 = 0, n2 = 0;
        String s1 ="", s2 = "";
        try {
            n1 = Integer.parseInt(inp1.toString());
            n2 = Integer.parseInt(inp2.toString());
            s1 = n1.toString();
            s2 = n2.toString();
            if ( (!(s1.length() == s2.length())) || (n1 > n2) ||
            (!(DoubleValidateInput(Double.parseDouble(inp1.toString()),new Double[]{100000.0, 300000.0}))) ||
            (!(DoubleValidateInput(Double.parseDouble(inp2.toString()),new Double[]{100000.0, 300000.0}))))
            { throw  new RuntimeException("Invalid inputs!"); }
        } catch (Exception e) { return; }

        for (int i = n1; i <= n2; i++) {
            if (Check(String.valueOf(i))) {
                System.out.printf("%s ", i);
            }// if
        }// for
    }// main
}// class
