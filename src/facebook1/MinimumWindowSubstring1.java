package facebook1;

public class MinimumWindowSubstring1 {
    public String minWindow(String s, String t) {
        int[] counter = new int[256];
        for(int i = 0; i < t.length(); i++) {
            counter[t.charAt(i)]++;
        }
        int maxLen = Integer.MAX_VALUE, start = -1;
        int lo = 0, hi = 0, remain = t.length();

        while(hi < s.length()) {
            if(counter[s.charAt(hi++)]-- > 0) remain--;
            // we have meet all of chars
            while(remain == 0) {
                if(maxLen > hi - lo) {
                    maxLen = hi - lo;
                    start = lo;
                }
                if(++counter[s.charAt(lo++)] > 0) remain++;
            }
        }
        return start == -1 ?  "" : s.substring(start, start + maxLen);
    }
}
