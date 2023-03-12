

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class WorldSwimmingRecord {

    /*
        На конзолата се въвежда рекордът в секунди,  който Иван трябва да подобри,
        разстоянието в метри, което трябва да преплува и времето в секунди, за което плува разстояние от 1 м.
        Да се напише програма, която изчислява дали се е справил със задачата, като се има предвид, че:
        съпротивлението на водата го забавя на всеки 15 м. с 12.5 секунди.
        Когато се изчислява колко пъти Иван ще се забави,
        в резултат на съпротивлението на водата, резултатът трябва да се закръгли надолу до най-близкото цяло число.
        Да се изчисли времето в секунди, за което Иван ще преплува разстоянието и разликата спрямо Световния рекорд.

        Вход
        От конзолата се четат 3 реда:
        1.	Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
        2.	Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
        3.	Времето в секунди, за което плува разстояние от 1 м. - реално число в интервала [0.00 … 1000.00]

        Отпечатването на конзолата зависи от резултата:
        •	Ако Иван е подобрил Световния рекорд (времето му е по-малко от рекорда) отпечатваме:
        o	"Yes, he succeeded! The new world record is {времето на Иван} seconds."
        •	Ако НЕ е подобрил рекорда (времето му е по-голямо или равно на рекорда) отпечатваме:
        o	"No, he failed! He was {недостигащите секунди} seconds slower."
        Резултатът трябва да се форматира до втория знак след десетичната запетая.

     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    private static boolean DoubleValidateInput(double val, double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        HashMap<String, Double> userInputs = new HashMap<String, Double>();

        Object ui;
        int n = 0;
        boolean ToThrowError = false;
        Double dbl;
        double ranges[][] = { {0.00, 100000.00}, {0.00, 100000.00}, {0.00, 1000.00} };
        String argKeys[] = new String[]{"Record", "Distance", "Time"};

        for(String k : argKeys) {

            System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n]));
            ui = scn.nextLine();
            // System.out.printf("\n %s | %s", ui, ui.getClass());

            dbl = Double.parseDouble(ui.toString()); // Double.parseDouble Long.parseLong
            userInputs.put(k, dbl);

            if (!(DoubleValidateInput(Double.parseDouble(dbl.toString()), ranges[n]))) {
                ToThrowError = true;
            }

            n++;

        }// for

        // if (ToThrowError) { return; }
        //if (ToThrowError) { throw new RuntimeException("Invalid input!"); }

        for (String k : argKeys) {
            Double artVal = (Double)userInputs.get(k);
            System.out.printf("\n\"%s\" %.2f ", k, artVal);

        } // for


        Double heHasToSwim = Math.floor(userInputs.get("Distance") * userInputs.get("Time"));
        Double addedSeconds = Math.floor((userInputs.get("Distance") / 15.0) * 12.50);
        Double timeSwimming = heHasToSwim + addedSeconds;
        Double res = timeSwimming - round(userInputs.get("Record"), 2);

        // System.out.printf("\nSeconds: %s", res);
        // Math.floor( )

        if (res < 0){
            System.out.printf("\nYes, he succeeded! The new world record is %.2f seconds.", (Math.floor(userInputs.get("Record")) + Math.floor(res)));
        }
        else {
            System.out.printf("\nNo, he failed! He was %.2f seconds slower.", res);

        }
    } // main
}
