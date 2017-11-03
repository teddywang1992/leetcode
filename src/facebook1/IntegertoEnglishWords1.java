package facebook1;

public class IntegertoEnglishWords1 {
    private final String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};
    private final String[] LESS_THAN_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String word = "";

        while (num != 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + THOUSANDS[i] + " " + word;
            }
            i++;
            num /= 1000;
        }
        return word.trim();
    }

    private String helper(int num) {
        if (num == 0) return "";
        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        }
        if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        }
        else {
            return helper(num / 100) + "Hundred" + " " + helper(num % 100);
        }
    }
}
