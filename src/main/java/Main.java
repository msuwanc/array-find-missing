import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 1; i < 100; i++) {
            a[i] = i;
        }
        System.out.println(findFirtMissingNumber(a));

        int[] c = new int[100];
        for (int i = 1; i < 100; i++) {
            c[i] = i;
        }
        c[50] = 200;
        System.out.println(findFirtMissingNumber(c));

        int[] b = new int[101];
        for (int i = 1; i < 101; i++) {
            b[i] = i;
        }
        System.out.println(findFirtMissingNumber(b));
    }

    private static int findFirtMissingNumber(int[] a) {
        Map<Integer, Integer> numberToCount = new HashMap<>();
        for (int i = 1; i < 101; i++) {
            numberToCount.put(i, 0);
        }
        for(int elem: a) {
            numberToCount.put(elem, numberToCount.containsKey(elem) ? numberToCount.get(elem) + 1 : 1);
        }
        for(Map.Entry<Integer, Integer> entry: numberToCount.entrySet()) {
            if(entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No missing number, all numbers are in there from 1 to 100");
    }
}
