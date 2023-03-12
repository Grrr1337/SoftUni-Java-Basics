import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Journey {
    /*
        5.	Пътешествие
        Странно, но повечето хора си плануват от рано почивката. Млад програмист разполага с определен бюджет и свободно време в даден сезон. Напишете програма, която да приема на входа бюджета и сезона, а на изхода да изкарва, къде ще почива програмиста и колко ще похарчи.
        Бюджета определя дестинацията, а сезона определя колко от бюджета ще изхарчи. Ако е лято ще почива на къмпинг, а зимата в хотел. Ако е в Европа, независимо от сезона ще почива в хотел. Всеки къмпинг или хотел, според дестинацията, има собствена цена която отговаря на даден процент от бюджета:
        •	При 100лв. или по-малко – някъде в България
        o	Лято – 30% от бюджета
        o	Зима – 70% от бюджета
        •	При 1000лв. или по малко – някъде на Балканите
        o	Лято – 40% от бюджета
        o	Зима – 80% от бюджета
        •	При повече от 1000лв. – някъде из Европа
        o	При пътуване из Европа, независимо от сезона ще похарчи 90% от бюджета.

        Вход
        Входът се чете от конзолата и се състои от два реда, въведени от потребителя:
        •	Първи ред – Бюджет, реално число в интервала [10.00...5000.00].
        •	Втори ред –  Един от двата възможни сезона: "summer" или "winter"
        Изход
        На конзолата трябва да се отпечатат два реда.
        •	Първи ред – "Somewhere in {дестинация}" измежду "Bulgaria", "Balkans" и "Europe"
        •	Втори ред – "{Вид почивка} – {Похарчена сума}"
        o	Почивката може да е между "Camp" и "Hotel"
        o	Сумата трябва да е закръглена с точност до вторият знак след десетичната запетая

     */

    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        HashMap<String, Double[]> budgetRatio = new HashMap<String, Double[]>() {{
            put("summer", new Double[]{0.3, 0.4});
            put("winter", new Double[]{0.7, 0.8});
        }};

        /*
             Вход
            Входът се чете от конзолата и се състои от два реда, въведени от потребителя:
            •	Първи ред – Бюджет, реално число в интервала [10.00...5000.00].
            •	Втори ред –  Един от двата възможни сезона: "summer" или "winter"
         */

        // Get User Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"budget", "season"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        Double budget = 0.0;
        // Validation Block for User Inputs
        if (!(Arrays.asList("summer", "winter").contains(userInputs.get("season")))) { return; }
        try {
            budget = Double.parseDouble(userInputs.get("budget").toString());
            if (!(DoubleValidateInput(budget, new Double[]{10.0, 5000.00}))) {
                return;
            }
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch


        // TODO: substitute this code block with interfaces
        String destination ="";
        Double bratio = 1.0;
        String dtype = "";

        if (budget < 100) {
            destination = "Bulgaria";
            bratio= budgetRatio.get(userInputs.get("season"))[0];
        }
        else if (budget < 1000 ){
            destination = "Balkans";
            bratio= budgetRatio.get(userInputs.get("season"))[1];
        }
        else if (budget > 1000 ){
            destination = "Europe";
            // budgetRatio.get(userInputs.get("season"));
            bratio = 0.9;
        }
        dtype="Hotel";
        if (Arrays.asList("Bulgaria", "Balkans").contains(destination)) {
            switch (userInputs.get("season").toString()) {
                case "winter": { dtype = "Hotel"; break; }
                case "summer": { dtype = "Camp"; break; }
                default: break;
            }// switch
        }

        /*
            Изход
            На конзолата трябва да се отпечатат два реда.
            •	Първи ред – "Somewhere in {дестинация}" измежду "Bulgaria", "Balkans" и "Europe"
            •	Втори ред – "{Вид почивка} – {Похарчена сума}"
            o	Почивката може да е между "Camp" и "Hotel"
            o	Сумата трябва да е закръглена с точност до вторият знак след десетичната запетая
        */
        System.out.printf("Somewhere in %s" + "\n%s - %.2f", destination, dtype, bratio * budget );

        // System.out.printf("\nSeason: %s | budget: %s", userInputs.get("season"), userInputs.get("budget").toString());

    }// main
}// class


