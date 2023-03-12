
import java.util.Scanner;
import java.util.Arrays;

public class AreaofFigures {
    /*
    Да се напише програма, в която потребителят въвежда вида и размерите на геометрична фигура и пресмята лицето й.
      Фигурите са четири вида: квадрат (square), правоъгълник (rectangle), кръг (circle) и триъгълник (triangle).
       На първия ред на входа се чете вида на фигурата (текст със следните възможности: square, rectangle, circle или triangle).

    •	Ако фигурата е квадрат (square): на следващия ред се чете едно дробно число - дължина на страната му
    •	Ако фигурата е правоъгълник (rectangle): на следващите два реда четат две дробни числа - дължините на страните му
    •	Ако фигурата е кръг (circle): на следващия ред чете едно дробно число - радиусът на кръга
    •	Ако фигурата е триъгълник (triangle): на следващите два реда четат две дробни числа - дължината на страната му и дължината на височината към нея
    Резултатът да се закръгли до 3 цифри след десетичната запетая.

     */
    public static void main(String[] args) {
        String inp;
        Double a, b, r = null;

        Scanner scn = new Scanner(System.in);
        inp = scn.nextLine();

        if (!(Arrays.asList("square", "rectangle", "circle", "triangle").contains(inp))) {
            throw new RuntimeException("Ivalid option provided, got: \"" + inp + "\"");
        }

        switch(inp) {
            case "square": { // Ако фигурата е квадрат (square): на следващия ред се чете едно дробно число - дължина на страната му
                a = Double.valueOf(scn.nextLine());
                r = a * a;
                break;
            }
            case "rectangle": { // Ако фигурата е правоъгълник (rectangle): на следващите два реда четат две дробни числа - дължините на страните му
                a = Double.valueOf(scn.nextLine());
                b = Double.valueOf(scn.nextLine());
                r = a * b;
                break;
            }
            case "circle": { // Ако фигурата е кръг (circle): на следващия ред чете едно дробно число - радиусът на кръга
                a = Double.valueOf(scn.nextLine());
                r = Math.PI * Math.pow(a, 2);
                break;
            }
            case "triangle": { // Ако фигурата е триъгълник (triangle): на следващите два реда четат две дробни числа - дължината на страната му и дължината на височината към нея
                a = Double.valueOf(scn.nextLine());
                b = Double.valueOf(scn.nextLine());
                r = a * b * 0.5;
                break;
            }
            default:
                break;
        }// switch
        if (!(r == null)) { // Резултатът да се закръгли до 3 цифри след десетичната запетая
            System.out.printf("%.3f", r);
        }
    }
}
