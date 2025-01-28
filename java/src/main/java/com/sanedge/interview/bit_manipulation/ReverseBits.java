package com.sanedge.interview.bit_manipulation;

public class ReverseBits {

    public int reverseBits(int num) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= num & i;

            num >>= 1;
        }

        return result;
    }
}
