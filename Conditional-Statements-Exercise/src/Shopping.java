


import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Shopping {
    /*
        Петър иска да купи N видеокарти, M процесора и P на брой рам памет.
        Ако броя на видеокартите е по-голям от този на процесорите получава 15% отстъпка от крайната сметка. Важат следните цени:
        •	Видеокарта – 250 лв./бр.
        •	Процесор – 35% от цената на закупените видеокарти/бр.
        •	Рам памет – 10% от цената на закупените видеокарти/бр.
        Да се изчисли нужната сума за закупуване на материалите и да се пресметне дали бюджета ще му стигне.

        Вход
        Входът се състои от четири реда:
        1.	Бюджетът на Петър - реално число в интервала [0.0…100000.0]
        2.	Броят видеокарти - цяло число в интервала [0…100]
        3.	Броят процесори - цяло число в интервала [0…100]
        4.	Броят рам памет - цяло число в интервала [0…100]

        Изход
        На конзолата се отпечатва 1 ред, който трябва да изглежда по следния начин:
        •	Ако бюджета е достатъчен:
        "You have {остатъчен бюджет} leva left!"
        •	Ако сумата надхвърля бюджета:
        "Not enough money! You need {нужна сума} leva more!"
        Резултатът да се форматира до втория знак след десетичната запетая.

     */


    private static boolean DoubleValidateInput(double val, double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();

        int n = 0; boolean ToThrowError = false;

        double[][] ranges = { {0.0, 100000.0}, {0.00, 100.0}, {0.00, 100.0}, {0.00, 100.0} };
        String[] argKeys = new String[]{"Budget", "VideoCards", "Processors", "RAM"};

        for(String k : argKeys) {
            // System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n++]));
            userInputs.put(k, scn.next());
        }// for

        for (String k : argKeys) {
            Object v = userInputs.get(k);
            // System.out.printf("\n\"%s\" %s ", k, v);

            /*
            1.	Бюджетът на Петър - реално число в интервала [0.0…100000.0]
            2.	Броят видеокарти - цяло число в интервала [0…100]
            3.	Броят процесори - цяло число в интервала [0…100]
            4.	Броят рам памет - цяло число в интервала [0…100]
            */
            switch(k) {
                case "Budget": {
                    if (!DoubleValidateInput(Double.parseDouble((String)v), new double[]{0.0, 100000.0})) {
                        ToThrowError = true;
                    }
                    break;
                }
                default: { // "VideoCards", "Processors", "RAM"
                    if (!IntValidateInput(Integer.parseInt((String)v), new Integer[]{0, 100})) {
                        ToThrowError = true;
                    }
                    break;
                }
                // code block
            } // switch

        } // for

        if (ToThrowError) { throw new RuntimeException("Invalid input!"); }

        //Петър иска да купи N видеокарти, M процесора и P на брой рам памет.
        //Ако броя на видеокартите е по-голям от този на процесорите получава 15% отстъпка от крайната сметка. Важат следните цени:
        //•	Видеокарта – 250 лв./бр.
        //•	Процесор – 35% от цената на закупените видеокарти/бр.
        //•	Рам памет – 10% от цената на закупените видеокарти/бр.

        double vCard = (Double.parseDouble((String)userInputs.get("VideoCards")) * 250);
        double proc = Double.parseDouble((String)userInputs.get("Processors") )* vCard * 0.35;
        double RAM = Double.parseDouble((String)userInputs.get("RAM")) * vCard * 0.1;
        double tot = (vCard + proc + RAM);

        double discount = 1.00;
        if (Double.parseDouble((String)userInputs.get("VideoCards")) > Double.parseDouble((String)userInputs.get("Processors")))
        {
            discount = 0.85;
            tot *= discount;
        }
        Double savings = Double.parseDouble((String)userInputs.get("Budget")) - tot;

        // System.out.printf("\nvCard: %.2f | proc: %.2f | RAM: %.2f | Total: %.2f | Savings: %.2f", vCard, proc, RAM, tot, savings );

        if (savings > 0) {
            System.out.printf("You have %.2f leva left!", savings);
        }
        else {
            System.out.printf("Not enough money! You need %.2f leva more!", Math.abs(savings));
        }
    }// main
}
