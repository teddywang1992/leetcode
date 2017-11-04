package facebook1;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] position = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int high = i + j;
                int low = high + 1;
                int sum = position[low] + ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                position[low] = sum % 10;
                position[high] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : position) {
            if (!(i == 0 && sb.length() == 0)) sb.append(i);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
