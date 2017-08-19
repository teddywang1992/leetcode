package warmup;

public class strStr {
    public static void main(String[] args) {
        String test1 = "asdfasdfasdfdfdfdfdfdenglishjksdjksfjk";
        String test2 = "english";
        strStr obj = new strStr();
        System.out.println(obj.strStrFunction(test1, test2));
    }
    public int strStrFunction(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}
