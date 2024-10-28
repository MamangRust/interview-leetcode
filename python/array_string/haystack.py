class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0

        haystack_len, needle_len = len(haystack), len(needle)

        for i in range(haystack_len - needle_len + 1):
            if haystack[i : i + needle_len] == needle:
                return i

        return -1
