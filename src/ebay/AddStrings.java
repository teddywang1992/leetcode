package ebay;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int number1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int number2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = (number1 + number2 + carry) % 10;
            carry = (number1 + number2 + carry) / 10;
            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}
