package com.sanedge.interview.binary_search;

import java.util.Arrays;

public class SuccessfullyPairsOfSpellsAndPosition {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = potions.length;
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];

            long minPotionStrength = (success + spell - 1) / spell;

            int idx = lowerBound(potions, minPotionStrength);

            result[i] = n - idx;
        }

        return result;
    }

    private int lowerBound(int[] potions, long minPotionStrength) {
        int left = 0;
        int right = potions.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (potions[mid] >= minPotionStrength) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
