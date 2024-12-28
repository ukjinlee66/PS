import java.util.*;
class Solution {
    static boolean visited[];
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        N = n;
        for(int i=0;i<n;i++) {
            if (!visited[i])
            {
                DFS(i,computers);
                answer++;
            }
        }
        return answer;
    }
    public void DFS(int x, int [][]computers) {
        visited[x]=true;
        for(int i=0;i<N;i++) {
            if(x==i) continue;
            if (computers[x][i] == 1 && !visited[i])
                DFS(i, computers);
        }
    }
}