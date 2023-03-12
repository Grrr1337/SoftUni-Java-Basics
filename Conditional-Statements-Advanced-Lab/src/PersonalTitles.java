

import java.util.Scanner;

public class PersonalTitles {
    /*
        4.	Обръщение според възраст и пол
        Да се напише конзолна програма, която прочита възраст (десетично число) и пол ("m" или "f"), въведени от потребителя и отпечатва обръщение измежду следните:
        •	"Mr." - мъж (пол "m") на 16 или повече години
        •	"Master" - момче (пол "m") под 16 години
        •	"Ms." - жена (пол "f") на 16 или повече години
        •	"Miss" - момиче (пол "f") под 16 години
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        // But how to implement XOR for a double criteria in 4 total possible results?
        Double uin = Double.parseDouble(scn.nextLine());
        String ui = scn.nextLine();
        if ("m".equals(ui)) {
            System.out.printf("%s", ((uin >= 16) ? "Mr." : "Master"));
        }
        else if ("f".equals(ui)) {
            System.out.printf("%s", ((uin >= 16) ? "Ms." : "Miss"));
        }
    }// main
}
