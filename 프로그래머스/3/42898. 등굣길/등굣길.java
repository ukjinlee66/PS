import java.util.*;
class Solution {
    static int MOD = 1000000007;
    static int dp[][];
    static int map[][];
    static int dx[] = {1,0};
    static int dy[] = {0,1};
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n][m];
        map = new int[n][m];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<puddles.length;i++) {
            int y = puddles[i][0] - 1;
            int x = puddles[i][1] - 1;
            map[x][y] = 1;
        }
        return Sol(0,0, n, m);
    }
    
    public static int Sol(int x, int y, int n, int m) {
        if (dp[x][y] != -1)
            return dp[x][y];
        
        if (x==n-1 && y==m-1)
            return 1;
        dp[x][y] = 0;
        for(int i=0;i<2;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >=m || map[nx][ny] == 1)
                continue;
            dp[x][y] += Sol(nx,ny,n,m) % MOD;
        }
        return dp[x][y] % MOD;
    }
}
