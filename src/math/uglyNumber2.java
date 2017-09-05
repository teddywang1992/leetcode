package math;

import sun.jvm.hotspot.jdi.LongValueImpl;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class uglyNumber2 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9));
    }
    private static int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> hashSet = new HashSet<>();
        Long[] primeNumber = new Long[3];
        primeNumber[0] = Long.valueOf(2);
        primeNumber[1] = Long.valueOf(3);
        primeNumber[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++) {
            queue.add(primeNumber[i]);
            hashSet.add((primeNumber[i]));
        }

        Long current = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            current = queue.poll();
            for (int j = 0; j < 3; j++) {
                if (!hashSet.contains(current * primeNumber[j])) {
                    hashSet.add(current * primeNumber[j]);
                    queue.add(current * primeNumber[j]);
                }
            }
        }

        return current.intValue();
    }
}
