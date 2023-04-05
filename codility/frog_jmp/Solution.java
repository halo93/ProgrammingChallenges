package frog_jmp;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    public static int solution(int X, int Y, int D) {
        // Implement your solution here
        if ((Y - X) % D == 0) {
            return (Y - X) / D;
        }
        return (Y - X) / D + 1;
    }
}
