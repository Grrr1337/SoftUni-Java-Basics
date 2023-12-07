import java.util.*;
import java.util.stream.Collectors;

public class HalfSumElement {
    /*
        2.	 Елемент, равен на сумата на останалите
        Да се напише програма, която чете n-на брой цели числа, въведени от потребителя,и проверява дали сред тях съществува число, което е равно на сумата на всички останали.
        •	Ако има такъв елемент печата "Yes" и на нов ред "Sum = "  + неговата стойност
        •	Ако няма такъв елемент печата "No" и на нов ред "Diff = " + разликата между най-големия елемент и сумата на останалите (по абсолютна стойност)
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> inpHistory = new ArrayList<>();

        Integer n = Integer.parseInt(scn.nextLine());

        int sum = 0;
        int inp;
        for (int i = 0; i < n; i++ ){

            inp = Integer.parseInt(scn.nextLine());
            // System.out.println(sum);
            inpHistory.add(inp);

        }// for

        Integer maxNum = Collections.max(inpHistory);
        List<Integer> fInpHistory = inpHistory.stream().filter(num -> num != maxNum).collect(Collectors.toList());

        Integer sumRest = fInpHistory.stream().mapToInt(Integer::intValue).sum();
        Integer diff = maxNum - sumRest;

        if (diff == 0) {
            System.out.printf("Yes\n" + "Sum = %s", maxNum);
        }
        else {
            System.out.printf("No\n" + "Diff = %s", Math.abs(diff));
        }

//        System.out.printf("maxNum: %s | sumRest: %s", maxNum, sumRest);
//        System.out.printf("\nArray %s", Arrays.toString(fInpHistory.toArray()));



//        if (!(res.isEmpty())) {
//            for (Integer x : res){
//                System.out.printf("\nYes\nSum = %s", x);
//            }
//        }


    }// main
}// class
