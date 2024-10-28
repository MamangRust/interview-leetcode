class Solution:
    def isPalingdrome(self, s: str) -> bool:
        filtered_chars = [char.lower() for char in s if char.isalnum()]

        return filtered_chars == filtered_chars[::-1]
