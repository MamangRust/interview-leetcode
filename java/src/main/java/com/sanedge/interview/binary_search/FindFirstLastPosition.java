package com.sanedge.interview.binary_search;

public class FindFirstLastPosition {

    public int[] searchRange(int[] nums, int target) {
        return new int[] { findFirst(nums, target), findLast(nums, target) };
    }

    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int firstPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPos = mid;

                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstPos;
    }

    public int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int lastPost = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPost = mid;

                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastPost;
    }
}
