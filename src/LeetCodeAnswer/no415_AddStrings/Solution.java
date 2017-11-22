package LeetCodeAnswer.no415_AddStrings;

public class Solution {
    public String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int index1 = char1.length - 1, index2 = char2.length - 1;
        while (index1 >= 0 && index2 >= 0) {
            int sum = Character.getNumericValue(char1[index1]) + Character.getNumericValue(char2[index2]) + carry;
            carry = sum / 10;
            sb.append(String.valueOf(sum % 10));
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int sum = Character.getNumericValue(char1[index1]) + carry;
            carry = sum / 10;
            sb.append(String.valueOf(sum % 10));
            index1--;
        }
        while (index2 >= 0) {
            int sum = Character.getNumericValue(char2[index2]) + carry;
            carry = sum / 10;
            sb.append(String.valueOf(sum % 10));
            index2--;
        }
        if (carry != 0) {
            sb.append(String.valueOf(1));
        }
        return sb.reverse().toString();
    }
}