


public class NumbersEndingin7 {
    /*
        1.	Числа до 1000, завършващи на 7
        Напишете програма, която отпечатва числата в диапазона от 1 до 1000, които завършват на 7.

     */

    public static void main(String[] args) {

        String s;
        for (int i = 0; i < 1000; i++) {
            s = String.format("%s", i);
            if (Integer.parseInt(String.valueOf(s.charAt(s.length()-1))) == 7) {
                System.out.printf( ((i >= 7) ? "\n" : "") + "%s", i);
            }
            // System.out.printf("\n%s | %s", s, s.charAt(s.length()-1));
        }// for
    }// main
}// class
