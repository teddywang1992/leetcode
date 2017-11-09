package facebook2;

public class moveChar {
//    10.  给一个字符串和一个输入的字符，要求移走给定的字符， (Move Zero, zeros, zeroes, move char)
    // move zero like
    // traverse the string and put the non-target character into the
    // char array one by one, and put the target character at the end
    class MoveChar {
        public String removeChar(char[] input, char k) {
            int fast = 0;
            int slow = 0;
            while (fast < input.length) {
                while (slow < input.length && input[slow] != k) {
                    slow++;
                }
                fast = slow;
                while (fast < input.length && input[fast] == k) {
                    fast++;
                }
                while (fast < input.length && input[fast] != k) {
                    input[slow] = input[fast];
                    input[fast] = k;
                    fast++;
                    slow++;
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < slow; i++) {
                result.append(input[i]);
            }
            return result.toString();
        }
    }

}
