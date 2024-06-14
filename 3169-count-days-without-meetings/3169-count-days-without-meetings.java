class Solution {
    public int countDays(int days, int[][] meetings) 
    {
        if (meetings == null || meetings.length == 0) {
            return days; // If there are no meetings, all days are non-working days
        }
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int freedays=0;
        int lastday=0,start=0,end=0;
        for(int meeting[]:meetings)
        {
            start=meeting[0];
            end=meeting[1];
            if(start>lastday+1)
            {
                freedays+=start-lastday-1;
            }
            lastday=Math.max(lastday,end);
        }
        if(lastday<days)
        {
            freedays+=days-lastday;
        }
        return freedays;
    }
}