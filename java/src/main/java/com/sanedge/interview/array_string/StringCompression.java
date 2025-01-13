package com.sanedge.interview.array_string;

public class StringCompression {

    public int compress(char[] chars) {
        int write = 0;

        for (int read = 0; read < chars.length;) {
            char currentChar = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write] = currentChar;
            write++;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }

        return write;
    }
}
