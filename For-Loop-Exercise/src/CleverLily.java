import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

// import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CleverLily {
    /*
        4.	Умната Лили
        Лили вече е на N години. За всеки свой рожден ден тя получава подарък.
        •	За нечетните рождени дни (1, 3, 5...n) получава играчки.
        •	За четните рождени дни (2, 4, 6...n) получава пари.
        За втория рожден ден получава 10.00 лв, като сумата се увеличава с 10.00 лв.,
        за всеки следващ четен рожден ден (2 -> 10, 4 -> 20, 6 -> 30...и т.н.).
        През годините Лили тайно е спестявала парите.
        Братът на Лили, в годините, които тя получава пари, взима по 1.00 лев от тях.
        Лили продала играчките получени през годините, всяка за P лева и добавила сумата към спестените пари.
        С парите искала да си купи пералня за X лева.
        Напишете програма, която да пресмята, колко пари е събрала и дали ѝ стигат да си купи пералня.

        Вход
        Програмата прочита 3 числа, въведени от потребителя, на отделни редове:
        •	Възрастта на Лили - цяло число в интервала [1...77]
        •	Цената на пералнята - число в интервала [1.00...10 000.00]
        •	Единична цена на играчка - цяло число в интервала [0...40]
        Изход
        Да се отпечата на конзолата един ред:
        •	Ако парите на Лили са достатъчни:
        o	"Yes! {N}" - където N е остатъка пари след покупката
        •	Ако парите не са достатъчни:
        o	"No! {М}" - където M е сумата, която не достига
        Числата N и M трябва да за форматирани до вторият знак след десетичната запетая.

    */

    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {
        /*
            Вход
            Програмата прочита 3 числа, въведени от потребителя, на отделни редове:
            •	Възрастта на Лили - цяло число в интервала [1...77]
            •	Цената на пералнята - число в интервала [1.00...10 000.00]
            •	Единична цена на играчка - цяло число в интервала [0...40]
        */
        // Get user Inputs
        int n = 0;
        Double[][] ranges = new Double[][]{{1.0, 77.0}, {1.0, 10000.00},{0.0, 40.0}};

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"ageLily", "wmCost", "toyPrice"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" %s: ", k, Arrays.toString(ranges[n++])); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        // Validate user inputs
        try {
            n = 0;
            for (String k : new String[]{"ageLily", "toyPrice"}) { // isInteger ?
                Integer.parseInt(userInputs.get(k).toString());
            }
            for(String k : argKeys) { // isWithinRange?
                if (!(DoubleValidateInput(Double.parseDouble(userInputs.get(k).toString()), ranges[n++]))) {
                    return;
                }// if
            }// for
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch

        // Process Inputs:
        /*
            Лили вече е на N години. За всеки свой рожден ден тя получава подарък.
            •	За нечетните рождени дни (1, 3, 5...n) получава играчки.
            •	За четните рождени дни (2, 4, 6...n) получава пари.
        */

        var ageLily = Integer.parseInt(userInputs.get("ageLily").toString());
        // Integer toysCount = 0, moneySaved = 0, moneysToGive = 0, broDeduction =0 ;
        Double toysCount = 0.0, moneySaved = 0.0, moneysToGive = 0.0, broDeduction = 0.0 ;

        for (int i = 1; i <= ageLily ; i++) {
            if ((i % 2) == 0) { // shouldGetMoney
                moneysToGive += 10;
                moneySaved += moneysToGive;
                broDeduction -= 1;
            }// if
            else { // shouldGetToy
                toysCount += 1;
            } // else

        }// for

        Double moneyFromToys = (toysCount * Double.parseDouble(userInputs.get("toyPrice").toString()));


        // System.out.printf("\nmoneySaved : %s | moneyFromToys : %s | broDeduction : %s", moneySaved, moneyFromToys, broDeduction);

        Double diff = (moneySaved + moneyFromToys + broDeduction - Double.parseDouble(userInputs.get("wmCost").toString()));
        // System.out.printf("\ndiff : %s", diff);

        if (diff > 0) {
            System.out.printf("Yes! %s", String.format("%.2f", diff));
        }// if

        else { System.out.printf("No! %s", String.format("%.2f", Math.abs(diff))); }

        // Outputs
        // https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
        // userInputs.entrySet().forEach(entry -> { System.out.println(entry.getKey() + " " + entry.getValue()); });


    }// main
}// class





















