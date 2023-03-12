


import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;

public class GodzillavsKong {
    /*
        •	Декорът за филма е на стойност 10% от бюджета.
        •	При повече от 150 статиста,  има отстъпка за облеклото на стойност 10%.

        Вход
        От конзолата се четат 3 реда:
        Ред 1.	Бюджет за филма – реално число в интервала [1.00 … 1000000.00]
        Ред 2.	Брой на статистите – цяло число в интервала [1 … 500]
        Ред 3.	Цена за облекло на един статист – реално число в интервала [1.00 … 1000.00]

        Изход
        На конзолата трябва да се отпечатат два реда:
        •	Ако  парите за декора и дрехите са повече от бюджета:
        o	"Not enough money!"
        o	"Wingard needs {парите недостигащи за филма} leva more."
        •	Ако парите за декора и дрехите са по малко или равни на бюджета:
        o	"Action!"
        o	"Wingard starts filming with {останалите пари} leva left."
        Резултатът трябва да е форматиран до втория знак след десетичната запетая.

    */
    private static boolean DoubleValidateInput(double val, double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    private static boolean IntValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    public static void main(String[] args) {

        Double decorCost = 0.1;
        Double discClothing = 1.0;

        userInput ui;
        Scanner scn = new Scanner(System.in);
        int n = 0;
        boolean ToThrowError = false;
        double ranges[][] = { {1.00, 1000000.00}, {1.00, 500.00}, {1.00, 1000.00} };

        /// Get User Inputs
        List<userInput> userInputs = new ArrayList<>();
        for(String k : new String[]{"BudgetMovie", "cStatist", "cPrice"}) {
            System.out.printf("\nInput \"%s\" : ", k);
            ui = new userInput(k, scn.next());
            // System.out.printf("\n%s", ui.Value.getClass());

            if (!(ui.ValidateRange(ui.Value, ranges[n++]))) {
                ToThrowError = true;
            }
            else {

                switch(k) {
                    case "BudgetMovie": {
                        decorCost *= Double.parseDouble((String) ui.Value); // Декорът за филма е на стойност 10% от бюджета.
                        System.out.printf("Decor cost: %.2f leva", decorCost);
                        break;
                    }

                    case "cStatist": {
                        if (Integer.parseInt((String) ui.Value) > 150) { // При повече от 150 статиста,  има отстъпка за облеклото на стойност 10%
                            discClothing = 0.9;
                            ui.Value = (Integer.parseInt((String) ui.Value) * discClothing);

                        }
                        break;
                    }
                    default:
                        break;
                        // code block
                }
                userInputs.add(ui);
            }
        }// for

        if (ToThrowError) { throw new RuntimeException("Invalid input!"); }

        userInputs.forEach((x) -> {
            System.out.printf("\n%s | %s", x.Value, x.Value.getClass());
        });

        // Quickly batched, not proud of this:
        Object inp1 = userInputs.get(1).Value;
        Object inp2 = userInputs.get(2).Value;
        Double a1, a2;

        if(!(inp1 instanceof Double)) {
            a1 = Double.parseDouble((String)inp1);
        }
        else { a1 = (Double)inp1; }
        if(!(inp2 instanceof Double)) {
            a2 = Double.parseDouble((String)inp2);
        }
        else { a2 = (Double)inp2; }

        Double oblekloPrice = ( a1 * a2);

        // System.out.printf("oblekloPrice: %.2f", oblekloPrice);

        Double diff = Double.parseDouble((String)userInputs.get(0).Value) - (oblekloPrice + decorCost);

        if (diff < 0)
        { // Ако  парите за декора и дрехите са повече от бюджета:
            System.out.printf("Not enough money!\n" +
                    "Wingard needs %.2f leva more.", Math.abs(diff));

        }
        else {
            System.out.printf("Action!\n" +
                    "Wingard starts filming with %.2f leva left.", diff);
        }
    }// main

} // class



class fixedInput {
    public Object Value;
    public String Description;

    // Constructor
    fixedInput(String Description, Object Value) {
        this.Description = Description;
        this.Value = Value;
    }
}

class userInput {
    public Object Value;
    public String Key;

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public boolean ValidateRange(Object val, double[] range){
        if ((val instanceof Number) || isNumeric((String)val)) {
            Double nval = Double.parseDouble((String)val);
            return (range[0] <= nval && nval <= range[1]);
        }
        else {
            throw new RuntimeException("\nUserInput:The value is not a Number type!");
        }
    }

    // https://stackoverflow.com/questions/965690/how-do-i-use-optional-parameters-in-java
    // Constructor overload
    userInput(String Key) {
        this.Key = Key;
    }

    // Constructor
    userInput(String Key, Object Value) {
        this.Key = Key;
        this.Value = Value;
    }
}
