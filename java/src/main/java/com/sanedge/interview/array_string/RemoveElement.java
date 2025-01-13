package com.sanedge.interview.array_string;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];

                slow += 1;
            }
        }

        return slow;
    }
}
