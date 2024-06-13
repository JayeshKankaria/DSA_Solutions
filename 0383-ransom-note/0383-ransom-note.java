class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char ch : magazine.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }
        return map.isEmpty();
    }
}
