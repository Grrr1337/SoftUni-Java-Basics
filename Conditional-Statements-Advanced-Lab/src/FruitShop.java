import java.util.HashMap;
import java.util.Scanner;

public class FruitShop {
    /*
        11.	Магазин за плодове
        Магазин за плодове през работните дни работи на следните цени:
        плод	banana	apple	orange	grapefruit	kiwi	pineapple	grapes
        цена	2.50	1.20	0.85	1.45	2.70	5.50	3.85
        Събота и неделя магазинът работи на по-високи цени:
        плод	banana	apple	orange	grapefruit	kiwi	pineapple	grapes
        цена	2.70	1.25	0.90	1.60	3.00	5.60	4.20
        Напишете програма, която чете от конзолата плод (banana / apple / orange / grapefruit / kiwi / pineapple / grapes),
        ден от седмицата (Monday / Tuesday / Wednesday / Thursday / Friday / Saturday / Sunday) и количество (десетично число) ,
        въведени от потребителя, и пресмята цената според цените от таблиците по-горе.
        При невалиден ден от седмицата или невалидно име на плод да се отпечата "error".

     */
    public static boolean _FindFromCombinedTable(Object[][] table, Object kObj, Integer dayIndex, Double amount){
        for (Object[] itm : table) // Monday until Friday
        {
            // System.out.printf("\n%s, %s", fields[0], fields[1]);
            Object[] fields = (Object[]) itm;
            if (kObj.equals(fields[0])) {
                System.out.printf("%.2f", Double.valueOf((((1 <= dayIndex) && (dayIndex <= 5)) ? fields[1] : fields[2]).toString()) * amount);
                return true;
            }
        }// for
        return false;
    }// _FindFromCombinedTable
    public static boolean _FindFromTable(Object[][] table, Object kObj){
        for (Object[] itm : table) // Monday until Friday
        {
            // System.out.printf("\n%s, %s", fields[0], fields[1]);
            Object[] fields = (Object[]) itm;
            if (kObj.equals(fields[0])) {
                System.out.printf("%.2f", fields[1]);
                return true;
            }
        }// for
        return false;
    } // _ FindFromTable

    public static void main(String[] args) {

        int n;

        HashMap<String, Integer> fruitTypeIdx = new HashMap<String, Integer>();
        n = 1; // 1-based requirement
        for(String e : new String[]{"banana", "apple", "orange", "grapefruit", "kiwi",	"pineapple", "grapes"}) {
            // System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n]));
            fruitTypeIdx.put(e, n++);
        }// for

        HashMap<String, Integer> weekDaysIdx = new HashMap<String, Integer>();
        n = 1; // 1-based requirement
        for(String e : new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}) {
            // System.out.printf("\nInput \"%s\" %s : ", k, Arrays.toString(ranges[n]));
            weekDaysIdx.put(e, n++);
        }// for


        Scanner scn = new Scanner(System.in);
        HashMap<String, Object> userInputs = new HashMap<String, Object>();
        String[] argKeys = new String[]{"fruitType", "weekDay", "amount"};
        for(String k : argKeys) {
            System.out.printf("\nInput \"%s\" : ", k); // Arrays.toString(ranges[n])
            userInputs.put(k, scn.next());
        }// for




        Integer fruitIndex = fruitTypeIdx.get(userInputs.get("fruitType")); // fruitIndex
         if (fruitIndex == null) {System.out.printf("error"); return;}

        Integer dayIndex = weekDaysIdx.get(userInputs.get("weekDay")); // dayIndex
        if (dayIndex == null) {System.out.printf("error"); return; }

        // System.out.printf("%s, %s", fi, di);

        Object[][] table1 = new Object[][] { // Monday until Friday
                {"banana", 2.50}, {"apple", 1.20}, {"orange", 0.85}, {"grapefruit", 1.45},
                {"kiwi", 2.70}, {"pineapple", 5.50}, {"grapes", 3.85}
        };
        Object[][] table2 = new Object[][] { // The weekend pricelist
                {"banana", 2.70}, {"apple", 1.25}, {"orange", 0.90}, {"grapefruit", 1.60},
                {"kiwi", 3.00}, {"pineapple", 5.60}, {"grapes", 4.20}
        };

        Object[][] combined = new Object[][] { // combined table (for testing), 3rd element is merged
                {"banana", 2.50, 2.70}, {"apple", 1.20, 1.25}, {"orange", 0.85, 0.90}, {"grapefruit", 1.45, 1.60},
                {"kiwi", 2.70, 3.00}, {"pineapple", 5.50, 5.60}, {"grapes", 3.85, 4.20}
        };


        if(_FindFromCombinedTable(combined, userInputs.get("fruitType"), dayIndex, Double.valueOf(userInputs.get("amount").toString()))) {

            System.out.printf("\nExit from combined table");
            return;
        }

       if ((1 <= dayIndex) && (dayIndex <= 5)) {
           if(_FindFromTable(table1, userInputs.get("fruitType"))) { return; } // Monday until Friday
       }// if
        else if ((6 <= dayIndex) && (dayIndex <= 7)) {
           if(_FindFromTable(table2, userInputs.get("fruitType")))  { return; }// Saturday and Sunday
       }// else

       System.out.printf("error");
    }// main
}


