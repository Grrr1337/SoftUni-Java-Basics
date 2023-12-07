

public class Clock {
    /*
        1.	Часовник
        Напишете програма, която отпечатва часовете в денонощието от 0:0 до 23:59,
        всеки на отделен ред. Часовете трябва да се изписват във формат "{час}:{минути}".
    */
    public static Double parseToDouble(Object idx) {
        return Double.parseDouble(idx.toString());
    }
    public static void main(String[] args) {

        Integer[] fmt = new Integer[]{24, 60};

        for (int i = 0; i < fmt[0] ; i++) {
            for (int j =0; j < fmt[1]; j++) {

                System.out.printf("%.0f:%.0f\n", parseToDouble(i), parseToDouble(j));
            }// for
        }// for

    }// main
}// class
