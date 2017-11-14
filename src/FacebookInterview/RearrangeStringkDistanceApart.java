package FacebookInterview;

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        int[] counter = new int[26];
        int[] valid = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int candidate = getCandidate(counter, valid, i);
            if (candidate == -1) return "";
            counter[candidate]--;
            valid[candidate] = i + k;
            sb.append((char) (candidate + 'a'));
        }
        return sb.toString();
    }
    private int getCandidate(int[] counter, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int candidate = -1;
        for (int i = 0; i < 26; i++) {
            if (counter[i] > max && counter[i] > 0 && index >= valid[i]) {
                max = counter[i];
                candidate = i;
            }
        }
        return candidate;
    }
}
