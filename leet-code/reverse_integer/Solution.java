package reverse_integer;

import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {

    public static final String NEGATIVE_SIGN = "-";

    public static int reverse(int x) {
        String intStr = String.valueOf(x);
        boolean isNegativeNumber = false;
        if (intStr.contains(NEGATIVE_SIGN)) {
            isNegativeNumber = true;
            intStr = intStr.replace(NEGATIVE_SIGN, "");
        }
        String finalIntStr = intStr;
        Stack<Character> stackedIntStrChars = convertStringToCharactersStack(finalIntStr);
        pushNegativeSignToStack(isNegativeNumber, stackedIntStrChars);
        StringBuilder sb = transformCharacterStackToStringBuilder(stackedIntStrChars);
        String rs = sb.toString();
        try {
            return Integer.parseInt(rs);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private static StringBuilder transformCharacterStackToStringBuilder(Stack<Character> stackedIntStrChars) {
        StringBuilder rs = new StringBuilder();
        while (!stackedIntStrChars.isEmpty()) {
            rs.append(stackedIntStrChars.pop());
        }
        return rs;
    }

    private static void pushNegativeSignToStack(boolean isNegativeNumber, Stack<Character> stackedIntStrChars) {
        if (isNegativeNumber) {
            stackedIntStrChars.push(NEGATIVE_SIGN.charAt(0));
        }
    }

    private static Stack<Character> convertStringToCharactersStack(String finalIntStr) {
        Stack<Character> stackedIntStrChars = new Stack<>();
        IntStream.range(0, finalIntStr.length()).forEach(e -> {
            stackedIntStrChars.push(finalIntStr.charAt(e));
        });
        return stackedIntStrChars;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(x));
    }
}
