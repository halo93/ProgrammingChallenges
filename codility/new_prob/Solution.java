package new_prob;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("(){}"));
        System.out.println(solution("([)()]"));
        System.out.println(solution("{(})"));
        System.out.println(solution("(}{)"));
    }

    public static int solution(String S) {
        // Implement your solution here
        if (S.length() == 0) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }
        // (){} (}{)
        // {[()()]}
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                Character pop = stack.pop();
                if (!isMatchingBrackets(pop, currentChar)) {
                    return 0;
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static boolean isMatchingBrackets(char c1, char c2) {
        return (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')');
    }
}
