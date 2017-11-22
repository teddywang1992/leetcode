package no42_TrappingRainWater;

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftH = height[left], rightH = height[right];
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                result += Math.max(0, leftH - height[left]);
                leftH = Math.max(height[left], leftH);
            } else {
                right--;
                result += Math.max(0, rightH - height[right]);
                rightH = Math.max(height[right], rightH);
            }
        }
        return result;
    }
}