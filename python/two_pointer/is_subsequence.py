class Solution:
    def preprocess(self, t: str):
        char_indices = {}

        for index, char in enumerate(t):
            if char not in char_indices:
                char_indices[char] = []

            char_indices[char].append(index)

        return char_indices

    def isSubsequence(self, s: str, t: str) -> bool:
        char_indices = self.preprocess(t)

        current_index = -1

        for char in s:
            if char not in char_indices:
                return False

            found = False
            for index in char_indices[char]:
                if index > current_index:
                    current_index = index

                    found = True

                    break

            if not found:
                return False

        return True
