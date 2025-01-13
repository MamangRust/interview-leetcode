package com.sanedge.interview.array_string;

import java.util.ArrayList;
import java.util.List;

public class Fulljustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + word.length() + line.size() > maxWidth) {
                if (line.size() == 1) {
                    result.add(line.get(0) + " ".repeat(maxWidth - lineLength));
                } else {
                    int totalSpaces = maxWidth - lineLength;
                    int spacesBetweenWords = line.size() - 1;
                    int extraSpaces = totalSpaces % spacesBetweenWords;
                    int spacesPerWord = totalSpaces / spacesBetweenWords;

                    StringBuilder formattedLine = new StringBuilder();

                    for (int i = 0; i < line.size(); i++) {
                        formattedLine.append(line.get(i));

                        if (i < line.size() - 1) {
                            formattedLine.append(" ".repeat(spacesPerWord));

                            if (extraSpaces > 0) {
                                formattedLine.append(" ");
                                extraSpaces--;
                            }
                        }
                    }
                    result.add(formattedLine.toString());
                }
                line.clear();
                lineLength = 0;
            }
            line.add(word);
            lineLength += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", line));
        lastLine.append(" ".repeat(maxWidth - lastLine.length()));
        result.add(lastLine.toString());

        return result;
    }
}
