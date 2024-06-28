import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        findCombinations(0, candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates
            if (i > ind && arr[i] == arr[i - 1]) continue;
            
            // Break if the element is greater than the remaining target
            if (arr[i] > target - sum) break;
            
            ds.add(arr[i]);
            findCombinations(i + 1, arr, target, ans, ds, sum + arr[i]);
            ds.remove(ds.size() - 1); // Backtrack
        }
    }
}
