package bin_gap;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        System.out.println(solution(15));
    }

    public static int solution(int N) {
        // Implement your solution here
        var binStr = Integer.toBinaryString(N);
        int longestBinGap = 0;
        if (binStr.endsWith("0")) {
            binStr = binStr.replaceAll("0+$", "");
        }
        if (!binStr.contains("0")) {
            return 0;
        }
        String[] split = binStr.split("1+");
        for (var s : split) {
            if (s.length() > longestBinGap) {
                longestBinGap = s.length();
            }
        }
        return longestBinGap;
    }
}
