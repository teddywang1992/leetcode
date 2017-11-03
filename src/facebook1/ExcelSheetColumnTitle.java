package facebook1;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, (char) (--n % 26 + 'A'));
            n /= 26;
        }

        return sb.toString();
    }
}
