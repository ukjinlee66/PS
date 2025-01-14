import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        //가능한 끈기지않게 구간을 찾아본 개수
        int answer = 0;
        Arrays.sort(targets,(t1,t2) -> t1[1] - t2[1]);
        int flag = 0;
        for(int i=0;i<targets.length;i++) {
            if (targets[i][0] >= flag) {
                answer++;
                flag = targets[i][1];
            }
        }
        return answer;
    }
}