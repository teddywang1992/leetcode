package math;

public class HIndex {
    public int hIndex(int[] citations) {
        int h = 0;
        int[] temp = new int[citations.length + 1];

        for (int citation : citations) {
            int index = Math.min(citations.length, citation);
            temp[index]++;
        }

        for (int i = citations.length; i >= 0; i--) {
            h += temp[i];
            if (h >= i) {
                return i;
            }
        }

        return 0;
    }
//     public int hIndex(int[] citations) {
//         Arrays.sort(citations);
//         int result = 0;

//         for (int i = 0; i < citations.length; i++) {
//             if (citations[i] >= citations.length - i) {
//                 return citations.length - i;
//             }
//         }

//         return result;
//     }
}
