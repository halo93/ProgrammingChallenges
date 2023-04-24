package genomic_range_query;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{0, 5, 0}, new int[]{1, 5, 6})));
    }

    public static int[] badSolution(String S, int[] P, int[] Q) {
        // Implement your solution here
        int[] rs = new int[P.length];
        if (S.length() == 1) {
            rs[0] = NUCLEOTIDE_TYPE.valueOf(S).getImpactFactor();
            return rs;
        }
        int[] smallestASCIICharInSubDNAs = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int minIdx = P[i];
            int maxIdx = Q[i];
            int index = i;
            S.substring(minIdx, maxIdx + 1).chars().min().ifPresent(e -> smallestASCIICharInSubDNAs[index] = e);
        }
        return Arrays.stream(smallestASCIICharInSubDNAs).map(NUCLEOTIDE_TYPE::getImpactFactorFromASCII).toArray();
    }

    public enum NUCLEOTIDE_TYPE {
        A("A", 1, 65),
        C("C", 2, 67),
        G("G", 3, 71),
        T("T", 4, 84);

        private final String name;
        private final int impactFactor;
        private final int asciiValue;

        NUCLEOTIDE_TYPE(String name, int impactFactor, int asciiValue) {
            this.name = name;
            this.impactFactor = impactFactor;
            this.asciiValue = asciiValue;
        }

        public int getImpactFactor() {
            return impactFactor;
        }

        public String getName() {
            return name;
        }

        public int getAsciiValue() {
            return asciiValue;
        }

        public static int getImpactFactorFromASCII(int asciiValue) {
            return Arrays.stream(NUCLEOTIDE_TYPE.values())
                    .filter(e -> e.getAsciiValue() == asciiValue)
                    .map(NUCLEOTIDE_TYPE::getImpactFactor).findAny().orElse(0);
        }
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int[][] genoms = new int[3][S.length() + 1];
        short a,c,g;
        //CAGCCTA
        // 0, 0, 1, 1, 1, 1, 1, 2 -> A
        // 0, 1, 1, 1, 2, 3, 3, 3 -> C
        // 0, 0, 0, 1, 1, 1, 1, 1 -> G

        for (int i = 0; i < S.length(); i++) {
            a = 0; c = 0; g = 0;
            char character = S.charAt(i);
            if ('A' == character) {
                a = 1;
            }
            if ('C' == character) {
                c = 1;
            }
            if ('G' == character) {
                g = 1;
            }
            genoms[0][i + 1] = genoms[0][i] + a;
            genoms[1][i + 1] = genoms[1][i] + c;
            genoms[2][i + 1] = genoms[2][i] + g;
        }
        System.out.println(Arrays.deepToString(genoms));
        int[] rs = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int fromIdx = P[i];
            int toIdx = Q[i] + 1;
            if (genoms[0][toIdx] - genoms[0][fromIdx] > 0) {
                rs[i] = 1;
            } else if (genoms[1][toIdx] - genoms[1][fromIdx] > 0) {
                rs[i] = 2;
            } else if (genoms[2][toIdx] - genoms[2][fromIdx] > 0) {
                rs[i] = 3;
            } else {
                rs[i] = 4;
            }
        }
        return rs;
    }
}
