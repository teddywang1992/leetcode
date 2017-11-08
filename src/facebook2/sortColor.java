package facebook2;

public class sortColor {
    //    sort color: (is_low, is_mid, is_high)
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int index = 0;
        while (index <= twoIndex && zeroIndex < twoIndex) {
            if (nums[index] == 0) {
                nums[index] = nums[zeroIndex];
                nums[zeroIndex] = 0;
                zeroIndex++;
                index++;
            }
            else if (nums[index] == 2) {
                nums[index] = nums[twoIndex];
                nums[twoIndex] = 2;
                twoIndex--;
            }
            else {
                index++;
            }
        }
    }
    public void sortKColor(int[] colors, int k) {
        int left = 0;
        int right = colors.length - 1;
        while (k > 0) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }
            int index = left;
            int minIndex = left;
            int maxIndex = right;
            while (minIndex < maxIndex && index <= maxIndex) {
                if (colors[index] == min) {
                    colors[index] = colors[minIndex];
                    colors[minIndex] = min;
                    minIndex++;
                    index++;
                }
                else if (colors[index] == max) {
                    colors[index] = colors[maxIndex];
                    colors[maxIndex] = max;
                    maxIndex--;
                }
                else {
                    index++;
                }
            }
            left = minIndex;
            right = maxIndex;
            k -= 2;
        }
    }

    public void countingSort(int[] colors) {
        int[] count = new int[3];
        for (int color : colors) {
            count[color]++;
        }
        int[] index = new int[3];
        int total = 0;
        for (int i = 0; i < 3; i++) {
            index[i] = total;
            total += count[i];
        }
        int[] temp = new int[colors.length];
        for (int i = 0; i < colors.length; i++) {
            temp[index[colors[i]]] = colors[i];
            index[colors[i]]++;
        }
        for (int i = 0; i < colors.length; i++) {
            colors[i] = temp[i];
        }
    }
}
