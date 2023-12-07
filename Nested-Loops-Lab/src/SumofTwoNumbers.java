
// NOT DONE!:

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class SumofTwoNumbers {
    /*
        4.	Сума от две числа
        Напишете програма която проверява всички възможни комбинации от двойка числа в интервала от две дадени числа. На изхода се отпечатва, коя поред е комбинацията чиито сбор от числата е равен на дадено магическо число. Ако няма нито една комбинация отговаряща на условието се отпечатва съобщение, че не е намерено.
        Вход
        Входът се чете от конзолата и се състои от три реда:
        •	Първи ред – начало на интервала – цяло число в интервала [1...999]
        •	Втори ред – край на интервала – цяло число в интервала [по-голямо от първото число...1000]
        •	Трети ред – магическото число – цяло число в интервала [1...10000]
        Изход
        На конзолата трябва да се отпечата един ред, според резултата:
        •	Ако е намерена комбинация чиито сбор на числата е равен на магическото число
        o	"Combination N:{пореден номер} ({първото число} + {второ число} = {магическото число})"
        •	Ако не е намерена комбинация отговаряща на условието
        o	"{броят на всички комбинации} combinations - neither equals {магическото число}"
    */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        /* Вход
            Входът се чете от конзолата и се състои от три реда:
            •	Първи ред – начало на интервала – цяло число в интервала [1...999]
            •	Втори ред – край на интервала – цяло число в интервала [по-голямо от първото число...1000]
            •	Трети ред – магическото число – цяло число в интервала [1...10000]
        */

        // Get User Inputs
        Scanner scn = new Scanner(System.in);
        TreeMap<String, Object> userInputs = new TreeMap<>();
        String[] argKeys = new String[]{"startInterval", "endInterval", "magicNumber"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" : ", k); // Arrays.toString(ranges[n]) , Arrays.toString(ranges[n++])
            userInputs.put(k, scn.nextLine());
        }// for



        // Validate user inputs
        try {
            // Втори ред – край на интервала – цяло число в интервала [по-голямо от първото число...1000]
            Double tmp = Double.parseDouble(userInputs.get("startInterval").toString());
            Double[][] ranges = new Double[][]{{1.0, 999.0},{tmp, 1000.0},{1.0, 10000.0}};
            Integer n = 0;
            for (String k : argKeys) { // isInteger ? // isWithinRange?
                Integer.parseInt(userInputs.get(k).toString());
                if (!(DoubleValidateInput(Double.parseDouble(userInputs.get(k).toString()), ranges[n++]))) {
                    return;
                }// if
            }
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch


        // https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
        // Output (test):
        // userInputs.entrySet().forEach(entry -> { System.out.println(entry.getKey() + " " + entry.getValue()); });

        /* Изход
            На конзолата трябва да се отпечата един ред, според резултата:
            •	Ако е намерена комбинация чиито сбор на числата е равен на магическото число
            o	"Combination N:{пореден номер} ({първото число} + {второ число} = {магическото число})"
            •	Ако не е намерена комбинация отговаряща на условието
            o	"{броят на всички комбинации} combinations - neither equals {магическото число}"
        */


        Double magicNum =  Double.parseDouble(userInputs.get(argKeys[2]).toString());
        Integer combN = 0;
        Integer combNr = 0;
        Integer start = Integer.parseInt(userInputs.get(argKeys[0]).toString());
        Integer end = Integer.parseInt(userInputs.get(argKeys[1]).toString());

        Integer nMagincNum = Integer.parseInt(userInputs.get(argKeys[2]).toString());
        String r = "";
        for (int i = start; i <= end ; i++) {
            for (int j = start; j <= end ; j++) {
                // System.out.printf("\n%s + %s ", i, j);

                if ((i + j) == nMagincNum) {
                    combNr++;
                    r = String.format("Combination N:%s (%s + %s = %s)",
                            combNr, j, i, String.format("%.0f", magicNum)
                    );
                }// if
                combN++;
            }// for
        }// for
        if (!(r.equals(""))) {
            System.out.println(r);
        }// if
        else {
            System.out.printf("%s combinations - neither equals %s", // {броят на всички комбинации} {магическото число}
                    combN, nMagincNum
                    );
        }
    }// main
}// class