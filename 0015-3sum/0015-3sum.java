class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> st = new HashSet<>();
        Arrays.sort(arr); // Sort the array to handle duplicate triplets
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) 
                {
                    List<Integer> temp = Arrays.asList(arr[i], arr[left], arr[right]);
                    st.add(temp);
                    left++;
                    right--;
                } 
                else if (sum < 0) 
                {
                    left++;
                } 
                else 
                {
                    right--;
                }
            }
        }
        return new ArrayList<>(st);
    }
}