import java.util.Scanner;

public class Building {
    /*
        6.	Сграда
        Напишете програма, която извежда на конзолата номерата на стаите в една сграда (в низходящ ред),
        като са изпълнени следните условия:
        •	На всеки четен етаж има само офиси
        •	На всеки нечетен етаж има само апартаменти
        •	Всеки апартамент се означава по следния начин :
        А{номер на етажа}{номер на апартамента}, номерата на апартаментите започват от 0.
        •	Всеки офис се означава по следния начин :
        О{номер на етажа}{номер на офиса}, номерата на офисите също започват от 0.
        •	На последният етаж винаги има апартаменти и те са по-големи от останалите,
        за това пред номера им пише 'L', вместо 'А'. Ако има само един етаж, то има само големи апартаменти!
        От конзолата се прочитат две цели числа - броят на етажите и броят на стаите за един етаж.

    */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Object inp1 = scn.nextLine(); // amount of floors
        Object inp2 = scn.nextLine(); // rooms per floor

        try { Integer.parseInt(inp1.toString());
            Integer.parseInt(inp2.toString());
        } catch (Exception e) { return; }

        Integer i1 = Integer.parseInt(inp1.toString());
        Integer i2 =  Integer.parseInt(inp2.toString());

        // Имаме общо 6 етажа, с по 4 стаи на етаж. Нечетните етажи имат само апартаменти, а четните само офиси.

        for (int i = i1; i > 0; i--) {
            for (int j = 0; j < i2; j++) {
                if (i == i1) {
                    System.out.printf("L%s%s ", i, j);
                }
                else {
                    System.out.printf("%s%s%s ", (((i % 2) == 0) ? "O" : "A"), i, j);
                }
                // •	На последният етаж винаги има апартаменти и те са по-големи от останалите, за това пред номера им пише 'L', вместо 'А'.

            }// for
            System.out.print("\n");
        }// for



    }// main
}// class

/*
    for (int i = 0; i < i1; i++) {
            for (int j = 0; j < i2; j++) {
                System.out.printf("%s%s%s ",  ((( i % 2) == 0) ? "O" : "A"), i , j);
            }// for
            System.out.print("\n");
        }// for
 */