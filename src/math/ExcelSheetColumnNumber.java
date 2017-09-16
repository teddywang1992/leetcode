package math;

/*
corner case Z
进位时要先乘以进位数-1 然后再弄，先后顺序要先弄明白
 */

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int temp = 1;
        for (int i = s.length(); i > 0; i--) {
            result += ((int) s.charAt(i - 1) - 'A' + 1) * temp;
            temp *= 26;
        }

        return result;
    }
}
