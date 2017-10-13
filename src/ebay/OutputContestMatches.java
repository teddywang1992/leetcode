package ebay;

public class OutputContestMatches {
    public String findContestMatch(int n) {
        if (n <= 0) return "";
        String[] strings = new String[n];

        for (int i = 1; i < n + 1; i++) {
            strings[i - 1] = i + "";
        }

        while (n > 0) {
            for (int i = 0; i < n/2; i++) {
                strings[i] = "(" + strings[i] + "," + strings[n-i-1] + ")";
            }
            n /= 2;
        }

        return strings[0];
    }
}
