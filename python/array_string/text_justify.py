from typing import List


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[int]:
        result = []
        line = []
        line_length = 0

        for word in words:
            if line_length + len(word) + len(line) > maxWidth:
                if len(line) == 1:
                    result.append(line[0] + " " * (maxWidth - line_length))
                else:
                    total_spaces = maxWidth - line_length

                    for i in range(total_spaces):
                        line[i % (len(line) - 1)] += " "

                    result.append("".join(line))

                line, line_length = [], 0
            line.append(word)

            line_length += len(word)

        last_line = " ".join(line)

        result.append(last_line + " " * (maxWidth - len(last_line)))

        return result
