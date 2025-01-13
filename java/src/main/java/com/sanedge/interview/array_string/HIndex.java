package com.sanedge.interview.array_string;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {

    public int hIndex(int[] citations) {
        Integer[] citationsBoxed = Arrays.stream(citations)
            .boxed()
            .toArray(Integer[]::new);
        Arrays.sort(citationsBoxed, Collections.reverseOrder());

        int h = 0;

        for (int i = 0; i < citationsBoxed.length; i++) {
            if (citationsBoxed[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }

        return h;
    }
}
