from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)

        dp = [False]
        dp[0] = True


        for i in range (1, len(s) + 1):
            for j in range (i):
                if dp[i] and s[j:i] in wordSet:
                    dp[i] = True

                    break


        return dp[len(s)]
