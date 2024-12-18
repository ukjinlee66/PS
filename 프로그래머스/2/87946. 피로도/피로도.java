import java.util.*;
class Solution {
    static int [][]map;
    static boolean visited[];
    static int K;
    static int ans;
    public int solution(int k, int[][] dungeons) {
        ans = 0;
        K=k;
        map=dungeons;
        for(int i=0;i<dungeons.length;i++){
            visited = new boolean[9];
            if (K >=dungeons[i][0]){
                visited[i]=true;
                Sol(i, K-dungeons[i][1],1);
                // answer = Math.max(answer,);
            }
        }
        return ans;
    }
    public void Sol(int x, int k, int cnt) {
        if (k<=0)
        {
            ans = Math.max(ans, cnt);
            return;
        }
        for(int i=0;i<map.length;i++) {
            if (i==x)
                continue;
            if (!visited[i] && map[i][0] <= k) {
                visited[i]=true;
                Sol(i, k-map[i][1],cnt+1);
                visited[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
}