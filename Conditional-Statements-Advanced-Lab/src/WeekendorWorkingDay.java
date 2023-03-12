

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

import java.lang.Math;

public class WeekendorWorkingDay {
    /*
        2.	Почивен или работен ден
        Напишете програма която, чете ден от седмицата (текст), на английски език - въведен от потребителя.
        Ако денят е работен отпечатва на конзолата - "Working day", ако е почивен - "Weekend".
        Ако се въведе текст различен от ден от седмицата да се отпечата - "Error".

     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String ui = (String)scn.next();

        int n = 0;
        for (Boolean b : new Boolean[]{
                Arrays.stream(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}).anyMatch(ui::equals),
                Arrays.stream(new String[]{"Saturday", "Sunday"}).anyMatch(ui::equals)
        })
        {

            if (b)
            {
                System.out.printf("%s", new String[]{"Working day", "Weekend"}[n]);
                return;
            }
            n++;
        }// for
        System.out.println("Error");

    } // main
}
