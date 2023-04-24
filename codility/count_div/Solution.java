package count_div;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(solution(6, 11, 2));
//        System.out.println(solution(0, 2000000000, 5));
        System.out.println(solution(11, 345, 17));
//        System.out.println(solution(101, 123_439_899, 10000));
    }

    public static int solution(int A, int B, int K) {
        // Implement your solution here
        int firstDividableInRange = A % K == 0 ? A : A + (K - A % K);
        int lastDividableInRange = B - B % K;
        return (lastDividableInRange - firstDividableInRange) / K + 1;
    }
}
