package facebook1;

public class MultiplyStrings1 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        int[] positions = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num11 = num1.charAt(i) - '0';
                int num22 = num2.charAt(j) - '0';
                int high = i + j;
                int low = high + 1;
                int sum = positions[low] + num11 * num22;
                positions[low] = sum % 10;
                positions[high] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : positions) {
            if (!(num == 0 && sb.length() == 0)) sb.append(num);
        }

        return sb.length() == 0 ? "0" :sb.toString();
    }
}
