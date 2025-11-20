class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        HashSet<Integer> containingSet = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            int count = 0;
            for(int j : containingSet)
            {
                if(j >= intervals[i][0] && j <= intervals[i][1])
                    count++;
                if(count == 2)
                    break;
            }
            if(count >= 2)
            {
                continue;
            }
            else
            {
                ans += 2 - count;
                for(int j = intervals[i][1], x = 0; x < 2 - count; j--)
                {
                    if(containingSet.contains(j))
                        continue;
                    x++;
                    containingSet.add(j);
                }
            }
        }
        return ans;
    }
}