package facebook2;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
//    Decode ways
    // Use a array to record how many ways we can decode in this number
// Traverse from the tail to head which could handle the situation "0"
// Always take two digits, if the number <= 26
// Then count[i] = count[i + 1] + count[i + 2], means we can decode as one letter or two letters
// else count[i] = count[i + 1], means we can only decode as one letter
//'space complexity:O(n)'
    public int numDecodings1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] count = new int[s.length() + 1];
        count[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0') {
            count[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            String numberString = s.substring(i, i + 2);
            int number = Integer.parseInt(numberString);
            if (number <= 26) {
                count[i] = count[i + 1] + count[i + 2];
            }
            else {
                count[i] = count[i + 1];
            }
        }
        return count[0];
    }

    //    Inplace way
//'space complexity: O(1)'
    public int numDecodings2(String s) {
        int last = 0;
        int secondLast = 1;
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(s.length() - 1) != '0') {
            last = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                secondLast = last;
                last = 0;
                continue;
            }
            int number = Integer.parseInt(s.substring(i, i + 2));
            if (number <= 26) {
                int temp = last;
                last = last + secondLast;
                secondLast = temp;
            }
            else {
                secondLast = last;
            }
        }
        return last;
    }

    //    Output the result of all decode string
//'Time complexity: O(1.6 ^ n)'
    class Decode {
        public List<String> decode(String num) {
            List<String> result = new ArrayList<>();
            helper(result, 0, num, "");
            return result;
        }

        private void helper(List<String> result, int pos, String num, String way) {
            if (pos == num.length()) {
                result.add(way);
                return;
            }
            String digits = num.substring(pos, pos + 1);
            int number = Integer.parseInt(digits);
            if (number == 0) {
                return;
            }
            helper(result, pos + 1, num, way + (char)(number + 'A' - 1));
            if (pos < num.length() - 1) {
                String digits2 = num.substring(pos, pos + 2);
                int number2 = Integer.parseInt(digits2);
                if (number <= 26) {
                    helper(result, pos + 2, num, way + (char)(number2 + 'A' - 1));
                }
            }
        }
    }
}
