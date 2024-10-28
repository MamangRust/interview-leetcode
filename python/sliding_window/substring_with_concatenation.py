from collections import Counter


class Solution:
    def findSubString(self, s: str, words: list[str]) -> list[str]:
        if not s or not words:
            return []

        word_len = len(words[0])
        word_count = len(words)
        total_len = word_len * word_count
        word_map = Counter(words)

        result = []

        for i in range(word_len):
            left = i
            right = i

            curr_map = Counter()

            while right + word_len <= len(s):
                word = s[right : right + word_len]

                right += word_len

                if word in word_map:
                    curr_map[word] += 1

                    while curr_map[word] > word_map[word]:
                        left_word = s[left : left + word_len]

                        curr_map[left_word] -= 1

                        left += word_len

                    if right - left == total_len:
                        result.append(left)
                else:
                    curr_map.clear()
                    left = right

        return result
