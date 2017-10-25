package microsoft;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int n = s.length();
        int result = 0;
        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * carry;
            carry *= 26;
        }

        return result;
    }
}
