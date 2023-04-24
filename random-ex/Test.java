import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] input = {2,7,4,1,8,1};
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : input) {
            heap.add(i);
        }
        System.out.println(heap);
        heap.remove();
        System.out.println(heap);
        heap.poll();
        System.out.println(heap);
    }
}
