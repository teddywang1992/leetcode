package string;

public class countAndSay {
    public static void main(String[] args) {
        int count = 9;
        System.out.println(countAndSayfunction(count));
    }

    private static String countAndSayfunction(int n) {
        if (n <= 0) {
            return null;
        }

        String oldString = "1";
        while (n > 1) {
            n--;
            StringBuilder sb = new StringBuilder();
            char[] chars = oldString.toCharArray();

            for (int i = 0; i < oldString.length(); i++) {
                int count = 1;
                while (i + 1 < oldString.length() && chars[i] == chars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(chars[i]));
            }

            oldString = sb.toString();
        }

        return oldString;
    }
}
