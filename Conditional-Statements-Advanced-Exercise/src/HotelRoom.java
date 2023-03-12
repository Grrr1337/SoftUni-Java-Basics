import java.util.*;

public class HotelRoom {
    /*
        7.	Хотелска стая
        Хотел предлага 2 вида стаи: студио и апартамент.
        Напишете програма, която изчислява цената за целия престой за студио и апартамент.
        Цените зависят от месеца на престоя:
        Май и октомври	Юни и септември	Юли и август
        Студио – 50 лв./нощувка	Студио – 75.20 лв./нощувка	Студио – 76 лв./нощувка
        Апартамент – 65 лв./нощувка	Апартамент – 68.70 лв./нощувка	Апартамент – 77 лв./нощувка
        Предлагат се и следните отстъпки:
        •	За студио, при повече от 7 нощувки през май и октомври : 5% намаление.
        •	За студио, при повече от 14 нощувки през май и октомври : 30% намаление.
        •	За студио, при повече от 14 нощувки през юни и септември: 20% намаление.
        •	За апартамент, при повече от 14 нощувки, без значение от месеца : 10% намаление.
        Вход
        Входът се чете от конзолата и съдържа точно 2 реда, въведени от потребителя:
        •	На първия ред е месецът – May, June, July, August, September или October
        •	На втория ред е броят на нощувките – цяло число в интервала [0 ... 200]
        Изход
        Да се отпечатат на конзолата 2 реда:
        •	На първия ред: "Apartment: {цена за целият престой} lv."
        •	На втория ред: "Studio: {цена за целият престой} lv."
        Цената за целия престой форматирана с точност до два знака след десетичната запетая.
     */

    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        HashMap<String, Double[]> budgetRatio = new HashMap<String, Double[]>() {{
            put("summer", new Double[]{0.3, 0.4});
            put("winter", new Double[]{0.7, 0.8});
        }};

        /*
            Вход
            Входът се чете от конзолата и съдържа точно 2 реда, въведени от потребителя:
            •	На първия ред е месецът – May, June, July, August, September или October
            •	На втория ред е броят на нощувките – цяло число в интервала [0 ... 200]
        */

        // Get User Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"month", "overnights"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for


        // Validation Block for User Inputs
        Integer num;
        if (!(Arrays.asList("May", "June", "July", "August", "September", "October").contains(userInputs.get("month")))) { return; }
        try {
            num = Integer.parseInt(userInputs.get("overnights").toString());
            if ( (!(IntegerValidateInput(num, new Integer[]{0, 200}))) ){
                return;
            }
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch

        HashMap<String, Double> prices = new HashMap<String, Double>();
        Double[] reductionFactors = new Double[] {1.00, 1.00}; // studio apartment

        if (Arrays.asList("May", "October").contains(userInputs.get("month"))) {
            prices.put("studio", 50.0);
            prices.put("apartment", 65.0);
            if (num > 14) {
                reductionFactors[0] += -0.30;
                reductionFactors[1] += -0.1;
            } else if (num > 7) {
                reductionFactors[0] += -0.05;
            }
        }// if
        else if (Arrays.asList("June", "September").contains(userInputs.get("month"))) {
            prices.put("studio", 75.20);
            prices.put("apartment", 68.7);
            if (num > 14) {
                reductionFactors[0] += -0.20;
                reductionFactors[1] += -0.1;
            } // else if (num > 7) { }
        }// if
        else if (Arrays.asList("July", "August").contains(userInputs.get("month"))) {
            prices.put("studio", 76.0);
            prices.put("apartment", 77.0);
            if (num > 14) {
                reductionFactors[1] += -0.1;
            } // else if (num > 7) { }
        }// if

        /*
            Да се отпечатат на конзолата 2 реда:
            •	На първия ред: "Apartment: {цена за целият престой} lv."
            •	На втория ред: "Studio: {цена за целият престой} lv."
        */

        System.out.printf("Apartment: %s lv." + "\nStudio: %s lv.",
            String.format("%.2f", (prices.get("apartment") * reductionFactors[1] * num)),
            String.format("%.2f", (prices.get("studio") * reductionFactors[0] * num))
        );

    }// main

}// class