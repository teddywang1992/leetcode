package no482_LicenseKeyFormatting;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase().replace("-", "");
        int len = S.length();
        StringBuilder sb = new StringBuilder(S);
        for (int i = K; i < len; i = i + K) {
            sb.insert(len - i,'-');
        }
        return sb.toString();
    }
}