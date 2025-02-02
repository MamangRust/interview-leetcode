package com.sanedge.interview.array_string;

public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int length = flowerbed.length;

    for (int i = 0; i < length; i++) {
      if (flowerbed[i] == 0) {
        boolean emptyLeft = (i == 0 || flowerbed[i - 1] == 0);
        boolean emptyRight = (i == length - 1 || flowerbed[i + 1] == 0);

        if (emptyLeft && emptyRight) {
          flowerbed[i] = 1;

          n--;

          if (n == 0) {
            return true;
          }
        }
      }
    }

    return n <= 0;
  }
}
