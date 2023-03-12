import java.util.HashMap;
import java.util.Scanner;

public class WorkingHours {
    /*
        7.	Работно време
        Да се напише програма, която чете час от денонощието(цяло число) и ден от седмицата(текст) -
        въведени от потребителя и проверява дали офисът на фирма е отворен,
        като работното време на офисът е от 10-18 часа, от понеделник до събота включително

    */
    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        HashMap<String, Integer> weekDaysIdx = new HashMap<String, Integer>();
        int n = 1; // 1-based requirement
        for(String e : new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}) {
            // System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n]));
            weekDaysIdx.put(e, n++);
        }// for


        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"visitHour", "weekDay"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.next());
        }// for

        Integer h = (Integer.parseInt((String)userInputs.get("visitHour")));
        Object v = weekDaysIdx.get(userInputs.get("weekDay"));
        if (v == null) return;

        Integer d = (Integer.valueOf(v.toString())); // day

        if (!(IntValidateInput(h, new Integer[]{0, 24}))) {
            throw new RuntimeException("The provided working hour \"" + Integer.toString(h) + "\" is not in (0 - 24) range! " );

        }
        boolean isWorkingHour = IntValidateInput(h, new Integer[]{10, 18});
        boolean isWorkingDay = IntValidateInput(d, new Integer[]{1, 6});

        System.out.printf("%s", ((isWorkingDay && isWorkingHour) ? "open" : "closed"));
    }// main
}
