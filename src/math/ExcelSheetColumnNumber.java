package math;

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
