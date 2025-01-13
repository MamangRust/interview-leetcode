package com.sanedge.interview.binary_search;

public class GuessNumberHigherLower {

    public int guess(int num) {
        int target = 6;

        if (num < target) {
            return 1;
        } else if (num > target) {
            return -1;
        }

        return 0;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
