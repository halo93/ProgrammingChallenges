
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(solution("aazzzaaabcccc"));
        System.out.println(solution("aaa"));
        System.out.println(solution("abc"));
        System.out.println(anotherSolution("aazzzaaabcccc"));
        System.out.println(anotherSolution("aaa"));
        System.out.println(anotherSolution("abc"));
        System.out.println(anotherSolution2("aazzzaaabcccc"));
        System.out.println(anotherSolution2("aaa"));
        System.out.println(anotherSolution2("abc"));
    }

    // aazzzaaabc -> a2z3a3b1c1
    // a -> sb: "", count = 1
    // a a -> sb: "", count = 2
    // a a z -> sb:
    // abc -> a1b1c1
    public static String solution(String input) {
        int count = 1;
        char prevChar = input.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (prevChar == currentChar) {
                count++;
            } else {
                sb.append(prevChar);
                sb.append(count);
                count = 1;
                prevChar = currentChar;
            }
        }
        sb.append(prevChar);
        sb.append(count);
        return sb.length() > input.length() ? input : sb.toString();
    }

    // aazzzaaabc -> a2z3a3b1c1
    // abc -> a1b1c1
    public static String anotherSolution(String input) {
        if (input.length() == 0) {
            return input;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            count++;
            if (i == input.length() - 1 || currentChar != input.charAt(i + 1)) {
                sb.append(currentChar);
                sb.append(count);
                count = 0;
            }
        }
        return sb.length() > input.length() ? input : sb.toString();
    }

    public static String anotherSolution2(String input) {
        int lengthOfCompression = countLengthOfCompression(input);
        if (lengthOfCompression > input.length()) {
            return input;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            count++;
            if (i == input.length() - 1 || currentChar != input.charAt(i + 1)) {
                sb.append(currentChar);
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }

    private static int countLengthOfCompression(String input) {
        int countCompressionLength = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
                countCompressionLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return countCompressionLength;
    }

    // aazzzaaabc -> a2z3a3b1c1
    // a -> sb: "", count = 1
    // a a -> sb: "", count = 2
    // a a z -> sb:
    // abc -> a1b1c1
    public static String anotherSolution3(String input) {

    }

    private static int countLengthOfCompression1(String input) {
        int count = 0;
        int compressionLength = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;
            if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
                compressionLength += 1 + String.valueOf(count).length();
            }
        }
        return compressionLength;
    }
}
