package facebook1;

public class HIndex {
    public int hIndex(int[] citations) {
        int[] temp = new int[citations.length + 1];

        for (int citation : citations) {
            int index = Math.min(citations.length, citation);
            temp[index]++;
        }
        int h = 0;
        for (int i = citations.length; i >= 0; i--) {
            h += temp[i];
            if (h >= i) {
                return i;
            }
        }

        return h;
    }
}
