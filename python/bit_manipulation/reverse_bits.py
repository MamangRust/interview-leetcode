
class Solution:
    def reverseBits(self,num: int) -> int:
        result = 0

        for i in range(32):
            result <<= 1

            result |= num & 1

            num >>= 1

        return result
