package microsoft;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String s1 = "1.1";
        String[] strings = s1.split("\\.");
    }

    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");

        int length = Math.max(strings1.length, strings2.length);
        for (int i = 0; i < length; i++) {
            int value1 = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int value2 = i < strings2.length ? Integer.parseInt(strings2[i]) : 0;
            if (value1 > value2) return 1;
            else if (value1 < value2) return -1;
        }
        return 0;
    }
}
