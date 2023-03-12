
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cinema {
    /*
        В една кинозала столовете са наредени в правоъгълна форма в r реда и c колони. Има три вида прожекции с билети на различни цени:
        •	Premiere – премиерна прожекция, на цена 12.00 лева.
        •	Normal – стандартна прожекция, на цена 7.50 лева.
        •	Discount – прожекция за деца, ученици и студенти на намалена цена от 5.00 лева.
        Напишете програма, която чете тип прожекция (стринг), брой редове и брой колони в залата (цели числа),
        въведени от потребителя, и изчислява общите приходи от билети при пълна зала.
        Резултатът да се отпечата във формат като в примерите по-долу, с 2 знака след десетичната точка.
     */
    public static void main(String[] args) {
        Map<String, Double> priceList = Stream.of(new Object[][] {
            { "Premiere", 12.00 },
            { "Normal", 7.50 },
            { "Discount", 5.00}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Double) data[1]));

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"proj", "R", "C"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.next());
        }// for

        System.out.printf("%.2f",
        (Double.parseDouble(priceList.get(userInputs.get("proj")).toString()) *
        Integer.parseInt(userInputs.get("R").toString()) *
        Integer.parseInt(userInputs.get("C").toString()) ));

        System.out.print(" leva");
    }// main
}
