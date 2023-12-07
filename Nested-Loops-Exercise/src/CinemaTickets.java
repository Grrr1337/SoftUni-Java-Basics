import java.util.*;

public class CinemaTickets {
    /*
        6.	Билети за кино
        Вашата задача е да напишете програма, която да изчислява процента
        на билетите за всеки тип от продадените билети:
        студентски(student), стандартен(standard) и детски(kid), за всички прожекции.
        Трябва да изчислите и колко процента от залата е запълнена за всяка една прожекция.
        Вход
        Входът е поредица от цели числа и текст:
        •	На първия ред до получаване на командата "Finish" - име на филма – текст
        •	На втори ред – свободните места в салона за всяка прожекция – цяло число [1 … 100]
        •	За всеки филм, се чете по един ред до изчерпване на свободните места в залата или до получаване на командата "End":
        o	Типа на закупения билет - текст ("student", "standard", "kid")
        Изход
        На конзолата трябва да се печатат следните редове:
        •	След всеки филм да се отпечата, колко процента от кино залата е пълна
        "{името на филма} - {процент запълненост на залата}% full."
        •	При получаване на командата "Finish" да се отпечатат четири реда:
        o	"Total tickets: {общият брой закупени билети за всички филми}"
        o	"{процент на студентските билети}% student tickets."
        o	"{процент на стандартните билети}% standard tickets."
        o	"{процент на детските билети}% kids tickets."
     */

    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        // https://www.geeksforgeeks.org/how-to-create-a-treemap-in-reverse-order-in-java/
        TreeMap<String, Double[]> moviesOccupancy = new TreeMap<>(Collections.reverseOrder()) {};
        TreeMap<String, Double> ticketTypes = new TreeMap<>(Collections.reverseOrder()) {{
            put("student", 0.0);
            put("standard", 0.0);
            put("kid", 0.0);
        }};

        /* Вход
            Входът е поредица от цели числа и текст:
            •	На първия ред до получаване на командата "Finish" - име на филма – текст
            •	На втори ред – свободните места в салона за всяка прожекция – цяло число [1 … 100]
            •	За всеки филм, се чете по един ред до изчерпване на свободните места в залата или до получаване на командата "End":
            o	Типа на закупения билет - текст ("student", "standard", "kid")
        */
        Scanner scn = new Scanner(System.in);
        Object inp1, inp2, inp3;
        Integer n;

        ArrayList<String> mkeysL = new ArrayList<>();
        while(true) {
            System.out.println("Input the movie name: ");
            inp1 = scn.nextLine(); // име на филма – текст
            if(inp1.equals("Finish")) { break; }

            System.out.println("Input the free seats amount [1-100]: ");
            inp2 = scn.nextLine(); // свободните места в салона за всяка прожекция – цяло число [1 … 100]
            try {
                n = Integer.parseInt(inp2.toString());
                if (!(IntegerValidateInput(n, new Integer[]{1, 100}))) { return; }
            }
            catch (Exception e) { return; }

            mkeysL.add(inp1.toString());
            moviesOccupancy.put(inp1.toString(), new Double[] {0.0, Double.parseDouble(n.toString())});

            for (int i = n; i > 0 ; i--) {
                System.out.println("Input the ticket type [student/standard/kid]: ");
                inp3 = scn.nextLine();
                // За всеки филм, се чете по един ред до изчерпване
                // на свободните места в залата или до получаване на командата "End"
                if(inp3.equals("End")) { break; }
                else if(inp3.equals("Finish")) { return; }
                else if(Arrays.asList("student", "standard", "kid").contains(inp3)){
                    ticketTypes.put(inp3.toString(), ticketTypes.get(inp3.toString()) + 1.0);
                    Double[] cval = moviesOccupancy.get(inp1.toString());
                    moviesOccupancy.put(inp1.toString(), new Double[]{cval[0]+1 , cval[1]});
                }// if

            }// for

        }// while

        // returns for testing purposes:
//        moviesOccupancy.forEach( (key, value) -> {
//            System.out.printf("m: %s - %s.\n", key, Arrays.toString(value));
//        });
//        ticketTypes.forEach( (key, value) -> {
//            System.out.printf("t: %s - %s.\n", key, String.format("%.2f", value));
//        });


        // the actual/expected returns:
        mkeysL.forEach((k)-> {
            Double[] tmp = moviesOccupancy.get(k);
            System.out.printf("%s - %s%% full.\n", k,
                    String.format("%.2f", (100.0 * (tmp[0] / tmp[1]))));
        });

        Double sum = 0.0;
        // https://stackoverflow.com/questions/21665538/how-to-sum-values-from-java-hashmap
        for (Double val : ticketTypes.values()){ sum += val; }
        System.out.printf("Total tickets: %.0f\n", sum);

        Double finalSum = sum;
        new ArrayList<>(Arrays.asList("student", "standard", "kid")).forEach((k)-> {
            String nk = ((Objects.equals(k, "kid")) ? "kids" : k);
            System.out.printf("%s%% %s tickets.\n",
                    String.format("%.2f", (100 * (Double.parseDouble(ticketTypes.get(k).toString()) / finalSum))), nk);
        });

//        moviesOccupancy.forEach((k)-> {
//            System.out.printf("%s - %s.\n", k,
//                    String.format("%.2f", (Double.parseDouble(moviesOccupancy.get(k).toString()) / finalN)));
//        });


    }// main
}// class

