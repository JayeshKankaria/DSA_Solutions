import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) 
    {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) 
        {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        // Create a list of numbers from the array
        List<Integer> numList = new ArrayList<>();
        for (int n : nums) 
        {
            numList.add(n);
        }
        
        // Sort the list by frequency and then by number value
        Collections.sort(numList, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Sort by frequency
            } 
            else 
            {
                return b - a; // If frequencies are the same, sort by number value in descending order
            }
        });
        int[] sortedArray = numList.stream().mapToInt(Integer::intValue).toArray();
        return sortedArray;
    }
}
