package facebook3;

public class TrappingRainWater {
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int sum = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left++];
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right--];
            }
        }

        return sum;
    }
}
