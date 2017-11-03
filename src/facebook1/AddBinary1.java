package facebook1;

public class AddBinary1 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || a .length() == 0) return a;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int value1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int value2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            sum = (value1 + value2 + carry) % 2;
            carry = (value1 + value2 + carry) / 2;
            sb.insert(0, sum);
        }
        return sb.toString();
    }
}
