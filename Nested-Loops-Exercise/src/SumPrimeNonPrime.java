import java.util.Scanner;

public class SumPrimeNonPrime {
    /*
        3.	Суми прости и непрости числа
        Напишете програма, която чете от конзолата цели числа в диапазона, докато не се получи команда "stop".
        Да се намери сумата на всички въведени прости и сумата на всички въведени непрости числа.
        Тъй като по дефиниция от математиката отрицателните числа не могат да бъдат прости,
        ако на входа се подаде отрицателно число да се изведе следното съобщение "Number is negative.".
        В този случай въведено число се игнорира и не се прибавя
        към нито една от двете суми, а програмата продължава своето изпълнение,
        очаквайки въвеждане на следващо число.
        На изхода да се отпечатат на два реда двете намерени суми в следния формат:
        •	"Sum of all prime numbers is: {prime numbers sum}"
        •	"Sum of all non prime numbers is: {nonprime numbers sum}"

    */
    // I was lazy here:
    // https://www.edureka.co/blog/prime-number-program-in-java/
    public static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
        if(inputNumber <= 1)
        {
            isItPrime = false;
            return isItPrime;
        }
        else
        {
            for (int i = 2; i <= inputNumber/2; i++)
            {
                if ((inputNumber % i) == 0)
                { isItPrime = false; break; }
            }
            return isItPrime;
        }
    }// public


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // System.out.println(checkForPrime(n));
        int[] res = new int[]{0, 0};
        while (true) {
            Object inp = scn.nextLine();
            if (inp.equals("stop")) { break; }

            try {
                int n = Integer.parseInt(inp.toString());
                /*
                    В този случай въведено число се игнорира и
                    не се прибавя към нито една от двете суми,
                    а програмата продължава своето изпълнение,
                    очаквайки въвеждане на следващо число.
                 */
                if (n < 0) {
                    System.out.println("Number is negative.");
                    continue;
                }

                res[(checkForPrime(n) ? 0 : 1)] += n;
            }
            catch (Exception ex) { return; }
        }// while

        System.out.printf("Sum of all prime numbers is: %s" +
               "\nSum of all non prime numbers is: %s",
                res[0], res[1]
        );

    }// main
}// class

