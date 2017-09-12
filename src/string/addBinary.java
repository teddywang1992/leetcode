package string;

public class addBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        String result = "";
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            result = (sum % 2) + result;
            carry = sum / 2;
        }

        if (carry != 0) {
            result = carry + result;
        }

        return result;
    }
}
