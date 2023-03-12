

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class FruitOrVegetable {
    /*
        9.	Плод или зеленчук
        Да се напише програма, която чете име на продукт, въведено от потребителя и проверява дали е плод или зеленчук.
        •	Плодовете "fruit" са banana, apple, kiwi, cherry, lemon и grapes
        •	Зеленчуците "vegetable" са tomato, cucumber, pepper и carrot
        •	Всички останали са "unknown"
        Да се изведе "fruit", "vegetable" или "unknown" според въведения продукт.

     */
    //  NOTE: Just like in the: AnimalType.java
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String ui = (String)scn.next();

        for (String[] cls : new String[][]{
                {"fruit", "banana", "apple", "kiwi", "cherry", "lemon", "grapes"}, // 1st item is the class name
                {"vegetable", "tomato", "cucumber", "pepper", "carrot"}
        })
        {
            if (Arrays.stream(cls).anyMatch(ui::equals)) {
                System.out.println(cls[0]);
                return;
            }
        }// for
        System.out.println("unknown");


    }// main
}
