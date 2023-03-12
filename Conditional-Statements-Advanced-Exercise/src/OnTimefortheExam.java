

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class OnTimefortheExam {
    /*
        8.	Навреме за изпит
        Студент трябва да отиде на изпит в определен час.
        Той идва в изпитната зала в даден час на пристигане.
        Счита се, че студентът е дошъл навреме, ако е пристигнал в часа на изпита или до половин час преди това.
        Ако е пристигнал по-рано повече от 30 минути, той е подранил. Ако е дошъл след часа на изпита, той е закъснял.
        Напишете програма, която прочита време на изпит и време на пристигане и отпечатва дали студентът е дошъл навреме,
        дали е подранил или е закъснял и с колко часа или минути е подранил или закъснял.

        Вход
        От конзолата се четат 4 цели числа (по едно на ред), въведени от потребителя:
        •	Първият ред съдържа час на изпита – цяло число от 0 до 23.
        •	Вторият ред съдържа минута на изпита – цяло число от 0 до 59.
        •	Третият ред съдържа час на пристигане – цяло число от 0 до 23.
        •	Четвъртият ред съдържа минута на пристигане – цяло число от 0 до 59.
        Изход
        На първият ред отпечатайте:
        •	"Late", ако студентът пристига по-късно от часа на изпита.
        •	"On time", ако студентът пристига точно в часа на изпита или до 30 минути по-рано.
        •	"Early", ако студентът пристига повече от 30 минути преди часа на изпита.
        Ако студентът пристига с поне минута разлика от часа на изпита, отпечатайте на следващия ред:
        •	"mm minutes before the start" за идване по-рано с по-малко от час.
        •	"hh:mm hours before the start" за подраняване с 1 час или повече. Минутите винаги печатайте с 2 цифри, например 1:05.
        •	 "mm minutes after the start" за закъснение под час.
        •	"hh:mm hours after the start" за закъснение от 1 час или повече. Минутите винаги печатайте с 2 цифри, например 1:03.
    */

    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }


    @FunctionalInterface
    public interface iArrivalStatus {
        public Boolean print(String stringFormatting, Boolean isOnTime, String timeDiff);
    }// iHotelRoom

    public static void main(String[] args) {

        /*
            Вход
            От конзолата се четат 4 цели числа (по едно на ред), въведени от потребителя:
            •	Първият ред съдържа час на изпита – цяло число от 0 до 23.
            •	Вторият ред съдържа минута на изпита – цяло число от 0 до 59.
            •	Третият ред съдържа час на пристигане – цяло число от 0 до 23.
            •	Четвъртият ред съдържа минута на пристигане – цяло число от 0 до 59.
         */


        // Get User Inputs
        int n = 0;
        Integer[][] ranges = new Integer[][]{{0, 23}, {0, 59},{0, 23}, {0, 59}};

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"examHour", "examMinute", "arrivalHour", "arrivalMinute"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" %s: ", k, Arrays.toString(ranges[n++])); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        try {
            n = 0;
            for(String k : argKeys) {
                if (!(IntegerValidateInput(Integer.parseInt(userInputs.get(k).toString()), ranges[n++]))) {
                    return;
                }// if
            }// for
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch

        Double diff =
        (((Double.parseDouble(userInputs.get("examHour").toString()) * 60.0)
        + Double.parseDouble(userInputs.get("examMinute").toString()) ) -
        ((Double.parseDouble(userInputs.get("arrivalHour").toString()) * 60.0)
        + Double.parseDouble(userInputs.get("arrivalMinute").toString())
        ));

        /*
            На първият ред отпечатайте:
            •	"Late", ако студентът пристига по-късно от часа на изпита.
            •	"On time", ако студентът пристига точно в часа на изпита или до 30 минути по-рано.
            •	"Early", ако студентът пристига повече от 30 минути преди часа на изпита.

         */

        iArrivalStatus iArStatus = (sfmt, btime, d) -> { // String stringFormatting, Boolean isOnTime, String timeDiff
            if (btime) {
                System.out.printf(sfmt, d);
                return true;
            }
            return false;
        };


        // Счита се, че студентът е дошъл навреме, ако е пристигнал в часа на изпита или до половин час преди това.
        // Ако е пристигнал по-рано повече от 30 минути, той е подранил.
        // Ако е дошъл след часа на изпита, той е закъснял.


        // iArStatus.print(((diff > 0) ? "\nEarly: %s" : "\nLate: %s"), diff);

        boolean prnt = (iArStatus.print("On time%s", (diff > 0.0) && (diff < 30.0), "") ||
        iArStatus.print("Early%s", (diff > 0), "") ||
        iArStatus.print("Late%s", (diff < 0), ""));

        // System.out.printf(((diff > 0) ? "\nEarly: %s" : "\nLate: %s"), diff);

        /*
        •	"mm minutes before the start" за идване по-рано с по-малко от час.
        •	"hh:mm hours before the start" за подраняване с 1 час или повече. Минутите винаги печатайте с 2 цифри, например 1:05.
        •	 "mm minutes after the start" за закъснение под час.
        •	"hh:mm hours after the start" за закъснение от 1 час или повече. Минутите винаги печатайте с 2 цифри, например 1:03.
         */

        System.out.printf("\n%s",
                ((Math.abs(diff) > 60) ?
                        (String.format("%.0f", Math.abs(((diff - (diff % 60)) / 60.0))) + ":" +

        ((Math.abs((diff % 60)) > 10) ? "" : "0") + String.format("%.0f", Math.abs((diff % 60)))
                        ) :
                        String.format("%.0f", Math.abs(diff)))

                        + " " + ((Math.abs(diff) > 60) ? "hours" : "minutes")
                        + " " + ((diff > 0) ? "before the start" : "after the start")
        );

    } // main
}// class


