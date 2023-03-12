
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class SkiTrip {
    /*
        9.	Ски почивка
        Атанас решава да прекара отпуската си в Банско и да кара ски.
        Преди да отиде обаче, трябва да резервира хотел и да изчисли колко ще му струва престоя.
        Налични са следните видове помещения, със следните цени за престой:
        	"room for one person" – 18.00 лв за нощувка
        	"apartment" – 25.00 лв за нощувка
        	"president apartment" – 35.00 лв за нощувка
        Според броят на дните, в които ще остане в хотела (пример: 11 дни = 10 нощувки) и видът на помещението,
        което ще избере, той може да ползва различно намаление.
        Намаленията са както следва:
        вид помещение	по-малко от 10 дни	между 10 и 15 дни	повече от 15 дни
        room for one person	не ползва намаление	не ползва намаление	не ползва намаление
        apartment	30% от крайната цена	35% от крайната цена	50% от крайната цена
        president apartment	10% от крайната цена	15% от крайната цена	20% от крайната цена

        След престоя, оценката на Атанас за услугите на хотела може да е позитивна (positive) или негативна (negative) .
        Ако оценката му е позитивна, към цената с вече приспаднатото намаление Атанас добавя 25% от нея.
        Ако оценката му е негативна приспада от цената 10%.
        Вход
        Входът се чете от конзолата и се състои от три реда:
        •	Първи ред - дни за престой - цяло число в интервала [0...365]
        •	Втори ред - вид помещение - "room for one person", "apartment" или "president apartment"
        •	Трети ред - оценка - "positive"  или "negative"
        Изход
        На конзолата трябва да се отпечата един ред:
        •	Цената за престоят му в хотела, форматирана до втория знак след десетичната запетая.

     */

    @FunctionalInterface
    public interface iDiscountStatus {
        public Object getDiscount(Boolean test, Double toReturn);
    }// iHotelRoom

    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        /*
        	"room for one person" – 18.00 лв за нощувка
        	"apartment" – 25.00 лв за нощувка
        	"president apartment" – 35.00 лв за нощувка
        */
        HashMap<String, Double> priceList = new HashMap<String, Double>() {{
            put("room for one person", 18.0);
            put("apartment", 25.0);
            put("president apartment", 35.0);
        }};

        // 1.0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY
        HashMap<String, Double[]> roomDiscounts = new HashMap<String, Double[]>() {{
            put("room for one person", new Double[]{0.0, 0.0, 0.0});
            put("apartment", new Double[]{0.30, 0.35, 0.50});
            put("president apartment", new Double[]{0.10, 0.15, 0.20});
        }};

        HashMap<String, Double> ratingRatio = new HashMap<String, Double>() {{
            put("negative", 0.9);
            put("positive", 1.25);
        }};



        /*
            Вход
            Входът се чете от конзолата и се състои от три реда:
            •	Първи ред - дни за престой - цяло число в интервала [0...365]
            •	Втори ред - вид помещение - "room for one person", "apartment" или "president apartment"
            •	Трети ред - оценка - "positive"  или "negative"
        */

        // Get User Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"amountStays", "roomType", "rating"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        // Validation Block for User Inputs
        if (!(Arrays.asList("positive", "negative").contains(userInputs.get("rating")))) { return; }
        if (!(Arrays.asList("room for one person", "apartment", "president apartment").contains(userInputs.get("roomType")))) { return; }
        Integer num = 0;
        try {
            num = Integer.parseInt(userInputs.get("amountStays").toString());
            if ( (!(IntegerValidateInput(num, new Integer[]{0, 365}))) ){
                return;
            }
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch
        num -= 1;

        // System.out.printf("\n%s", Arrays.toString(roomDiscounts.get(userInputs.get("roomType"))));

        iDiscountStatus iDis = (b, r) -> { // getDiscount(Boolean test, Double toReturn)
            if (b) {
                return r;
            }
            return false;
        };

        // System.out.printf("\n%s", (roomDiscounts.get(userInputs.get("roomType"))[0]));

        Object discount = new ArrayList<Object>(
                Arrays.asList(
                    iDis.getDiscount((num < 10), (roomDiscounts.get(userInputs.get("roomType"))[0])),
                    iDis.getDiscount(((10 < num) && (num < 15)), (roomDiscounts.get(userInputs.get("roomType"))[1])),
                    iDis.getDiscount( (num > 15), (roomDiscounts.get(userInputs.get("roomType"))[2]))
                )).stream().filter(o -> !o.equals(false)).findFirst().orElse(0.00);
        System.out.printf("Price: %.2f",
                (num * priceList.get(userInputs.get("roomType")) *
                        ratingRatio.get(userInputs.get("rating")) * (1.0 - Double.parseDouble(discount.toString())))
        );

    } // main
}// class


