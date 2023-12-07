

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Oscars {
    /*
        6. Оскари
        Поканени сте от академията да напишете софтуер, който да пресмята точките за актьор/актриса.
        Академията ще ви даде първоначални точки за актьора. След това всеки оценяващ ще дава своята оценка.
        Точките, които актьора получава се формират от:
        дължината на името на оценяващия умножено по точките, които дава делено на две.
        Ако резултатът в някой момент надхвърли 1250.5 програмата трябва да прекъсне и
        да се отпечата, че дадения актьор е получил номинация.
        Вход
        •	Име на актьора - текст
        •	Точки от академията - реално число в интервала [2.0... 450.5]
        •	Брой оценяващи n - цяло число в интервала[1… 20]
        На следващите n-на брой реда:
        o	Име на оценяващия - текст
        o	Точки от оценяващия - реално число в интервала [1.0... 50.0]
        Изход
        Да се отпечата на конзолата един ред:
        •	Ако точките са над 1250.5:
        "Congratulations, {име на актьора} got a nominee for leading role with {точки}!"
        •	Ако точките не са достатъчни:
        "Sorry, {име на актьора} you need {нужни точки} more!"
        Резултатът да се форматирана до първата цифра след десетичния знак!
     */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        HashMap<String, Object> evaluatorScores = new DefaultHashMap<String, Object>() {{
            // put("key", 0.0);
        }};

        Map<String, Object> eScores = new DefaultHashMap<String, Object>() {{
            // put("key", 0.0);
        }};

        /*
            Вход
            •	Име на актьора - текст
            •	Точки от академията - реално число в интервала [2.0... 450.5]
            •	Брой оценяващи n - цяло число в интервала[1… 20]
            На следващите n-на брой реда:
            o	Име на оценяващия - текст
            o	Точки от оценяващия - реално число в интервала [1.0... 50.0]
         */
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"actorName", "academyScore", "amountEvaluators"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" : ", k); // Arrays.toString(ranges[n]) , Arrays.toString(ranges[n++])
            userInputs.put(k, scn.nextLine());
        }// for

        Double academyScore = 0.0;
        Integer amountEvaluators = 0;
        int n;
        // Validate user inputs
        Double[][] ranges = new Double[][]{{2.0, 450.5}, {1.0, 20.0}};
        try {
            n = 0;
//            for (String k : new String[]{"openTabs"}) { // isInteger ?
//                Integer.parseInt(userInputs.get(k).toString());
//            }
            academyScore = Double.parseDouble(userInputs.get("academyScore").toString());
            amountEvaluators = Integer.parseInt(userInputs.get("amountEvaluators").toString());

            for(String k : new String[]{"academyScore", "amountEvaluators"}) { // isWithinRange?
                if (!(DoubleValidateInput(Double.parseDouble(userInputs.get(k).toString()), ranges[n++]))) {
                    return;
                }// if
            }// for
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch

        /*
            На следващите n-на брой реда:
            o	Име на оценяващия - текст
            o	Точки от оценяващия - реално число в интервала [1.0... 50.0]
        */
        // get inputs and process them:
        Object inp1, inp2;
        Double sumScores = academyScore;
        Double recalcInput = 0.0;
        Double nominationLimit = 1250.5;
        boolean toReturn = false; // return after getting all the inputs (and initially validating them)
        for (int i = 0; i < amountEvaluators; i++){
            System.out.printf("\nInput %d evaluator's Name: ", i);
            inp1 = scn.nextLine();
            System.out.printf("Input %d evaluator's Score: ", i);
            inp2 = scn.nextLine();

            try {
                // Integer.parseInt(inp2.toString());
                if (!(DoubleValidateInput(Double.parseDouble(inp2.toString()), new Double[]{1.0, 50.0}))) {
                    toReturn = true;
                }
                if (!toReturn) {
                    recalcInput = ((inp1.toString().length() * Double.parseDouble(inp2.toString())) / 2.0);
                    sumScores += recalcInput;
                }
            }
            catch (Exception e) {
                System.out.printf("\nException occured: %s", e.toString());
                toReturn = true;
            }// catch

            // Точките, които актьора получава се формират от: дължината на името на оценяващия умножено по точките, които дава делено на две.
            // Johnny Depp  gave a score of 45,  ((11 * 45) / 2


            // Ако резултатът в някой момент надхвърли 1250.5 програмата трябва да прекъсне и да се отпечата, че дадения актьор е получил номинация.
            // "Congratulations, {име на актьора} got a nominee for leading role with {точки}!"
            if (sumScores > nominationLimit) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %s!",
                        userInputs.get("actorName"), String.format("%.1f", sumScores));
                return;
            }// if

            // evaluatorScores.put(inp1.toString(), inp2);
            eScores.put(inp1.toString(), recalcInput);
            // salary += sanctions.getOrDefault(input2 , 0.0);
        }// for

        if (toReturn) { return; };

        Double diff = sumScores - nominationLimit;
        System.out.printf("\nsumScores: %.0f | diff: %.1f", sumScores, diff);

//        if (diff < 0) {
//            System.out.printf("Sorry, %s you need %s more!",
//                    userInputs.get("actorName"),
//                    String.format("%.0f", Math.abs(diff)));
//        }

        System.out.printf(((diff < 0)? "Sorry, %s you need %s more!" : "Congratulations, %s got a nominee for leading role with %s!"),
                userInputs.get("actorName"),
                String.format("%.1f", Math.abs((diff < 0)? diff : sumScores)));


        // Outputs
        // https://stackoverflow.com/questions/5920135/printing-hashmap-in-java
//        evaluatorScores.entrySet().forEach(entry -> { System.out.println(entry.getKey() + " " + entry.getValue()); });
//        System.out.println("\n------------------------------------\n");
       // eScores.entrySet().forEach(entry -> { System.out.println(entry.getKey() + " " + entry.getValue()); });

    }// main
}// class

//Double.parseDouble( .toString())

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
/*
Input "actorName" : Zahari Baharov
Input "academyScore" : 205
Input "amountEvaluators" : 4

Input 0 evaluator's Name: Johnny Depp
Input 0 evaluator's Score: 45

Input 1 evaluator's Name: Will Smith
Input 1 evaluator's Score: 29

Input 2 evaluator's Name: Jet Lee
Input 2 evaluator's Score: 10

Input 3 evaluator's Name: Matthew Mcconaughey
Input 3 evaluator's Score: 39

*/
/*
Sandra Bullock
340
5
Robert De Niro
50
Julia Roberts
40.5
Daniel Day-Lewis
39.4
Nicolas Cage
29.9
Stoyanka Mutafova
33

 */
