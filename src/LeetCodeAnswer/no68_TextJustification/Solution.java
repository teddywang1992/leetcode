package LeetCodeAnswer.no68_TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + 1 + count > L) break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int diff = last - 1 - index;
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < L; i++) sb.append(" ");
            } else {
            	System.out.println(count);
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                System.out.println("spaces:" + spaces + ", r: " + r);
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < r ? 1 : 0)); j++) sb.append(" ");
                    }
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.fullJustify(new String[]{"This", "is", "a", "This", "is", "a"}, 10));
	}
}