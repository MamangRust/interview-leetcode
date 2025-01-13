package com.sanedge.interview.array_string;

public class WaterTrapped {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int left_max = height[left];
        int right_max = height[right];

        int water_trapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);

                water_trapped += left_max - height[left];

                left += 1;
            } else {
                right_max = Math.max(right_max, height[right]);

                water_trapped += right_max - height[right];

                right -= 1;
            }
        }

        return water_trapped;
    }
}
