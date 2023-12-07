

public class MultiplicationTable {
    /*
        2.	Таблица за умножение
        Отпечатайте на конзолата таблицата за умножение за числата от 1 до 10 във формат:
        "{първи множител} * {втори множител} = {резултат}".
     */
    public static void main(String[] args) {
        Integer idx = 10;
        for (int i = 1; i <= idx; i++) {
            for (int j = 1; j <= idx; j++) {
                System.out.printf("%s * %s = %s\n", i, j, (i * j));
            }
        }
    }// main
}// class
