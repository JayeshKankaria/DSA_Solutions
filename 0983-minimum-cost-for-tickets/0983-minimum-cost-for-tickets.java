import java.util.*;

class Solution {
    private Map<Integer, Integer> dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new HashMap<>();
        return dfs(0, days, costs);
    }

    private int dfs(int i, int[] days, int[] costs) {
        if (i >= days.length) {
            return 0;
        }
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int minCost = Integer.MAX_VALUE;
        for (int d = 0; d < 3; d++) {
            int j = i;
            int duration = (d == 0) ? 1 : (d == 1) ? 7 : 30; // Corrected 15 to 30 for month pass
            while (j < days.length && days[j] < days[i] + duration) {
                j++;
            }
            minCost = Math.min(minCost, costs[d] + dfs(j, days, costs));
        }
        dp.put(i, minCost);
        return minCost;
    }
}
