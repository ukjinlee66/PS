import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        if (m==1)
            return section.length;
        int end = 0;
        for(int i=0;i<section.length;i++) {
            if (end==0) {
                end = section[0]+m-1;
                answer++;
            }
            if (section[i] <= end)
                continue;
            else {
                answer++;
                end = section[i]+m-1;
            }
        }
        
        return answer;
    }
}