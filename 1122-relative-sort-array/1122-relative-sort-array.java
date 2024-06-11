import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Count occurrences of each element in arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Initialize index for the result array
        int index = 0;

        // Place elements from arr2 into result array
        for (int num : arr2) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                arr1[index++] = num;
            }
            // Remove the element from the map once it's placed in result array
            countMap.remove(num);
        }

        // Place remaining elements in ascending order
        List<Integer> remainingElements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remainingElements.add(num);
            }
        }
        Collections.sort(remainingElements);

        // Place sorted remaining elements into result array
        for (int num : remainingElements) {
            arr1[index++] = num;
        }

        return arr1;
    }
}
