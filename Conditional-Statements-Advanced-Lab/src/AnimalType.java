


import java.util.*;

import java.lang.Math;

public class AnimalType {
    /*
        3.	Клас животно
        Напишете програма, която отпечатва класа на животното според неговото име, въведено от потребителя.
        •	dog -> mammal
        •	crocodile, tortoise, snake -> reptile
        •	others -> unknown

     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String ui = (String)scn.next();

        int i=0, j=1;

        for (String[] cAnimal : new String[][]{
                {"mammal", "dog", "cat", "mouse", "bear", "hamster"}, // 1st item is the class name
                {"reptile", "crocodile", "tortoise", "snake"}
        })
        {
            j=1;
            for(String animal : cAnimal) {
                // System.out.printf("\n(%d, : %d)", i, j);
                if((Objects.equals(ui, animal)) && (j != 1)) // make sure that the key cannot be matched
                {
                    System.out.println(cAnimal[0]);
                    return;
                }
                j++;
            }// for
            i++;
        }// for
        System.out.println("unknown");

    }// main
}
