class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        var exactSet = new java.util.HashSet<String>();
        var caseMap = new java.util.LinkedHashMap<String, String>();
        var vowelMap = new java.util.LinkedHashMap<String, String>();

        for (var word : wordlist) {
            exactSet.add(word);
            var lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);
            var vowelKey = toVowelKey(lower);
            vowelMap.putIfAbsent(vowelKey, word);
        }

        var result = new String[queries.length];
        for (var i = 0; i < queries.length; i++) {
            var query = queries[i];
            if (exactSet.contains(query)) {
                result[i] = query;
            } else {
                var lower = query.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    result[i] = caseMap.get(lower);
                } else {
                    var vowelKey = toVowelKey(lower);
                    result[i] = vowelMap.getOrDefault(vowelKey, "");
                }
            }
        }
        return result;
    }

    private String toVowelKey(String word) {
        var sb = new StringBuilder();
        for (var ch : word.toCharArray()) {
            sb.append("aeiou".indexOf(ch) >= 0 ? '*' : ch);
        }
        return sb.toString();
    }
}