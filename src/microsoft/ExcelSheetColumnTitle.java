package microsoft;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) return "";

        StringBuilder sb = new StringBuilder();
        int cur = 0;

        while (n > 0) {
            if (n % 26 == 0) {
                sb.insert(0, (char) ((n - 1) % 26 + 'A'));
                n -= 26;
            } else {
                sb.insert(0, (char) ((n - 1) % 26 + 'A'));
            }
            n /= 26;
        }

        return sb.toString();
    }
}
