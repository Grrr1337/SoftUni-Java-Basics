


// import java.util.*;
import java.lang.Math;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class SmallShop {

    /*
        Напишете програма, която чете продукт (низ), град (низ) и количество (десетично число),
        въведени от потребителя и пресмята и отпечатва колко струва съответното количество от избрания продукт в посочения град

    */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();

        String[] argKeys = new String[]{"Article", "Town", "Amount"};
        int n = 0;
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k);
            userInputs.put(k, scn.next());
            n++;
        }// for

        Object article = userInputs.get("Article");
        Object town = userInputs.get("Town");
        Object amount = userInputs.get("Amount");


        Object[][] dataTable = new Object[][] {
            {"град / продукт", "coffee", "water", "beer", "sweets", "peanuts"},
            {"Sofia",	        0.50,	    0.80,	1.20,	1.45,	1.60, },
            {"Plovdiv",	        0.40,	    0.70,	1.15,	1.30,	1.50, },
            {"Varna",	        0.45,	    0.70,	1.10,	1.35,	1.55 }
        };

        int r=0, c=1, _r = -1, _c = -1;
        for (Object[] row : dataTable)
        {
            c=0;
            for(Object itm : row) {
                if (article.equals(itm)) { _c = c; }
                if (town.equals(itm)) { _r = r; }
                if ((_r != -1) && (_c != -1)) break;
                // System.out.printf( ((c == 0) ? "\n" : "") + "[(%d, : %d) %s]" + ((r == 0) ? "\t" : "\t\t"), r, c, itm.toString());
                c++;
            }// for
            if ((_r != -1) && (_c != -1)) break;
            r++;
        }// for

        System.out.printf("%.2f", (Double.parseDouble(dataTable[_r][_c].toString()) * Double.parseDouble(amount.toString())));

    }// main
}
