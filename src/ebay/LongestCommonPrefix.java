package ebay;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"abcc", "abccc", "ab"};

        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)  return "";

        String word = strs[0];

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i) {
                    return strs[j];
                }

                if (strs[j].charAt(i) != word.charAt(i)) {
                    return word.substring(0, i);
                }
            }
        }

        return word;
    }
}
