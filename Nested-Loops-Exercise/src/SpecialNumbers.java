import java.util.Scanner;

public class SpecialNumbers {
    /*
        5.	Специални числа
        Да се напише програма, която чете едно цяло число N, въведено от потребителя,
         и генерира всички възможни "специални" числа от 1111 до 9999.
         За да бъде "специално" едно число, то трябва да отговаря на следното условие:

        •	N да се дели на всяка една от неговите цифри без остатък.
        Пример: при N = 16, 2418 е специално число:
        •	16 / 2 = 8 без остатък
        •	16 / 4 = 4 без остатък
        •	16 / 1 = 16 без остатък
        •	16 / 8 = 2 без остатък
        Вход
        Входът се чете от конзолата и се състои от едно цяло число в интервала [1…600000]
        Изход
        На конзолата трябва да се отпечатат всички "специални" числа, разделени с интервал

     */
    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Object inp = scn.nextLine();

        Integer n = 0;
        int num;
        try { n = Integer.parseInt(inp.toString());
            if (!(IntegerValidateInput(n, new Integer[]{1, 600000}))) { return; }// if
        }
        catch (Exception e) { return; }

        boolean isSpecial;
        for (int i = 1111; i <= 9999; i++) {
            isSpecial = true;

            for (char c : String.valueOf(i).toCharArray()) {
                num = Character.getNumericValue(c);
                if (num == 0) { isSpecial = false; }
                else if ((n % num) != 0.0) {
                    isSpecial = false;
                    // break;
                }
            }// for
            if (isSpecial) {
                System.out.printf("%s ", i);
            }
        }// for

    }// main
}// class


