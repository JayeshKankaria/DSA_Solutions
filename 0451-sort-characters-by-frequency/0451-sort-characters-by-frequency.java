class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (char c : count.keySet()) {
            int freq = count.get(c);
            buckets[freq].add(c);
        }

        StringBuilder res = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            for (char c : buckets[i]) {
                res.append(String.valueOf(c).repeat(i));
            }
        }

        return res.toString();
    }
}
