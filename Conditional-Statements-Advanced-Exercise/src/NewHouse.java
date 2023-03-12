
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.HashMap;

public class NewHouse {
    /*
        цвете	            Роза	Далия	Лале	Нарцис	Гладиола
        Цена на брой в лева	5	    3.80	2.80	3	    2.50


        От конзолата се четат 3 реда:
        •	Вид цветя - текст с възможности - "Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        •	Брой цветя - цяло число в интервала [10…1000]
        •	Бюджет - цяло число в интервала [50…2500]

        •	Ако бюджета им е достатъчен - "Hey, you have a great garden with {броя цвета} {вид цветя} and {останалата сума} leva left."
        •	Ако бюджета им е НЕ достатъчен - "Not enough money, you need {нужната сума} leva more."

     */
    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    @FunctionalInterface
    public interface MyInterface {
        public void message();
    }// public

    @FunctionalInterface
    public interface GetFlowerCostRatioInterface {
        public double getCostRatio(String flowerType, Boolean amountFlowersCheck, Double toReturn);
    }// public

    public static void main(String[] args) {

        HashMap<String, Double> flowerPrices = new HashMap<>() {{
            put("Roses", 5.00);
            put("Dahlias", 3.80);
            put("Tulips", 2.80);
            put("Narcissus", 3.00);
            put("Gladiolus", 2.50);
        }};


        // Get user Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<>();
        String[] argKeys = new String[]{"flowerType", "flowersAmount", "budget"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.next());
        }// for

        if (!(Arrays.asList("Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus").contains(userInputs.get("flowerType"))))
        { return; }

        if (!(IntegerValidateInput(Integer.parseInt(userInputs.get("flowersAmount").toString()), new Integer[]{10, 1000})) ||
            !(IntegerValidateInput(Integer.parseInt(userInputs.get("budget").toString()), new Integer[]{50, 2500}))
        ) { return; }

        /*
        •	Ако Нели купи повече от 80 Рози - 10% отстъпка от крайната цена
        •	Ако Нели купи повече от 90  Далии - 15% отстъпка от крайната цена
        •	Ако Нели купи повече от 80 Лалета - 15% отстъпка от крайната цена
        •	Ако Нели купи по-малко от 120 Нарциса - цената се оскъпява с 15%
        •	Ако Нели Купи по-малко от 80 Гладиоли - цената се оскъпява с 20%

         */

        Double flowerPrice = flowerPrices.get(userInputs.get("flowerType").toString());
        Double flowersAmount = Double.parseDouble((userInputs.get("flowersAmount").toString()));


        // TODO: study how interfaces work
        // https://www.youtube.com/watch?v=tj5sLSFjVj4&t=652s
        // https://www.youtube.com/watch?v=LEJ1kGHSXdA
        // MyInterface myInterface = () -> System.out.println("Heello World!!!");
        // myInterface.message();

        GetFlowerCostRatioInterface flower = (a, b, c) -> {
            if ((a.equals(userInputs.get("flowerType"))) && b)  {
                return c;
            }// if
            return 1.0;
        }; // flowerCostRatoInterface

        // Double costRatio = 1.00;
        Double costRatio = new ArrayList<Double>(
                Arrays.asList(
                        flower.getCostRatio("Roses", (flowersAmount > 80.0), 0.9),
                        flower.getCostRatio("Dahlias", (flowersAmount > 90.0), 0.85),
                        flower.getCostRatio("Tulips", (flowersAmount > 80.0), 0.85),
                        flower.getCostRatio("Narcissus", (flowersAmount < 120.0), 1.15),
                        flower.getCostRatio("Gladiolus", (flowersAmount < 80.0), 1.20)
                )).stream().filter(c -> c != 1.00).findFirst().orElse(1.00);

        // System.out.println(costRatio);

        /*

        if (("Roses".equals(userInputs.get("flowerType"))) && (flowersAmount >= 80))  {
            costRatio = 0.9;
        }// if
        else if (("Dahlias".equals(userInputs.get("flowerType"))) && (flowersAmount >= 90))  {
            costRatio = 0.85;
        }// if
        else if (("Tulips".equals(userInputs.get("flowerType"))) && (flowersAmount >= 80))  {
            costRatio = 0.85;
        }// if
        else if (("Narcissus".equals(userInputs.get("flowerType"))) && (flowersAmount <= 120))  {
            costRatio = 1.15;
        }// if
        else if (("Gladiolus".equals(userInputs.get("flowerType"))) && (flowersAmount >= 80))  {
            costRatio = 1.20;
        }// if
        */

        /*
            •	Ако бюджета им е достатъчен - "Hey, you have a great garden with {броя цвета} {вид цветя} and {останалата сума} leva left."
            •	Ако бюджета им е НЕ достатъчен - "Not enough money, you need {нужната сума} leva more."
         */
        Double res = Double.parseDouble(userInputs.get("budget").toString()) - (flowerPrice * flowersAmount * costRatio);
        if (res > 0) {
            System.out.printf("Hey, you have a great garden with %.0f %s and %.2f leva left.", flowersAmount, userInputs.get("flowerType"), res);
        }
        else {
            System.out.printf("Not enough money, you need %.2f leva more.", Math.abs(res));
        }

    }// main
}// class

