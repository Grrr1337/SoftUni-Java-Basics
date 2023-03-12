

import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

import java.util.ArrayList;

public class TradeCommissions {
    /*
        12.	Търговски комисионни
        Фирма дава следните комисионни на търговците си според града, в който работят и обема на продажбите s:
        Град	0 ≤ s ≤ 500	500 < s ≤ 1 000	1 000 < s ≤ 10 000	s > 10 000
        Sofia	5%	7%	8%	12%
        Varna	4.5%	7.5%	10%	13%
        Plovdiv	5.5%	8%	12%	14.5%
        Напишете конзолна програма, която чете име на град (текст) и обем на продажби (реално число) ,
        въведени от потребителя, и изчислява и извежда размера на търговската комисионна според горната таблица.
        Резултатът да се изведе форматиран до 2 цифри след десетичната точка.
        При невалиден град или обем на продажбите (отрицателно число) да се отпечата "error".
     */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        Object[] cTable = new Object[]{ // https://stackoverflow.com/questions/6802483/how-to-directly-initialize-a-hashmap-in-a-literal-way
                new Object[]{
                        new Object[]{0.0, 500.0},
                        new HashMap<String, Double>() {{
                            put("Sofia", 0.05);
                            put("Varna", 0.045);
                            put("Plovdiv", 0.055);
                        }},
                },
                new Object[]{
                        new Object[]{500.0, 1000.0 },
                        new HashMap<String, Double>() {{
                            put("Sofia", 0.07);
                            put("Varna", 0.075);
                            put("Plovdiv", 0.08);
                        }},
                },
                new Object[]{
                        new Object[]{1000.0, 10000.0},
                        new HashMap<String, Double>() {{
                            put("Sofia", 0.08);
                            put("Varna", 0.10);
                            put("Plovdiv", 0.12);
                        }},
                },
                new Object[]{
                        new Object[]{10000.0, Double.POSITIVE_INFINITY},
                        new HashMap<String, Double>() {{
                            put("Sofia", 0.12);
                            put("Varna", 0.13);
                            put("Plovdiv", 0.145);
                        }},
                },
        }; // cTable initialization

        // Get user Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"TownName", "SalesVolume"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        Double salesVolume = Double.valueOf(userInputs.get("SalesVolume").toString());

        // Process the initialized table
        // int n = 0;
        boolean inRange = false;
        Double commision;
        for (Object row : cTable)
        {
            for (Object itm : (Object[])row)
            {
                if (!(itm instanceof HashMap<?,?>)) {
                    Object[] fields = (Object[]) itm;
                   // System.out.printf("\n(%s : %s)", fields[0], fields[1]);
                    inRange = DoubleValidateInput(salesVolume, Arrays.copyOf(fields, fields.length, Double[].class));
                }
                if ((inRange) && (itm instanceof HashMap<?,?>)) {
                    HashMap<String, Double> towns = (HashMap<String, Double>)itm;

                    // System.out.println(towns.get(userInputs.get("TownName").toString()).toString());
                    commision = Double.parseDouble(towns.get(userInputs.get("TownName").toString()).toString());
                    System.out.printf("%.2f", salesVolume * commision);
                    return;
                }
            }// for
        // n++;
        }// for

        System.out.println("error");
    } // main

}// class TradeCommissions


