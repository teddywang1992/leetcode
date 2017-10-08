package ebay;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        while (true) {
            int cur = n % 10;
            sum += cur * cur;
            n = n / 10;
            if (n == 0) {
                n = sum;
                if (n == 1) return true;
                if (set.contains(n)) return false;
                set.add(n);
                sum = 0;
            }
        }
    }
}
