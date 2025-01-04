import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++)
            pq.add(scoville[i]);
        while(pq.peek() < K) {
            int cur1 = pq.poll();
            if (pq.peek() == null)
                return -1;
            int cur2 = pq.poll();
            pq.add(cur1+(cur2*2));
            answer++;
        }
        return answer;
    }
}