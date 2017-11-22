package no275_HIndexII;

public class Solution {
    public int hIndex(int[] citations) {
        // find the first index such that citations[index] >= length(citations) - index
        if (citations == null || citations.length == 0) return 0;
        int start = 0, end = citations.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= citations.length - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[start] >= citations.length - start) return citations.length - start;
        if (citations[end] >= citations.length - end) return citations.length - end;
        return 0;
    }
}