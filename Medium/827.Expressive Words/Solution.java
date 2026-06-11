class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) count++;
        }
        return count;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        int sLen = s.length(), wLen = word.length();

        while (i < sLen && j < wLen) {
            if (s.charAt(i) != word.charAt(j)) return false;

            int sCount = 1, wCount = 1;
            while (i + sCount < sLen && s.charAt(i + sCount) == s.charAt(i)) sCount++;
            while (j + wCount < wLen && word.charAt(j + wCount) == word.charAt(j)) wCount++;

            if (sCount < wCount) return false;
            if (sCount != wCount && sCount < 3) return false;

            i += sCount;
            j += wCount;
        }

        return i == sLen && j == wLen;
    }
}