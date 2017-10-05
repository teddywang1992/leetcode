package facebook;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            sum += i >= 0 ? a.charAt(i--) - '0' : 0;
            sum += j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        return sb.toString();
    }
}
