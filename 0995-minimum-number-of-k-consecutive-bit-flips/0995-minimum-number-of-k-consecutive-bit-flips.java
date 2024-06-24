class Solution {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int ans = 0;
        int[] hasEverFlipped = new int[n];
        int validFlipCountForCurrentIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (i >= K) {
                validFlipCountForCurrentIdx -= hasEverFlipped[i - K];
            }
            if (validFlipCountForCurrentIdx % 2 == A[i]) {
                if (i + K > n) {
                    return -1;
                }
                validFlipCountForCurrentIdx++;
                hasEverFlipped[i] = 1;
                ans++;
            }
        }
        
        return ans;
    }
}
