import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000L * 100000L;
        Arrays.sort(times);
        long ret = -1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int i=0;i<times.length;i++) {
                cnt +=  mid / times[i];
            }
            if (cnt >= n)
            {
                ret = mid;
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return ret;
    }
}