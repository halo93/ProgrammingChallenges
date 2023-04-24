package perfect_square;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(solution(4, 17));
        System.out.println(swapSingle(new int[]{1, 5, 3, 3, 7}, 5));
    }

    public static int solution(int A, int B) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            System.out.println(i);
            double sqrt = Math.sqrt(i) % 1.0;
            System.out.println(sqrt);
            if (sqrt == 0.0) {
                count++;
            }
        }
        return count;
    }

    public static boolean swapSingle(int[] arr, int n) {
        int first = 0, second = 0;
        int count = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] < arr[i - 1])
            {
                count++;
                if (first == 0)
                    first = i;
                else
                    second = i;
            }
        }

        // If there are more than two elements
        // are out of order.
        if (count > 2)
            return false;

        // If all elements are sorted already
        if (count == 0)
            return true;

        // Cases like {1, 5, 3, 4, 2}
        // We swap 5 and 2.
        if (count == 2)
            swap(arr, first - 1, second);

            // Cases like {1, 2, 4, 3, 5}
        else if (count == 1)
            swap(arr, first - 1, first);

        // Now check if array becomes sorted
        // for cases like {4, 1, 2, 3}
        for (int i = 1; i < n; i++)
            if (arr[i] < arr[i - 1])
                return false;

        return true;
    }

    static int[] swap(int []arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

}
