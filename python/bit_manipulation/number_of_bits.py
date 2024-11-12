

class Solution:
    def hammingWeight(self, num: int) -> int:
        count = 0

        while num != 0:
            count += int(num & 1)

            num >>= 1

        return count
