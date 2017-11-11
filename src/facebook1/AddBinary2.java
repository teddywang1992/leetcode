package facebook1;

public class AddBinary2 {
    public String addBinary(String a, String b) {
        if (a == null || b == null) return "";
        int ia = a.length() - 1, ib = b.length() - 1;
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (ia >= 0 || ib >= 0 || carry != 0) {
            int value1 = ia >= 0 ? a.charAt(ia--) - '0' : 0;
            int value2 = ib >= 0 ? b.charAt(ib--) - '0' : 0;
            sum = (value1 + value2 + carry) % 2;
            carry = (value1 + value2 + carry) / 2;
            sb.insert(0, sum);
        }

        return sb.toString();
    }
}
