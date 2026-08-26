class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = words[0].toLowerCase();
        
        java.util.Arrays.sort(words, java.util.Comparator.comparingInt(String::length).thenComparingInt(w -> 0));
        
        String[] wordsWithIndex = new String[words.length];
        String lower = text.toLowerCase();
        String[] original = lower.split(" ");
        
        record IndexedWord(String word, int index) {}
        
        var indexed = new IndexedWord[original.length];
        for (int i = 0; i < original.length; i++) {
            indexed[i] = new IndexedWord(original[i], i);
        }
        
        java.util.Arrays.sort(indexed, java.util.Comparator
            .comparingInt((IndexedWord iw) -> iw.word().length())
            .thenComparingInt(IndexedWord::index));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexed.length; i++) {
            if (i == 0) {
                String w = indexed[i].word();
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1));
            } else {
                sb.append(' ').append(indexed[i].word());
            }
        }
        
        return sb.toString();
    }
}