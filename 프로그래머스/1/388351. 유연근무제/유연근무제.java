import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean[] checker = new boolean[schedules.length];
        Arrays.fill(checker, true);
        for(int i=0;i<timelogs[0].length;i++) {
            if(startday > 5)
            {
                if(startday >= 7)
                    startday%=7;
                startday++;
                continue;
            }
            for(int j=0;j<timelogs.length;j++) {
                if(checker[j]==true && timelogs[j][i] > getLimitSchedule(schedules[j])){
                    checker[j] = false;
                }
            }
            startday++;
        }
        for(int i=0;i<schedules.length;i++)
            if (checker[i] == true)
                answer++;
        return answer;
    }
    public int getLimitSchedule(int schedules) {
        int one = schedules / 100;
        int two = schedules % 100;
        if (two+10 > 59){
            two = two+10 - 60;
            one++;
            if (one == 24) 
                one = 0;
        } else {
            return schedules+10;
        }
        return (one*100) + two;
    }
}