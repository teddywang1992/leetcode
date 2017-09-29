package math;

/*
Use buckets to record the last position of digit 0 ~ 9 in this num.

Loop through the num array from left to right. For each position, we check whether there exists a larger digit in this num
(start from 9 to current digit). We also need to make sure the position of this larger digit is behind the current one.
If we find it, simply swap these two digits and return the result.
*/

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] position = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + position[p2];

                position[p1] += sum / 10;
                position[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : position) {
            if (!(sb.length() == 0 && i == 0)) sb.append(i);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
