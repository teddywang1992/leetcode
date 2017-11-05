package facebook1;

public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int start = 0;
        int end = citations.length - 1;
        int length = citations.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == length - mid) return length - mid;
            else if (citations[mid] > length - mid) end = mid;
            else start = mid;
        }

        if (citations[start] >= length - start) return length - start;
        if (citations[end] >= length - end) return length - end;
        return 0;
    }
}
