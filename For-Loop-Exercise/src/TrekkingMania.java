

import java.text.DecimalFormat;
import java.util.*;


public class TrekkingMania {
    /*
        . Трекинг мания
        Катерачи от цяла България се събират на групи и набелязват следващите върхове за изкачване.
         Според размера на групата, катерачите ще изкачват различни върхове.
        •	Група до 5 човека – изкачват Мусала
        •	Група от 6 до 12 човека – изкачват Монблан
        •	Група от 13 до 25 човека – изкачват Килиманджаро
        •	Група от 26 до 40 човека –  изкачват К2
        •	Група от 41 или повече човека – изкачват Еверест
        Да се напише програма, която изчислява процента на катерачите изкачващи всеки връх.

        Вход
        От конзолата се четат поредица от числа, всяко на отделен ред:
        •	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
        •	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]

        Изход
        Да се отпечатат на конзолата 5 реда, всеки от които съдържа процент между 0.00% и 100.00%
        с точност до втората цифра след десетичната запетая.
        •	Първи ред - процентът изкачващи Мусала
        •	Втори ред – процентът изкачващи Монблан
        •	Трети ред – процентът изкачващи Килиманджаро
        •	Четвърти ред – процентът изкачващи К2
        •	Пети ред – процентът изкачващи Еверест
    */
    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    @FunctionalInterface
    public interface iGroupSize {
        public Boolean putGroupTypeByRange(Integer providedAmount, Integer[] range, String groupName, Map<String, Integer>groupMap);
    }// iHotelRoom

    public static void main(String[] args) {

        //•	Група до 5 човека – изкачват Мусала
        //•	Група от 6 до 12 човека – изкачват Монблан
        //•	Група от 13 до 25 човека – изкачват Килиманджаро
        //•	Група от 26 до 40 човека –  изкачват К2
        //•	Група от 41 или повече човека – изкачват Еверест

//        Map<String, Integer> climberGroups = new DefaultHashMap<>() {{
//            put("Мусала", 0);
//            put("Монблан", 0);
//            put("Килиманджаро", 0);
//            put("К2", 0);
//            put("Еверест", 0);
//            put("", 0); // not sure if i need it
//        }};

        TreeMap<String, Integer> climberGroups = new TreeMap<>(Collections.reverseOrder()) {{ // NOTE: "TreeMap" is naturally sorted datastructure!
            put("Мусала", 0);
            put("Монблан", 0);
            put("Килиманджаро", 0);
            put("К2", 0);
            put("Еверест", 0);
            put("", 0); // not sure if i need it
        }};


//        HashMap<String, Integer> climberGroups = new DefaultHashMap<>() {{
//            put("Мусала", 0);
//            put("Монблан", 0);
//            put("Килиманджаро", 0);
//            put("К2", 0);
//            put("Еверест", 0);
//            put("", 0);
//        }};

        /*
            Вход
            От конзолата се четат поредица от числа, всяко на отделен ред:
            •	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
            •	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]
        */

        //На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]

        Scanner scn = new Scanner(System.in);
        System.out.println("Input the amount of groups [1-1000]: ");
        Integer amountOfGroups = Integer.parseInt(scn.nextLine().toString());

        if (!(IntegerValidateInput(amountOfGroups, new Integer[]{1, 1000}))) { return; }

        // public Boolean putGroupTypeByRange(Integer providedAmount, Integer[] range, String groupName, Map<String, Integer>groupMap);
        iGroupSize iGS = (n, range, grpnm, map) -> { // String stringFormatting, Boolean isOnTime, String timeDiff
            if ((range[0] <= n && n <= range[1])) {
                // map.put(key, map.get(key) + 1);
                map.put(grpnm, map.get(grpnm) + n);
                return true;
            }
            return false;
        };



        // За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]
        Object inp;
        Integer intinp;
        Integer totalClimbers = 0;
        Boolean toThrowError = false;
        for (int i = 0; i < amountOfGroups; i++){
            System.out.printf("Input %d groupSize [1-1000]: ", i); // Arrays.toString(ranges[n]) , Arrays.toString(ranges[n++])
            inp = scn.nextLine();

            try {
                Integer tmp = Integer.parseInt(inp.toString());
                if (!(IntegerValidateInput(tmp, new Integer[]{1, 1000}))) { toThrowError = true; }
            }
            catch (Exception e) {
                System.out.printf("\nException occured: %s", e.toString());
                toThrowError = true;
            }// catch

            intinp = Integer.parseInt(inp.toString());
            //•	Група до 5 човека – изкачват Мусала
            //•	Група от 6 до 12 човека – изкачват Монблан
            //•	Група от 13 до 25 човека – изкачват Килиманджаро
            //•	Група от 26 до 40 човека –  изкачват К2
            //•	Група от 41 или повече човека – изкачват Еверест

            boolean foundMap = ( // putGroupTypeByRange(Integer providedAmount, Integer[] range, String groupName, Map<String, Integer>groupMap);
                iGS.putGroupTypeByRange(intinp, new Integer[]{0, 5}, "Мусала", climberGroups) ||
                iGS.putGroupTypeByRange(intinp, new Integer[]{6, 12}, "Монблан", climberGroups) ||
                iGS.putGroupTypeByRange(intinp, new Integer[]{13, 25}, "Килиманджаро", climberGroups) ||
                iGS.putGroupTypeByRange(intinp, new Integer[]{26, 40}, "К2", climberGroups) ||
                iGS.putGroupTypeByRange(intinp, new Integer[]{41, Integer.MAX_VALUE}, "Еверест", climberGroups) ||
                // Not sure if I need this, but I'm gonna add it anyway:
                iGS.putGroupTypeByRange(intinp, new Integer[]{Integer.MIN_VALUE, Integer.MAX_VALUE}, "", climberGroups)
            );
            if (!foundMap) { toThrowError = true; }
            else { totalClimbers += intinp; };

            // map.put(key, map.get(key) + 1);
        }// for

        if (toThrowError) return;

        // Outputs
        // https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
//        System.out.println("\n*0------------------------------------\n");
//        climberGroups.entrySet().forEach(entry -> { System.out.println(entry.getKey() + " " + entry.getValue()); });


////        DecimalFormat df = new DecimalFormat("#.##");
//        Integer finalTotalClimbers = totalClimbers;
//        climberGroups.entrySet().forEach(entry -> {
//            System.out.printf("\n%s -- %s",
//                    entry.getKey() ,
//                    String.format("%.2f%%",
//                            ( 100.0 *
//                    (Double.parseDouble(entry.getValue().toString()) /
//                            Double.parseDouble(finalTotalClimbers.toString()))
//                    )));
//
////                    String.format("%.2f",
////                    Double.valueOf(df.format(
////                            (Double.parseDouble(entry.getValue().toString()) /
////                                    Double.parseDouble(finalTotalClimbers.toString()))
////                    ))));
//        }); // forEach



//        DecimalFormat df = new DecimalFormat("#.##");
        Integer finalTotalClimbers = totalClimbers;
        climberGroups.entrySet().forEach(entry -> {
            if (!(entry.getKey().equals(""))) {
                System.out.printf("%s\n",
                        String.format("%.2f%%",
                                (100.0 * (Double.parseDouble(entry.getValue().toString()) /
                                                Double.parseDouble(finalTotalClimbers.toString()))
                                )));
            }// if
        }); // forEach

// https://stackoverflow.com/questions/1708444/java-literal-percent-sign-in-printf-statement
// The percent sign is escaped using a percent sign:
// Escaped percent sign is double percent (%%):


//
//        System.out.println("\n*1------------------------------------\n");
//        // Display the TreeMap which is naturally sorted
//        for (Map.Entry<String, Integer> entry : climberGroups.entrySet())
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//
//        System.out.println("\n*2------------------------------------\n");
//        // Traverse map and print elements
//        Set set = climberGroups.entrySet();
//        Iterator idx = set.iterator();
//        while (idx.hasNext()) {
//            Map.Entry me = (Map.Entry)idx.next();
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
//        }// while

    }// main
}// class




/* https://stackabuse.com/how-to-format-a-string-in-java-with-examples/
%c - Character
%d - Decimal number (base 10)
%e - Exponential floating-point number
%f - Floating-point number
%i - Integer (base 10)
%o - Octal number (base 8)
%s - String
%u - Unsigned decimal (integer) number
%x - Hexadecimal number (base 16)
%t - Date/time
%n - Newline
*/


// https://stackoverflow.com/questions/4157972/how-to-update-a-value-given-a-key-in-a-hashmap
// How to update a value, given a key in a hashmap?
// map.put(key, map.get(key) + 1);

//•	Група до 5 човека – изкачват Мусала
//•	Група от 6 до 12 човека – изкачват Монблан
//•	Група от 13 до 25 човека – изкачват Килиманджаро
//•	Група от 26 до 40 човека –  изкачват К2
//•	Група от 41 или повече човека – изкачват Еверест


/*
// https://stackoverflow.com/questions/7519339/hashmap-to-return-default-value-for-non-found-keys
// https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/
class DefaultHashMap<K,V> extends HashMap<K,V> {
    public V getDefault(K key, V defaultValue) {
        if (containsKey(key)) {
            return get(key);
        }

        return defaultValue;
    }
}// class
*/
