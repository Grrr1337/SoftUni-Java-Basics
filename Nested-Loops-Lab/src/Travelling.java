import java.util.Scanner;

public class Travelling {
    /*
        5.	Пътуване
        Ани обича да пътува и иска тази година да посети няколко различни дестинации.
        Като си избере дестинация, ще прецени колко пари ще й трябват,
        за да отиде до там и ще започне да спестява. Когато е спестила достатъчно, ще може да пътува.
        От конзолата всеки път ще се четат първо дестинацията и минималния бюджет, който ще е нужен за пътуването, реално число.
        След това ще се четат няколко суми, реални числа,
        които Ани спестява като работи и когато успее да събере достатъчно за пътуването,
        ще заминава, като на конзолата трябва да се изпише:
        "Going to {дестинацията}!"
        Когато е посетила всички дестинации, които иска, вместо дестинация ще въведе "End" и програмата ще приключи.

    */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        while (true) {
            Object inp1 = scn.nextLine(); // destination
            if (inp1.equals("End"))  { return; }
            Object inp2 = scn.nextLine(); // amount for excursion
            if (inp2.equals("End"))  { return; }

            try { Double.parseDouble(inp2.toString()); } catch (Exception e) { return; }

            // След това ще се четат няколко суми, реални числа,
            // които Ани спестява като работи и когато успее да събере достатъчно за пътуването,
            // ще заминава, като на конзолата трябва да се изпише:
            Double sum = 0.0;
            while(true){
                Object inp3 = scn.nextLine();
                try { Double.parseDouble(inp3.toString()); } catch (Exception e) { return; }
                sum += Double.parseDouble(inp3.toString());
                if (sum >= Double.parseDouble(inp2.toString())) {
                    // "Going to {дестинацията}!".isEmpty();
                    System.out.printf("Going to %s!\n", inp1.toString());
                    break;
                }// if
            }// while
        }// while

    }// main
}// class
