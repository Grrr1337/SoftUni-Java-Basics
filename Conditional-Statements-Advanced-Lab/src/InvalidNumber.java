import java.util.Scanner;

public class InvalidNumber {
    /*
        10.	Невалидно число
        Дадено число е валидно, ако е в диапазона [100…200] или е 0.
        Да се напише програма, която чете цяло число,
        въведено от потребителя, и печата "invalid" ако въведеното число не е валидно.

     */
    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Integer uin = (Integer.parseInt((String)scn.next()));
        if (uin == 0) return; // else "".isEmpty();

        if(!IntValidateInput(uin, new Integer[]{100, 200}))   {
            System.out.println("invalid");
        }
    }// main
}
