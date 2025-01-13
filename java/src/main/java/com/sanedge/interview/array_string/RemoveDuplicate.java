package com.sanedge.interview.array_string;

public class RemoveDuplicate {

    public int removeDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow += 1;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
