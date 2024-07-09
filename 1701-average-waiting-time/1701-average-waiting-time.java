class Solution {
    public double averageWaitingTime(int[][] customers) 
    {
        int n = customers.length;
        int i =0,curr_time=customers[0][0],time_prepare=0;
        double wait_time=0.0;
        while(i<n)
        {
            if(curr_time>=customers[i][0])
            {
                wait_time+=curr_time+customers[i][1] - customers[i][0];
                curr_time+=customers[i][1];
                i++;
            }
            else
                curr_time++;
        }
        return  wait_time/n;
    }
}