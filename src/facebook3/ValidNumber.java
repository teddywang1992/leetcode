package facebook3;

public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        boolean pointSeen = false;
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            }
            else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            }
            else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            }
            else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
