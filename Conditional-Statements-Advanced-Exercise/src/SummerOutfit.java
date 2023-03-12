
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummerOutfit {
    /*
        Лято е с много променливо време и Виктор има нужда от вашата помощ.
        Напишете програма която спрямо времето от денонощието и градусите да препоръча на Виктор какви дрехи да си облече.
        Вашия приятел има различни планове за всеки етап от деня,
        които изискват и различен външен вид, тях може да видите от таблицата.
        От конзолата се четат точно два реда:
        •	Градусите - цяло число в интервала [10…42]
        •	Текст, време от денонощието - с възможности - "Morning", "Afternoon", "Evening"

        Време от денонощието / градуси
        Мorning	    Afternoon	    Evening
        10 <= градуси <= 18	Outfit = Sweatshirt
        Shoes = Sneakers	Outfit = Shirt
        Shoes = Moccasins	Outfit = Shirt
        Shoes = Moccasins
        18 < градуси <= 24	Outfit = Shirt
        Shoes = Moccasins	Outfit = T-Shirt
        Shoes = Sandals	Outfit = Shirt
        Shoes = Moccasins
        градуси >= 25	Outfit = T-Shirt
        Shoes = Sandals	Outfit = Swim Suit
        Shoes = Barefoot	Outfit = Shirt
        Shoes = Moccasins


     */

    // Function to get ArrayList from Stream
    // https://www.geeksforgeeks.org/how-to-get-arraylist-from-stream-in-java-8/
    public static <T> ArrayList<T> getArrayListFromStream(Stream<T> stream) {
        List<T> list = stream.collect(Collectors.toList()); // Convert the Stream to List
        ArrayList<T> arrayList = new ArrayList<T>(list); // Create an ArrayList of the List
        return arrayList; // Return the ArrayList
    }// getArrayListFromStream

    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {
        List<List<Clothing>> clothingTable = new ArrayList<>();
        clothingTable.add(Arrays.asList(
            new Clothing(new Double[]{10.0, 18.0}, "Morning", "Sweatshirt", "Sneakers"),
            new Clothing(new Double[]{18.0, 24.0}, "Morning", "Shirt", "Moccasins"),
            new Clothing(new Double[]{25.0, Double.POSITIVE_INFINITY}, "Morning", "T-Shirt", "Sandals")
        ));
        clothingTable.add(Arrays.asList(
                new Clothing(new Double[]{10.0, 18.0}, "Afternoon", "Shirt", "Moccasins"),
                new Clothing(new Double[]{18.0, 24.0}, "Afternoon", "T-Shirt", "Sandals"),
                new Clothing(new Double[]{25.0, Double.POSITIVE_INFINITY}, "Afternoon", "Swim Suit", "Barefoot")
        ));
        clothingTable.add(Arrays.asList(
                new Clothing(new Double[]{10.0, 18.0}, "Evening", "Shirt", "Moccasins"),
                new Clothing(new Double[]{18.0, 24.0}, "Evening", "Shirt", "Moccasins"),
                new Clothing(new Double[]{25.0, Double.POSITIVE_INFINITY}, "Evening", "Shirt", "Moccasins")
        ));

        ArrayList<Clothing> clothingList = new ArrayList<Clothing>(){{
            add(new Clothing(new Double[]{10.0, 18.0}, "Morning", "Sweatshirt", "Sneakers"));
            add(new Clothing(new Double[]{18.0, 24.0}, "Morning", "Shirt", "Moccasins"));
            add(new Clothing(new Double[]{25.0, Double.POSITIVE_INFINITY}, "Morning", "T-Shirt", "Sandals"));
            add(new Clothing(new Double[]{10.0, 18.0}, "Afternoon", "Shirt", "Moccasins"));
            add(new Clothing(new Double[]{18.0, 24.0}, "Afternoon", "T-Shirt", "Sandals"));
            add(new Clothing(new Double[]{25.0, Double.POSITIVE_INFINITY}, "Afternoon", "Swim Suit", "Barefoot"));
            add(new Clothing(new Double[]{10.0, 18.0}, "Evening", "Shirt", "Moccasins"));
            add(new Clothing(new Double[]{18.0, 24.0}, "Evening", "Shirt", "Moccasins"));
            add(new Clothing(new Double[]{25.0, Double.POSITIVE_INFINITY}, "Evening", "Shirt", "Moccasins"));
        }};

        // Get user Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"degrees", "daytime"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.next());
        }// for

        if (!(Arrays.asList("Morning", "Evening", "Afternoon").contains(userInputs.get("daytime"))))
        { return; }

        Double deg = -1.0;
        try {
            Integer degrees = Integer.parseInt(userInputs.get("degrees").toString());
            deg = Double.parseDouble(degrees.toString());
            if (!(DoubleValidateInput(deg, new Double[]{10.0, 42.0}))) {
                return;
            }

        }
        catch (Exception e)  {
            System.out.println("* Error occured: " + e.toString());
        } // catch


        // https://stackoverflow.com/questions/41741425/getting-only-first-element-of-arraylist-that-matches-condition

        // https://stackoverflow.com/questions/22940416/fetch-first-element-of-stream-matching-the-criteria
        Double finalDeg = deg;
        Stream str1 = clothingList.stream().filter(c -> c.RangeMatch(finalDeg));
        ArrayList<Clothing> cl1 = getArrayListFromStream(str1);
        //System.out.println(cl1.size());

        Stream<Clothing> str2 = cl1.stream().filter(c -> c.DayTimeMatch((userInputs.get("daytime")).toString())); //.findFirst().orElse(null);
        ArrayList<Clothing> cl2 = getArrayListFromStream(str2);
        // System.out.println(cl2.size());

        Clothing res = cl1.stream().filter(c -> c.DayTimeMatch((userInputs.get("daytime")).toString())).findFirst().orElse(null);

        // Да се отпечата на конзолата на един ред: "It's {градуси} degrees, get your {облекло} and {обувки}."
        System.out.printf("It's %.0f degrees, get your %s and %s.", res.degrees, res.outfit, res.shoes);


    }// main
}// class SummerOutfit


// https://stackoverflow.com/questions/19880185/java-initialize-2d-arraylist
// List<List<Integer>> group = new ArrayList<>();
// group.add(Arrays.asList(1, 2, 3));

// new Clothing()
class Clothing {
    Double[] range;
    String outfit, shoes, daytime;
    Double degrees;
    // constructor
    public Clothing(Double[] Range, String dayTime, String Outfit, String Shoes) {
        outfit  = Outfit;
        shoes  = Shoes;
        range = Range;
        daytime = dayTime;
    }

    public Boolean RangeMatch (Double dbl) {
        degrees = dbl;
        return ((dbl > range[0]) && (dbl < range[1]));
    }
    public Boolean DayTimeMatch (String dayTime) {
        return (daytime.equals(dayTime));
    }
}// class Clothing

