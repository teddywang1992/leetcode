package ebay;

public class addDigits {
    public int addDigits(int num) {
        if (num < 10) return num;
        int cur = 0;
        while (num != 0) {
            cur += num % 10;
            num /= 10;
        }
        return addDigits(cur);
    }
}
