import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        int number = 0;
        Map<Character, Integer> romanChars = initRomanCharsMap();
        s = transformRomanString(s);
        for (int i = 0; i < s.length(); i++) {
            number = number + romanChars.get(s.charAt(i));
        }
        return number;
    }

    private String transformRomanString(String s) {
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        return s;
    }

    private Map<Character, Integer> initRomanCharsMap() {
        Map<Character, Integer> romanChars = new HashMap<>();
        romanChars.put('I', 1);
        romanChars.put('V', 5);
        romanChars.put('X', 10);
        romanChars.put('L', 50);
        romanChars.put('C', 100);
        romanChars.put('D', 500);
        romanChars.put('M', 1000);
        return romanChars;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(s));
    }


}