package integer_to_roman;

public class Solution {
    public String intToRoman(int num) {
        String romanStr = "";
        while (num > 0) {
            if (num >= 1000) {
                num = num - 1000;
                romanStr += 'M';
            } else if (num >=500) {
                num = num - 500;
                romanStr += 'D';
            } else if (num >= 100) {
                num = num - 100;
                romanStr += 'C';
                if (romanStr.endsWith("DCCCC")) {
                    romanStr = romanStr.replace("DCCCC", "CM");
                }
                if (romanStr.endsWith("CCCC")) {
                    romanStr = romanStr.replace("CCCC", "CD");
                }
            } else if (num >= 50) {
                num = num - 50;
                romanStr += 'L';
            } else if (num >= 10) {
                num = num - 10;
                romanStr += "X";
                if (romanStr.endsWith("LXXXX")) {
                    romanStr = romanStr.replace("LXXXX", "XC");
                }
                if (romanStr.endsWith("XXXX")) {
                    romanStr = romanStr.replace("XXXX", "XL");
                }
            } else if (num >= 5) {
                num = num - 5;
                romanStr += "V";
            } else {
                num = num - 1;
                romanStr += 'I';
                if (romanStr.endsWith("VIIII")) {
                    romanStr = romanStr.replace("VIIII", "IX");
                }
                if (romanStr.endsWith("IIII")) {
                    romanStr = romanStr.replace("IIII", "IV");
                }
            }
        }
        return romanStr;
    }

    public static void main(String[] args) {
        int num = 58;
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(num));
    }


}