


import java.util.Scanner;
import java.util.HashMap;

import java.lang.Math;


public class ToyShop {
    /*
        Цени на играчките:
        •	Пъзел - 2.60 лв.
        •	Говореща кукла - 3 лв.
        •	Плюшено мече - 4.10 лв.
        •	Миньон - 8.20 лв.
        •	Камионче - 2 лв.
        Ако поръчаните играчки са 50 или повече магазинът прави отстъпка 25% от общата цена.
        От спечелените пари Петя трябва да даде 10% за наема на магазина.
        Да се пресметне дали парите ще ѝ стигнат да отиде на екскурзия.

        Вход
        От конзолата се четат 6 реда:
        1.	Цена на екскурзията - реално число в интервала [1.00 … 10000.00]
        2.	Брой пъзели - цяло число в интервала [0… 1000]
        3.	Брой говорещи кукли - цяло число в интервала [0 … 1000]
        4.	Брой плюшени мечета - цяло число в интервала [0 … 1000]
        5.	Брой миньони - цяло число в интервала [0 … 1000]
        6.	Брой камиончета - цяло число в интервала [0 … 1000]

        Изход
        На конзолата се отпечатва:
        •	Ако парите са достатъчни се отпечатва:
        o	"Yes! {оставащите пари} lv left."
        •	Ако парите НЕ са достатъчни се отпечатва:
        o	"Not enough money! {недостигащите пари} lv needed."
     */

    private static boolean DoubleValidateInput(double val, double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        boolean ToThrowError = false; // variable to throw error after collecting all of the user inputs

        double ShopDiscount = 0.75; // Ако поръчаните играчки са 50 или повече магазинът прави отстъпка 25% от общата цена.
        double rentRatio = 0.9; // От спечелените пари Петя трябва да даде 10% за наема на магазина.
        int PurchasedAmount;
        int SoldAmount = 0;
        Double ShopProfit = 0.0;
        Double savedMoney = 0.0;

        HashMap<String, Double> shopPrices = new HashMap<String, Double>();
        shopPrices.put("Пъзел", 2.60);
        shopPrices.put("Говореща кукла", 3.00);
        shopPrices.put("Плюшено мече", 4.10);
        shopPrices.put("Миньон", 8.20);
        shopPrices.put("Камионче", 2.00);

        Scanner scn = new Scanner(System.in);


        System.out.println("Input the required money for the excursion (1.00 - 10000.00): ");
        Double excursionPrice = Double.valueOf(scn.nextLine()); // 1.	Цена на екскурзията - реално число в интервала [1.00 … 10000.00]
        if (!(DoubleValidateInput(excursionPrice, new double[] {1.00, 10000.00}))) { // [1.00 … 10000.00]
            ToThrowError = true;
        }

        for (String k : new String[] {"Пъзел", "Говореща кукла", "Плюшено мече", "Миньон", "Камионче" }) {
            Double artVal = (Double) shopPrices.get(k);

            System.out.printf("\nInput amount for \"%s\" ($%.2f): ", k, artVal);
            PurchasedAmount = Integer.parseInt(scn.nextLine());

            if (!(IntValidateInput(PurchasedAmount, new Integer[] {0, 1000}))) {
                ToThrowError = true;
            }

            SoldAmount += PurchasedAmount;
            ShopProfit += (PurchasedAmount * artVal);

        } // for

        if (ToThrowError) {
            throw new RuntimeException("Invalid input!");
        }

        if (SoldAmount >= 50) { // Ако поръчаните играчки са 50 или повече магазинът прави отстъпка 25% от общата цена.
            ShopProfit *= ShopDiscount;
        }

        ShopProfit *= rentRatio; // От спечелените пари Петя трябва да даде 10% за наема на магазина.
        savedMoney = ShopProfit - excursionPrice;
//        System.out.printf("\nAmount of sales: \"%d\" Profit: $%.2f: ", SoldAmount, ShopProfit);
//        System.out.printf("\nMoney left: $%.2f: ", savedMoney);

        if (savedMoney > 0.0) {
            System.out.printf("Yes! %.2f lv left.", savedMoney);
        }
        else {
            System.out.printf("Not enough money! %.2f lv needed.", Math.abs(savedMoney));
        }


    }// main
}
