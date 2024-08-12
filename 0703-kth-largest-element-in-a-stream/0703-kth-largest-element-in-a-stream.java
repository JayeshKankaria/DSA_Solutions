class KthLargest 
{
    private int min;
    PriorityQueue<Integer>minheap;
    public KthLargest(int k, int[] nums) 
    {
        min = k;
        minheap= new PriorityQueue<>();
        for(int n: nums)
        {
            if(minheap.size()<k)
                minheap.offer(n);
            else if(n > minheap.peek())
            {
                minheap.offer(n);
                if (minheap.size() > k) 
                    minheap.poll();   
            }
        }
    }
    
    public int add(int val) 
    {
        if(minheap.size()<min)
        {
            minheap.offer(val);
        }
        else if(minheap.peek()< val)
        {
            minheap.offer(val);
            minheap.poll();
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */