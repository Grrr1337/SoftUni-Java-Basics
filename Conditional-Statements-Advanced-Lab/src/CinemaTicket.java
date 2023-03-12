
import java.util.Scanner;
import java.util.HashMap;

public class CinemaTicket {
    /*
        Да се напише програма която чете ден от седмицата (текст) –
        въведен от потребителя и принтира на конзолата цената на билет за кино според деня от седмицата:
        Monday	Tuesday	Wednesday	Thursday	Friday	Saturday	Sunday
        12	    12	    14      	14	        12	    16	        16
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String ui = (String)scn.next();

        HashMap<String, Object> tickets = new HashMap<String, Object>();
        for (Object[] itm : new Object[][] {
                {"Monday", 12}, {"Tuesday", 12}, {"Wednesday", 14}, {"Thursday", 14},
                {"Friday", 12}, {"Saturday", 16}, {"Sunday", 16}
            })
        {
            // System.out.printf("\n%s, %s", fields[0], fields[1]);
            Object[] fields = (Object[])itm;
            if (ui.equals(fields[0])) {
                System.out.printf("%s", fields[1]);
            }
            // tickets.put(k, scn.next());
        }// for
    }// main
}
