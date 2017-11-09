package facebook2;

import java.util.HashMap;

public class MatchStringPermutation {
//            17. 字符串匹配，最原始的那种：一个s，一个p，在s里面找p，返回第一个匹配字串的开头下标。如没有返回-1。忘了KMP怎么写的了，只能brute-force。。。。。
//    follow up：不用写代码，大概描述一下：不是找p，而是找p的permutation。比如s="aabacddccab", p="dadc"，返回3。因为acdd是dadc的permutation。
//    Strstr permutation
//    Follow Up :
    // Use HashMap to record the letters in the P
    public int strStrPermutation(String haystack, String needle) {
        HashMap<Character, Integer> letterToCount = new HashMap<>();
        for (char letter : needle.toCharArray()) {
            if (letterToCount.containsKey(letter)) {
                letterToCount.put(letter, letterToCount.get(letter) + 1);
            }
            else {
                letterToCount.put(letter, 1);
            }
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (letterToCount.containsKey(haystack.charAt(i))) {
                HashMap<Character, Integer> temp = new HashMap<>(letterToCount);
                int j = i;
                while (j < haystack.length()) {
                    char letter = haystack.charAt(j);
                    if (temp.containsKey(letter)) {
                        temp.put(letter, temp.get(letter) - 1);
                    }
                    else {
                        break;
                    }
                    if (temp.get(letter) == 0) {
                        temp.remove(letter);
                    }
                    if (temp.size() == 0) {
                        return i;
                    }
                    j++;
                }
                if (j == haystack.length()) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
