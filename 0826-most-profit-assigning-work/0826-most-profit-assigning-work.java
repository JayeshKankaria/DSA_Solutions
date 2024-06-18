class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // Sort jobs by difficulty

        int maxProfit = 0;
        int maxProfitAtThisLevel = 0;
        for (int w : worker) {
            int currMaxProfit = 0;
            for (int[] job : jobs) {
                if (job[0] <= w) {
                    currMaxProfit = Math.max(currMaxProfit, job[1]);
                }
            }
            maxProfit += currMaxProfit;
        }
        return maxProfit;
    }
}