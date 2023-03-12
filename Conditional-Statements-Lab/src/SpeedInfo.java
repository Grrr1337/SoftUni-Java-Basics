
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;


public class SpeedInfo {
    /*
        Да се напише програма, която чете скорост (реално число), въведена от потребителя и отпечатва информация за скоростта.
        •	При скорост до 10 (включително) отпечатайте "slow"
        •	При скорост над 10 и до 50 (включително) отпечатайте "average"
        •	При скорост над 50 и до 150 (включително) отпечатайте "fast"
        •	При скорост над 150 и до 1000 (включително) отпечатайте "ultra fast"
        •	При по-висока скорост отпечатайте "extremely fast"
     */

    public static void main(String[] args) {
        double inf = Double.POSITIVE_INFINITY;
        HashMap<String, Double[]> sL = new HashMap<String, Double[]>();
        sL.put("slow", new Double[] {(-1 * inf), 10.0});
        sL.put("average", new Double[] {10.0, 50.0});
        sL.put("fast", new Double[] {50.0, 150.0});
        sL.put("ultra fast", new Double[] {150.0, 1000.0});
        sL.put("extremely fast", new Double[] {1000.0, inf});

        Scanner scn = new Scanner(System.in);
        // Integer inp = Integer.parseInt(scn.nextLine());
        Object inp = scn.nextLine();

        for (String k : new String[] {"slow", "average", "fast", "ultra fast", "extremely fast" }){
            Double[] range = (Double[])sL.get(k);
            if ( (range[0] <= Double.parseDouble(inp.toString())) && (Double.parseDouble(inp.toString()) <= range[1]) )
            {
                System.out.printf("%s", k);
                return;
            }

        } // for
    } // main

    public static void mainCCC(String[] args) {
        double inf = Double.POSITIVE_INFINITY;
        HashMap<String, Double[]> sL = new HashMap<String, Double[]>();
        sL.put("slow", new Double[] {(-1 * inf), 10.0});
        sL.put("average", new Double[] {10.0, 50.0});
        sL.put("fast", new Double[] {50.0, 150.0});
        sL.put("ultra fast", new Double[] {150.0, 1000.0});
        sL.put("extremely fast", new Double[] {1000.0, inf});

        Scanner scn = new Scanner(System.in);
        Integer inp = Integer.parseInt(scn.nextLine());

        for (String k : new String[] {"slow", "average", "fast", "ultra fast", "extremely fast" }){

            Double[] fields = (Double[])sL.get(k);
            if ( (fields[0] <= Double.valueOf(inp)) && (Double.valueOf(inp) <= fields[1]) ){
                System.out.printf("%s", k);
                return;
            }

        } // for

    } // main
}
