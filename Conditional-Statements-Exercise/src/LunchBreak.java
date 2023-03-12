

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class LunchBreak {
    /*
        8. Обедна почивка
        По време на обедната почивка искате да изгледате епизод от своя любим сериал.
        Вашата задача е да напишете програма, с която ще разберете дали имате достатъчно време да изгледате епизода.
        По време на почивката отделяте време за обяд и време за отдих.
        Времето за обяд ще бъде 1/8 от времето за почивка,а времето за отдих ще бъде 1/4 от времето за почивка.
        Вход
        От конзолата се четат 3 реда:
        1.	Име на сериал – текст
        2.	Продължителност на епизод  – цяло число в диапазона [10… 90]
        3.	Продължителност на почивката  – цяло число в диапазона [10… 120]

        Изход
        На конзолата да се изпише един ред:
        •	Ако времето е достатъчно да изгледате епизода:
        "You have enough time to watch {име на сериал} and left with {останало време} minutes free time."
        •	Ако времето не Ви е достатъчно:
        "You don't have enough time to watch {име на сериал}, you need {нужно време} more minutes."
        Времето да се закръгли до най-близкото цяло число нагоре.
     */

    public static String prettyPrint(double d) {
        int i = (int) d;
        return d == i ? String.valueOf(i) : String.valueOf(d);
    }

    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();


        boolean ToThrowError = false;

        int n;
        Integer[][] ranges = { {0, 0}, {10, 90}, {10, 120} };
        String[] argKeys = new String[]{"SerialName", "EpisodeDuration", "BreakDuration"};

        n = 0;
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n]));
            userInputs.put(k, scn.nextLine());
            n++;
        }// for

        n = 1; // to skip the first argument's range check
        for (String k : argKeys) {
            Object v = userInputs.get(k);
            System.out.printf("\n\"%s\" %s ", k, v);
            switch(k) {
                case "SerialName": {
                    break;
                }
                default: { // "EpisodeDuration", "BreakDuration"
                    if (!IntValidateInput(Integer.parseInt((String)v), ranges[n++])) {
                        ToThrowError = true;
                    }
                    break;
                }
                // code block
            } // switch

        } // for
        if (ToThrowError) { throw new RuntimeException("Invalid input!"); }

        double eDuration = Double.parseDouble((String)userInputs.get("EpisodeDuration"));
        double bDuration = Double.parseDouble((String)userInputs.get("BreakDuration"));
        double timeBreak = bDuration  * (1.0 / 8.0);
        double timeLunch = bDuration * (1.0 / 4.0);
        double timeLeft =  bDuration - ( timeLunch + timeBreak);

        System.out.printf("\neDuration: %.2f | timeBreak: %.2f | timeLunch: %.2f | timeLeft: %.2f",
                eDuration, timeBreak, timeLunch, timeLeft
        );

//        System.out.printf("\nYou have enough time to watch %s and left with %.2f minutes free time.",
//                userInputs.get("SerialName"), timeLeft
//        );

        if (timeLeft >= eDuration) {
            System.out.printf("\nYou have enough time to watch %s and left with %s minutes free time.",
                    userInputs.get("SerialName"), prettyPrint(Math.abs((eDuration - timeLeft))) // args: got 60 97
                    );

        }
        else {
            System.out.printf("\nYou don't have enough time to watch %s, you need %s more minutes.",
                    userInputs.get("SerialName"), prettyPrint(Math.ceil(Math.abs(eDuration - timeLeft)))
            );
        }
    }// main
}
