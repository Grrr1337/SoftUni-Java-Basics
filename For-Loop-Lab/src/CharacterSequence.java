import java.util.Scanner;

public class CharacterSequence {
    /*
        5.	Поток от символи
        Напишете програма, която чете текст (стринг), въведен от потребителя и печата всеки символ от текста на отделен ред.
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        for(int i = 0; i < s.length() ; i++){
            System.out.printf( ((i!=0) ? "\n" : "") + "%s", s.charAt(i));
        }// for

    }// main
}// class


