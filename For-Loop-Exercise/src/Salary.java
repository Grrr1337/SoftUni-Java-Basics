


import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class Salary {
    /*
        5.	Заплата
        Шеф на компания забелязва че все повече служители прекарват  време в сайтове, които ги разсейват.
        За да предотврати това, той въвежда изненадващи проверки на отворените табове на браузъра на служителите си.
        Според отворения сайт в таба се налагат следните глоби:
        •	"Facebook" -> 150 лв.
        •	"Instagram" -> 100 лв.
        •	"Reddit" -> 50 лв.
        От конзолата се четат два реда:
        •	Брой отворени табове в браузъра n - цяло число в интервала [1...10]
        •	Заплата - число в интервала [500...1500]
        След това n – на брой пъти се чете име на уебсайт – текст
        Изход
        •	Ако по време на проверката заплатата стане по-малка или равна на 0 лева, на конзолата се изписва
        "You have lost your salary." и програмата приключва.
        •	В противен случай след проверката на конзолата се изписва остатъкът от заплатата (да се изпише като цяло число).
     */
    private static boolean DoubleValidateInput(Double val, Double[] range){
        return (range[0] <= val && val <= range[1]);
    }
    public static void main(String[] args) {

        HashMap<String, Double> sanctions = new DefaultHashMap<String, Double>() {{
            put("Facebook", -150.0);
            put("Instagram", -100.0);
            put("Reddit", -50.0);
        }};

        // n += sanctions.getOrDefault(s.charAt(i) , 0);

        /*
            От конзолата се четат два реда:
            •	Брой отворени табове в браузъра n - цяло число в интервала [1...10]
            •	Заплата - число в интервала [500...1500]
            След това n – на брой пъти се чете име на уебсайт – текст
         */
        // Get user Inputs
        int n = 0;
        Double[][] ranges = new Double[][]{{1.0, 10.0}, {500.0, 1500.0}};

        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"openTabs", "salary"};
        for(String k : argKeys) {
            System.out.printf("Input \"%s\" %s: ", k, Arrays.toString(ranges[n++])); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.nextLine());
        }// for

        Integer openTabs = 0;
        Double salary = 0.0;
        // Validate user inputs
        try {
            n = 0;
//            for (String k : new String[]{"openTabs"}) { // isInteger ?
//                Integer.parseInt(userInputs.get(k).toString());
//            }
            openTabs = Integer.parseInt(userInputs.get("openTabs").toString());
            salary = Double.parseDouble(userInputs.get("salary").toString());
            for(String k : argKeys) { // isWithinRange?
                if (!(DoubleValidateInput(Double.parseDouble(userInputs.get(k).toString()), ranges[n++]))) {
                    return;
                }// if
            }// for
        }// try
        catch (Exception e) {
            System.out.printf("\nException occured: %s", e.toString());
            return;
        }// catch


        // get inputs and process them:
        String input2;
        for (int i = 0; i < openTabs; i++){
            System.out.printf("Input website %d: ", i);
            input2 = scn.nextLine();
            salary += sanctions.getOrDefault(input2 , 0.0);
        }// for

        // System.out.printf("\nsalary: %.2f", salary);
        System.out.printf("%s", ((salary <= 0) ? "You have lost your salary." : String.format("%.0f", salary)));

    } // main
}// class


// https://stackoverflow.com/questions/7519339/hashmap-to-return-default-value-for-non-found-keys
// https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/
class DefaultHashMap<K,V> extends HashMap<K,V> {
    public V getDefault(K key, V defaultValue) {
        if (containsKey(key)) {
            return get(key);
        }

        return defaultValue;
    }
}// class
