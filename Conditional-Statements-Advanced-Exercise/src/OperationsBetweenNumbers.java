import java.util.*;

public class OperationsBetweenNumbers {
    /*
        6.	Операции между числа
        Напишете програма, която чете две цели числа (N1 и N2) и оператор,
        с който да се извърши дадена математическа операция с тях.
        Възможните операции са: Събиране (+), Изваждане (-), Умножение (*), Деление (/) и Деление с остатък (%).
        При събиране, изваждане и умножение на конзолата трябва да се отпечата резултатът и дали той е четен или нечетен.
        При обикновеното деление – резултатът.
        При модулното деление – остатъка.
        Трябва да се има предвид, че делителят може да е равен на 0(нула), а на нула не се дели.
        В този случай трябва да се отпечата специално съобщениe.

        Вход
        От конзолата се прочитат 3 реда, въведени от потребителя:
        •	N1 – цяло число в интервала [0...40 000]
        •	N2 – цяло число в интервала [0...40 000]
        •	Оператор – един символ измеду: "+", "-", "*", "/", "%"

        Изход
        Да се отпечата на конзолата един ред:
        •	Ако операцията е събиране, изваждане или умножение:
        o	 "{N1} {оператор} {N2} = {резултат} – {even/odd}"
        •	Ако операцията е деление:
        o	"{N1} / {N2} = {резултат}" – резултатът е форматиран до вторият знак след дес.запетая
        •	Ако операцията е деление с остатък:
        o	"{N1} % {N2} = {остатък}"
        •	В случай на деление с 0 (нула):
        o	"Cannot divide {N1} by zero"

    */

    private static String trimTrailingZeros(String number) {
        if(!number.contains(".")) {
            return number;
        }

        return number.replaceAll("\\.?0*$", "");
    } // trimTrailingZeros
    private static boolean IntegerValidateInput(Integer val, Integer[] range){
        return (range[0] <= val && val <= range[1]);
    }

    @FunctionalInterface
    public interface cInterface {
        // NOTE: only 1 (one) abstract method is allowed within the @FunctionalInterface , hence I cannot define .printOperationResult()
        public Object getOperationResult(String operator, Double num1, Double num2, Double toReturn);

        /*
       Да се отпечата на конзолата един ред:
       •	Ако операцията е събиране, изваждане или умножение:
       o	 "{N1} {оператор} {N2} = {резултат} – {even/odd}"
       •	Ако операцията е деление:
       o	"{N1} / {N2} = {резултат}" – резултатът е форматиран до вторият знак след дес.запетая
       •	Ако операцията е деление с остатък:
       o	"{N1} % {N2} = {остатък}"
       •	В случай на деление с 0 (нула):
       o	"Cannot divide {N1} by zero"
    */
        // public void printOperationResult(String Operator, Double Num1, Double Num2, Double Result);

    }// public

    @FunctionalInterface
    public interface pInterface {
        public void printOperationResult(String stringFormattingResult, String Operator, String Num1, String Num2, String Result);
    }

    public static void main(String[] args) {

        /*
            Вход
            От конзолата се прочитат 3 реда, въведени от потребителя:
            •	N1 – цяло число в интервала [0...40 000]
            •	N2 – цяло число в интервала [0...40 000]
            •	Оператор – един символ измеду: "+", "-", "*", "/", "%"
         */
        // Get User Inputs
        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"num1", "num2", "operator"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        Integer num1=0, num2=0;

        // Validation Block for User Inputs
        if (!(Arrays.asList("+", "-", "*", "/", "%").contains(userInputs.get("operator")))) { return; }
        try {
            num1 = Integer.parseInt(userInputs.get("num1").toString());
            num2 = Integer.parseInt(userInputs.get("num2").toString());
            if ( (!(IntegerValidateInput(num1, new Integer[]{0, 40000}))) ||
                    (!(IntegerValidateInput(num2, new Integer[]{0, 40000}))) ){
                return;
            }
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch

        Double dbl1 = Double.parseDouble(num1.toString());
        Double dbl2 = Double.parseDouble(num2.toString());

        // TODO: study how interfaces work
        // https://www.youtube.com/watch?v=tj5sLSFjVj4&t=652s
        // https://www.youtube.com/watch?v=LEJ1kGHSXdA
        // MyInterface myInterface = () -> System.out.println("Heello World!!!");
        // myInterface.message();
        cInterface getOperation = (o, n1, n2, r) -> {
            if (o.equals(userInputs.get("operator"))) {
                return r;
            }
            return null;
        }; // cInterface

        Object operationResult = new ArrayList<Object>(
                Arrays.asList(
                        getOperation.getOperationResult("+", dbl1, dbl2, (dbl1 + dbl2)),
                        getOperation.getOperationResult("-", dbl1, dbl2, (dbl1 - dbl2)),
                        getOperation.getOperationResult("*", dbl1, dbl2, (dbl1 * dbl2)),
                        getOperation.getOperationResult("/", dbl1, dbl2, (dbl1 / dbl2)),
                        getOperation.getOperationResult("%", dbl1, dbl2, (dbl1 % dbl2))
                )).stream().filter(Objects::nonNull).findFirst().orElse(0.00); // Object operationResult

        // getOperation.printOperationResult()

        Double rslt = Double.parseDouble(operationResult.toString());


        pInterface printOperation = (sft, n1, o, n2, r) -> { // String Operator, Double Num1, Double Num2, Double Result
            System.out.printf(sft, n1, o, n2, r);
        }; // pInterface

         /*
            Да се отпечата на конзолата един ред:
            •	Ако операцията е събиране, изваждане или умножение:
            o	 "{N1} {оператор} {N2} = {резултат} – {even/odd}"
            •	Ако операцията е деление:
            o	"{N1} / {N2} = {резултат}" – резултатът е форматиран до вторият знак след дес.запетая
            •	Ако операцията е деление с остатък:
            o	"{N1} % {N2} = {остатък}"
            •	В случай на деление с 0 (нула):
            o	"Cannot divide {N1} by zero"
         */

        for (String o: new String[]{"+", "-", "*"}) {
            if (o.equals(userInputs.get("operator"))) {
                printOperation.printOperationResult(
                        "%s %s %s = %s – " + (((rslt % 2) == 0) ? "even" : "odd") , // "{N1} {оператор} {N2} = {резултат} – {even/odd}",
                        trimTrailingZeros(dbl1.toString()), o, trimTrailingZeros(dbl2.toString()), trimTrailingZeros(rslt.toString())
                );
                return;
            }// if
        }// for


        for (String o: new String[]{"/", "%"}) {
            if (o.equals(userInputs.get("operator"))) {
                try { Object x = (num1 / num2); }
                catch(ArithmeticException e) {
                    // System.out.printf("Cannot divide %s by zero", trimTrailingZeros(dbl1.toString()));
                    printOperation.printOperationResult( // В случай на деление с 0 (нула): "Cannot divide {N1} by zero"
                            "Cannot divide %s by zero%s%s%s",
                            trimTrailingZeros(dbl1.toString()), "", "", "");
                    return;
                }// catch

                // System.out.printf("\n* %s *", rslt.getClass());

                printOperation.printOperationResult(
                        "%s %s %s = %s", // "{N1} / {N2} = {резултат}" – резултатът е форматиран до вторият знак след дес.запетая
                        trimTrailingZeros(dbl1.toString()), o, trimTrailingZeros(dbl2.toString()), trimTrailingZeros(String.format("%.2f", rslt))
                );
                return;

            }// if
        }// for
    }// main

}// OperationsBetweenNumbers

