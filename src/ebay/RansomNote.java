package ebay;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 0 && magazine.length() == 0) return true;
        if (magazine == null || magazine.length() == 0) return false;

        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) return false;
        }

        return true;
    }
}
