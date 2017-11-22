package no531_LonelyPixelI;

class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;

        int[] colArray = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') colArray[j]++;
            }
        }

        int ret = 0;
        for (int i = 0; i < picture.length; i++) {
            int count = 0, pos = 0;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                    pos = j;
                }
            }
            if (count == 1 && colArray[pos] == 1) ret++;
        }
        return ret;
    }
}