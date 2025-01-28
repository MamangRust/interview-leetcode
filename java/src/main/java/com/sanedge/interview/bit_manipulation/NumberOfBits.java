package com.sanedge.interview.bit_manipulation;

public class NumberOfBits {

    public int hammingWeight(int num) {
        int count = 0;

        while (num != 0) {
            count += num & 1;

            num >>= 1;
        }

        return count;
    }
}
