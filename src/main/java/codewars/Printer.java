package codewars;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        System.out.println(printerError("aaaxbbbbyyhwawiwjjjwwm"));
    }

    public static String printerError(String s) {
        List<Character> list = new ArrayList<Character>();
        Set<Character> used = new HashSet<>();

        int i = 0;
        for(char c : s.toCharArray()) {
            list.add(Character.toLowerCase(c));
        }


        for (char c : list) {
            if(used.add(c)) {
                if(c>109) {
                    i += Collections.frequency(list, c);
                }
            }
        }
        return i+"/"+list.size();
    }
}
