class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedWithoutTechnique = 0;
        int additionalSatisfied = 0;
        int currentAdditional = 0;
        
        // Step 1: Calculate satisfied customers without technique
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedWithoutTechnique += customers[i];
            }
        }
        
        // Step 2: Use sliding window to find maximum additional satisfied customers
        // Initialize the first window
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditional += customers[i];
            }
        }
        additionalSatisfied = currentAdditional;
        
        // Slide the window
        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                currentAdditional -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                currentAdditional += customers[i];
            }
            additionalSatisfied = Math.max(additionalSatisfied, currentAdditional);
        }
        
        // Step 3: Return the sum
        return satisfiedWithoutTechnique + additionalSatisfied;
    }
}