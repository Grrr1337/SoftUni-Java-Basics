


import java.util.Scanner;

public class TimePlus15Minutes {

    /*
        Да се напише програма, която чете час и минути от 24-часово денонощие,
        въведени от потребителя и изчислява колко ще е часът след 15 минути.
        Резултатът да се отпечата във формат часове:минути.
        Часовете винаги са между 0 и 23, а минутите винаги са между 0 и 59.
        Часовете се изписват с една или две цифри. Минутите се изписват винаги с по две цифри, с водеща нула, когато е необходимо.
    */

    public static void main(String[] args) {
        int ihours, iminutes, totalMinutes, remMinutes, hours;
        Scanner scn = new Scanner(System.in);
        ihours = Integer.parseInt(scn.nextLine());
        iminutes = Integer.parseInt(scn.nextLine());

        totalMinutes = (ihours * 60) + iminutes + 15;
        remMinutes = totalMinutes % 60;
        hours = ((totalMinutes - remMinutes) / 60);

        System.out.printf((remMinutes < 10 ? "%d:%02d" : "%d:%d"), (hours % 24), remMinutes);

    }
}
