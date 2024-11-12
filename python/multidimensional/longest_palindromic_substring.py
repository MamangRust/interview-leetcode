

class Solution:
    def longestPalindrome(self,s: str) -> str:
        if len(s) <2:
            return s

        start, maxLength = 0, 1


        def expandAroundCenter(left: int, right: int):
            nonlocal maxLength

            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 > maxLength:
                    start = left

                    maxLength = right - left + 1



                left-=1
                right+=1



        for i in range(len(s)):
            expandAroundCenter(i, i)
            expandAroundCenter(i, i + 1)


        return s[start : start+maxLength]
