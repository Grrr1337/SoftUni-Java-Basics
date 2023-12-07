

import java.util.*;

public class TennisRanklist {
    /*
        8. Световна ранглиста по тенис
        Григор Димитров е тенисист, чиято следваща цел е изкачването в световната ранглиста по тенис за мъже.
        През годината Гришо участва в определен брой турнири, като за всеки турнир получава точки,
        които зависят от позицията, на която е завършил в турнира. Има три варианта за завършване на турнир:
        	W - ако е победител получава 2000 точки
        	F - ако е финалист получава 1200 точки
        	SF - ако е полуфиналист получава 720 точки
        Напишете програма, която изчислява колко ще са точките на Григор след изиграване на всички турнири,
        като знаете с колко точки стартира сезона.
        Също изчислете колко точки средно печели от всички изиграни турнири и колко процента от турнирите е спечелил.

        Вход
        От конзолата първо се четат два реда:
        •	Брой турнири, в които е участвал – цяло число в интервала [1…20]
        •	Начален брой точки в ранглистата - цяло число в интервала [1...4000]
        За всеки турнир се прочита отделен ред:
        •	Достигнат етап от турнира – текст – "W", "F" или "SF"

        Изход
        Отпечатват се три реда в следния формат:
        •	"Final points: {брой точки след изиграните турнири}"
        •	"Average points: {средно колко точки печели за турнир}"
        •	"{процент спечелени турнири}%"
        Средните точки да бъдат закръглени към най-близкото цяло число надолу, а процентът да се форматира до втората цифра след десетичния знак.
    */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {
        /*
            	W - ако е победител получава 2000 точки
            	F - ако е финалист получава 1200 точки
            	SF - ако е полуфиналист получава 720 точки
        */
//        TreeMap<String, Integer> scoreWFSF = new TreeMap<>() {{ // NOTE: "TreeMap" is naturally sorted datastructure!
//            put("W", 2000);
//            put("F", 1200);
//            put("SF", 720);
//            put("", 0); // not sure if i need it
//        }};

        TreeMap<String, Double> scoreWFSF = new TreeMap<>() {{ // NOTE: "TreeMap" is naturally sorted datastructure!
            put("W", 2000.0);
            put("F", 1200.0);
            put("SF", 720.0);
            put("", 0.0); // not sure if i need it
        }};

        /*
            Вход
            От конзолата първо се четат два реда:
            •	Брой турнири, в които е участвал – цяло число в интервала [1…20]
            •	Начален брой точки в ранглистата - цяло число в интервала [1...4000]
            За всеки турнир се прочита отделен ред:
            •	Достигнат етап от турнира – текст – "W", "F" или "SF"
        */

        // Get User Inputs:
        int n = 0;
        Double[][] ranges = new Double[][]{{1.0, 20.0},{1.0, 4000.0}};

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"tournirsAmount", "initialScore"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" %s: ", k, Arrays.toString(ranges[n++])); // Arrays.toString(ranges[n]) , Arrays.toString(ranges[n++])
            userInputs.put(k, scn.nextLine());
        }// for

        // Validate user inputs
        try {
            n = 0;
            for (String k : argKeys) { // isInteger ? // isWithinRange?
                Integer.parseInt(userInputs.get(k).toString());
                if (!(DoubleValidateInput(Double.parseDouble(userInputs.get(k).toString()), ranges[n++]))) {
                    return;
                }// if
            }
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch

        /*
            За всеки турнир се прочита отделен ред:
            •	Достигнат етап от турнира – текст – "W", "F" или "SF"
        */

        Object inp;
        Boolean toReturn = false;
        // Integer finalPoints = Integer.parseInt(userInputs.get("initialScore").toString());
        Double finalPoints = Double.parseDouble(userInputs.get("initialScore").toString());
        Integer countW = 0;
        for (int i = 0; i < Integer.parseInt(userInputs.get("tournirsAmount").toString()); i++) {
            System.out.printf("Input [W / F / SF]: ", i);
            inp = scn.nextLine();
            if (!(Arrays.asList("W", "F", "SF").contains(inp.toString()))) { toReturn = true; }
            if (inp.toString().equals("W")) { countW++; }; // { countW += 1; } ;

            // finalPoints += scoreWFSF.getOrDefault(inp.toString(), 0);
            finalPoints += scoreWFSF.getOrDefault(inp.toString(), 0.0);

        }// for

        if (toReturn) { return; };

        Double averagePointsPerMatch = ((finalPoints - Double.parseDouble(userInputs.get("initialScore").toString())) /
                Double.parseDouble(userInputs.get("tournirsAmount").toString()));

//        System.out.printf("\nfinalPoints: %s |  averagePointsPerMatch: %s | W count: %d | %s",
//                finalPoints, String.format("%.0f", averagePointsPerMatch), countW,
//                String.format("%.2f%%", (100.0 * (countW / Double.parseDouble(userInputs.get("tournirsAmount").toString()))))
//        );

        /*
            Изход
            Отпечатват се три реда в следния формат:
            •	"Final points: {брой точки след изиграните турнири}"
            •	"Average points: {средно колко точки печели за турнир}"
            •	"{процент спечелени турнири}%"
            Средните точки да бъдат закръглени към най-близкото цяло число надолу, а процентът да се форматира до втората цифра след десетичния знак.
         */
        System.out.printf("Final points: %s" + // Final points: {брой точки след изиграните турнири}
                        "\nAverage points: %s" + // Average points: {средно колко точки печели за турнир}
                        "\n%s", // {процент спечелени турнири}%
                String.format("%.0f", finalPoints), String.format("%.0f", (Math.floor(averagePointsPerMatch))), // Math.floor to round down
                String.format("%.2f%%", (100.0 * (countW / Double.parseDouble(userInputs.get("tournirsAmount").toString()))))
        );

    }// main
}// class


