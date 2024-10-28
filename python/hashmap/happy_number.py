class Solution:
    def is_happy(self, n: int) -> bool:
        seen = set()

        while n != 1 and n not in seen:
            seen.add(n)

            n = self.get_next(n)

        return n == 1

    def get_next(self, number: int):
        total_sum = 0

        while number > 0:
            digit = number % 10

            total_sum += digit**2

            number //= 10

        return total_sum
