package ebay;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
