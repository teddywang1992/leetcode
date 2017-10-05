package facebook;

public class IntegerToEnglishWords {
    private static final String[] LESS_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        int num = 1234567;
        System.out.println(numberToWords(num));

    }

    private static String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String word = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + " " + THOUSANDS[i] + " " + word;
            }

            i++;
            num /= 1000;
        }

        return word;
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num <= 20) {
            return LESS_TWENTY[num];
        } else if (num <= 100) {
            return TENS[num / 10] + helper(num % 10);
        } else {
            return LESS_TWENTY[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
