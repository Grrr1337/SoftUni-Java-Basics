import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class TrainTheTrainers {
    /*
        4.	Train the Trainers
        Курсът "Train the trainers" е към края си и финалното оценяване наближава.
        Вашата задача е да помогнете на журито което ще оценява презентациите,
        като напишете програма в която да изчислява средната оценка
        от представянето на всяка една презентация от даден студент, а накрая средният успех от всички тях.

        От конзолата на първият ред се прочита броят на хората в журито n - цяло число в интервала [1…20]
        След това на отделен ред се прочита името на презентацията - текст
        За всяка една презентация на нов ред се четат n - на брой оценки - реално число в интервала [2.00…6.00]
        След изчисляване на средната оценка за конкретна презентация, на конзолата се печата
        "{името на презентацията} - {средна оценка}."
        След получаване на команда "Finish" на конзолата се печата "Student's final assessment is {среден успех от всички презентации}." и програмата приключва.
        Всички оценки трябва да бъдат форматирани до втория знак след десетичната запетая.
    */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/how-to-create-a-treemap-in-reverse-order-in-java/
        TreeMap<String, Double> scores = new TreeMap<>(Collections.reverseOrder()) {};

        /*
            От конзолата на първият ред се прочита броят на хората в журито n - цяло число в интервала [1…20]
            След това на отделен ред се прочита името на презентацията - текст
            За всяка една презентация на нов ред се четат n - на брой оценки - реално число в интервала [2.00…6.00]
        */

        Object inp;
        Scanner scn = new Scanner(System.in);
        inp = scn.nextLine();
        Integer n = 0;
        try {
            n = Integer.parseInt(inp.toString());
            if (!(DoubleValidateInput(Double.parseDouble(n.toString()), new Double[]{1.0, 20.0}))) {
                throw new RuntimeException("Out of range!");
            }
        }
        catch (Exception e) { return ; }

        ArrayList<String> keysL = new ArrayList<>();
        Object score;
        // int cnt;
        while (true) { // След това на отделен ред се прочита името на презентацията - текст
            String inpk = scn.nextLine();
            if (inpk.equals("Finish")) { break; }
            keysL.add(inpk);
            scores.put(inpk, 0.0);
            // cnt = 0;
            for (int i = 0 ; i < n; i++) { // четат n - на брой оценки - реално число в интервала [2.00…6.00]
                score = scn.nextLine();
                scores.put(inpk, scores.get(inpk) + Double.parseDouble(score.toString()));
                // cnt++;
                if (score.equals("Finish")) { return; }
            }// for


        }// while

        // https://stackoverflow.com/questions/4157972/how-to-update-a-value-given-a-key-in-a-hashmap
        //  map.put(key, map.get(key) + 1);
        Integer finalN = n;
        // https://www.geeksforgeeks.org/how-to-iterate-hashmap-in-java/
//        scores.forEach( (key, value) -> {
//            System.out.printf("%s - %s.\n", key, String.format("%.2f", (value / finalN)));
//        });

        keysL.forEach((k)-> {
            System.out.printf("%s - %s.\n", k,
                    String.format("%.2f", (Double.parseDouble(scores.get(k).toString()) / finalN)));
        });

        Double sum = 0.0;
        // https://stackoverflow.com/questions/21665538/how-to-sum-values-from-java-hashmap
        for (Double val : scores.values()){ sum += val; }

        // System.out.println(sum);
        // System.out.println(scores.size());

        System.out.printf("Student's final assessment is %s.",
                String.format("%.2f", (sum / (scores.size() * n)))); // {среден успех от всички презентации}



    }// main
}// class


