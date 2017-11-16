package facebook3;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        helper(result, 4, s, "");
        return result;
    }

    private void helper(List<String> result, int k, String s, String out) {
        if (k == 0) {
            if (s.length() == 0) {
                result.add(out);
                return;
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (s.length() >= i && isValid(s.substring(0, i))) {
                    if (k == 1) helper(result, k - 1, s.substring(i), out + s.substring(0, i));
                    else helper(result, k - 1, s.substring(i), out + s.substring(0, i) + ".");
                }
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0)=='0' && s.length()>1) || Integer.valueOf(s) > 255) return false;
        return true;
    }
}
