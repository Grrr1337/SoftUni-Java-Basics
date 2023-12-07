

import java.util.HashMap;
import java.util.Scanner;

public class VowelsSum {
    /*
        Да се напише програма, която чете текст (стринг),
        въведен от потребителя, изчислява и отпечатва сумата от стойностите на гласните букви според таблицата по-долу:

        буква	a	e	i	o	u
        стойност	1	2	3	4	5
    */
    public static void main(String[] args) {


        // HashMap<Character, Integer> vHash = new HashMap<>()
        DefaultHashMap<Character, Integer> vHash = new DefaultHashMap<>() {{
            put('a', 1);
            put('e', 2);
            put('i', 3);
            put('o', 4);
            put('u', 5);
            // put(null, 0);
        }};

        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        int n = 0;
        for(int i = 0; i < s.length() ; i++){
//            System.out.println(vHash.getOrDefault(s.charAt(i) , 0));
//            System.out.println(vHash.get(s.charAt(i)));
            n += vHash.getOrDefault(s.charAt(i) , 0);
        }// for
        System.out.println(n);

    }// main
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