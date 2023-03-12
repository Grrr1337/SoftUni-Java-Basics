
import java.util.Objects;
import java.util.Scanner;

public class PasswordGuess {
    /*
        4.	Познай паролата
        Да се напише програма, която чете парола (текст),
        въведена от потребителя и проверява дали
        въведената парола съвпада с фразата "s3cr3t!P@ssw0rd".
        При съвпадение да се изведе "Welcome". При несъвпадение да се изведе "Wrong password!".
    */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println((Objects.equals(scn.nextLine(), "s3cr3t!P@ssw0rd")) ? "Welcome" : "Wrong password!");
    } // main
}
