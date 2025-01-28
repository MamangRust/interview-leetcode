package com.sanedge.interview.bit_manipulation;

public class BitwiseAndNumberRange {

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;

        while (m < n) {
            m >>= 1;
            n >>= 1;

            shift++;
        }

        return m << shift;
    }
}
