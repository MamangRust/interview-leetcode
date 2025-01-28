package com.sanedge.interview.heap;

import java.util.Random;

public class KthLargestElementArray {
  public static int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  private static int quickSelect(int[] nums, int left, int right, int k) {
    if (left == right) {
      return nums[left];
    }

    Random rand = new Random();

    int pivotIndex = left + rand.nextInt(right - left + 1);

    pivotIndex = partition(nums, left, right, pivotIndex);

    if (k == pivotIndex) {
      return nums[k];
    } else if (k < pivotIndex) {
      return quickSelect(nums, left, pivotIndex - 1, k);
    } else {
      return quickSelect(nums, pivotIndex + 1, right, k);
    }
  }

  private static int partition(int[] nums, int left, int right, int pivotIndex) {
    int pivot = nums[pivotIndex];

    swap(nums, pivotIndex, right);

    int storeIndex = left;

    for (int i = left; i < right; i++) {
      if (nums[i] < pivot) {
        swap(nums, storeIndex, i);
        storeIndex++;
      }
    }

    swap(nums, storeIndex, right);

    return storeIndex;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
