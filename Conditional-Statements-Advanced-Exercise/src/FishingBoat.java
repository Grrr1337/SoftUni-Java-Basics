import java.util.*;

public class FishingBoat {
    /*
        Тони и приятели много обичали да ходят за риба, те са толкова запалени по риболова,
        че решават да отидат на риболов с кораб. Цената за наема на кораба зависи от сезона и броя рибари.
        Цената зависи от сезона:
        •	Цената за наем на кораба през пролетта е  3000 лв.
        •	Цената за наем на кораба през лятото и есента е  4200 лв.
        •	Цената за наем на кораба през зимата е  2600 лв.
        В зависимост от броя си групата ползва отстъпка:
        •	Ако групата е до 6 човека включително  –  отстъпка от 10%.
        •	Ако групата е от 7 до 11 човека включително  –  отстъпка от 15%.
        •	Ако групата е от 12 нагоре  –  отстъпка от 25%.
        Рибарите ползват допълнително 5% отстъпка ако са четен брой освен ако не е есен - тогава нямат допълнителна отстъпка.
        Напишете програма, която да пресмята дали рибарите ще съберат достатъчно пари.

        Вход
        От конзолата се четат точно три реда.
        •	Бюджет на групата – цяло число в интервала [1…8000]
        •	Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"
        •	Брой рибари – цяло число в интервала [4…18]

        Изход
        Да се отпечата на конзолата един ред:
        •	Ако бюджетът е достатъчен:
        "Yes! You have {останалите пари} leva left."
        •	Ако бюджетът НЕ Е достатъчен:
        "Not enough money! You need {сумата, която не достига} leva."
        Сумите трябва да са форматирани с точност до два знака след десетичната запетая.

     */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    @FunctionalInterface
    public interface customConditionalsInterface {
        public double getCostRatio(Double[] range, Double toReturn);
    }// public

    public static void main(String[] args) {


        HashMap<String, Double> ShipPrice = new HashMap<String, Double>() {{
            put("Spring", 3000.0);
            put("Summer", 4200.0);
            put("Autumn", 4200.0);
            put("Winter", 2600.0);
        }};

        /*
            Вход
            От конзолата се четат точно три реда.
            •	Бюджет на групата – цяло число в интервала [1…8000]
            •	Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"
            •	Брой рибари – цяло число в интервала [4…18]
         */

        // Get User Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"budget", "season", "amountFishermans"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        // Validation Block for User Inputs
        if (!(Arrays.asList("Spring", "Summer", "Autumn", "Winter").contains(userInputs.get("season"))))
        { return; }
        try {
            if (!(IntegerValidateInput(Integer.parseInt(userInputs.get("budget").toString()), new Integer[]{1, 8000})) ||
                    !(IntegerValidateInput(Integer.parseInt(userInputs.get("amountFishermans").toString()), new Integer[]{4, 18}))
            ) {
                return;
            }
        }
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }


        /*
            В зависимост от броя си групата ползва отстъпка:
            •	Ако групата е до 6 човека включително  –  отстъпка от 10%.
            •	Ако групата е от 7 до 11 човека включително  –  отстъпка от 15%.
            •	Ако групата е от 12 нагоре  –  отстъпка от 25%.
            Рибарите ползват допълнително 5% отстъпка ако са четен брой освен ако не е есен - тогава нямат допълнителна отстъпка.
            Напишете програма, която да пресмята дали рибарите ще съберат достатъчно пари.
         */

        // TODO: study how interfaces work
        // https://www.youtube.com/watch?v=tj5sLSFjVj4&t=652s
        // https://www.youtube.com/watch?v=LEJ1kGHSXdA
        // MyInterface myInterface = () -> System.out.println("Heello World!!!");
        // myInterface.message();
        customConditionalsInterface fmAmount = (range, r) -> {
            if (DoubleValidateInput(Double.parseDouble(userInputs.get("amountFishermans").toString()), range))  {
                return r;
            }// if
            return 1.0;
        }; // customConditionalsInterface

        Double costRatio = new ArrayList<Double>(
                Arrays.asList(
                        fmAmount.getCostRatio(new Double[]{Double.NEGATIVE_INFINITY, 6.0}, 0.9),
                        fmAmount.getCostRatio(new Double[]{7.0, 11.0}, 0.85),
                        fmAmount.getCostRatio(new Double[]{12.0, Double.POSITIVE_INFINITY}, 0.75)
                )).stream().filter(c -> c != 1.00).findFirst().orElse(1.00); // Double costRatio = 1.00;


        /*
            Рибарите ползват допълнително 5% отстъпка ако са четен брой освен ако не е есен - тогава нямат допълнителна отстъпка.
         */
        if ((!(userInputs.get("season").equals("Autumn"))) &&
        ((Double.parseDouble(userInputs.get("amountFishermans").toString()) % 2.0) == 0.0)) {
            costRatio += -0.05;
        }

        /*
            Да се отпечата на конзолата един ред:
            •	Ако бюджетът е достатъчен:
            "Yes! You have {останалите пари} leva left."
            •	Ако бюджетът НЕ Е достатъчен:
            "Not enough money! You need {сумата, която не достига} leva."
            Сумите трябва да са форматирани с точност до два знака след десетичната запетая.
         */

        Double budget = Double.parseDouble(userInputs.get("budget").toString());
        Double shipPrice =  ShipPrice.get(userInputs.get("season"));
        Double diff =  (budget - (shipPrice * costRatio));
        // System.out.println(diff);


        if (diff > 0){
            System.out.printf("Yes! You have %.2f leva left.", diff);
        }
        else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(diff));
        }

    }// main
}// class