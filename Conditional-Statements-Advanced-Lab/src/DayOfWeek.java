



import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class DayOfWeek {

    /*
    Напишете програма, която чете цяло число, въведено от потребителя, и отпечатва ден от седмицата (на английски език),
     в граници [1...7] или отпечатва "Error" в случай, че въведеното число е невалидно.
     */
    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {


        HashMap<Integer, String> weekDays = new HashMap<Integer, String>();
        int n = 1; // 1-based requirement
        for(String e : new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}) {
            // System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n]));
            weekDays.put(n++, e);
        }// for

        Scanner scn = new Scanner(System.in);
        Object ui = scn.next();
        Integer uin = (Integer.parseInt((String)ui));

        if ((uin == -1) || (!(IntValidateInput(uin, new Integer[]{1, 7})))){
            System.out.println("Error");
            return;
        }
        Object v = weekDays.get(Integer.parseInt((String)ui));


        System.out.printf("%s", ((v != null) ? v : "Error"));


    }
}
