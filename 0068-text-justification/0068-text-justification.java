class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Greedily find how many words can fit in this line
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth)
                    break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;

            // If last line OR only one word → left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1)
                        sb.append(" ");
                }
                // Fill remaining spaces
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Middle justified
                int spaces = (maxWidth - totalChars) / diff;
                int extra = (maxWidth - totalChars) % diff;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        // Minimum 1 space + evenly distributed + extra if needed
                        int spaceCount = spaces + 1 + (i - index < extra ? 1 : 0);
                        for (int k = 0; k < spaceCount; k++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            index = last;
        }

        return result;
    }
}