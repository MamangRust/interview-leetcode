package com.sanedge.interview.binary_search;

import java.util.function.IntPredicate;

public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {
        IntPredicate canFinish = k -> {
            int time = 0;

            for (int pile : piles) {
                time += (pile + k - 1) / k;
            }

            return time <= h;
        };

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            if (pile > right) {
                right = pile;
            }
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish.test(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
