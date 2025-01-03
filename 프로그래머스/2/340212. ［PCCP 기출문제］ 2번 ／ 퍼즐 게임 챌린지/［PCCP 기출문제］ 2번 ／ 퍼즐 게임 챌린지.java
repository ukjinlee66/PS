import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        long start = 1;
        long end = 0;
        // limit 시간 내 퍼즐을 해결하기 위한 숙련도 최댓값
        // 가장 최소의 시간으로 퍼즐을 해결하기위한 숙련도는 diffs 의 최댓값
        for(int i=0;i<diffs.length;i++) {
            end = Math.max(end,diffs[i]);
        }
        while(start <= end) {
            long mid = (start + end) / 2;
            if (calculate(mid, diffs, times, limit)) {
                answer = (int)Math.min(answer, mid);
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return answer;
    }
    public boolean calculate(long level, int[] diffs, int[] times, long limit) {
        long time = times[0];
        for(int i=1;i<diffs.length;i++) {
            if (diffs[i] <= level) {
                time+=times[i];
            } else {
                time += (times[i] + times[i-1]) * (diffs[i]-level) + times[i];
            }
        }
        return time > limit ? false : true;
    }
}