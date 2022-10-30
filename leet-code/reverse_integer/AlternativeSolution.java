package reverse_integer;

public class AlternativeSolution {

    // MAX: 2147483647
    // MIN: -2147483648

    public static int reverse(int x) {
        int rs = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rs > (Integer.MAX_VALUE / 10) || (rs == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rs < (Integer.MIN_VALUE / 10) || (rs == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rs = rs * 10 + pop;
        }
        return rs;
    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        System.out.println(reverse(x));
    }
}
