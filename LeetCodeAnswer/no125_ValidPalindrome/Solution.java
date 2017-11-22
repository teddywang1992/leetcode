package no125_ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]","");
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}