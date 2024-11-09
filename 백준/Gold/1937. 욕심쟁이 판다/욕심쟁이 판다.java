import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,K;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int map[][];
    static int In[];
    static int dp[][];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        ret = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<N;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<N;j++) {
                map[i][j] = In[j];
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                ret = Math.max(ret,DFS(i,j));
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
    public static int DFS(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 1;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] <= map[x][y]) {
                continue;
            }
            dp[x][y] = Math.max(dp[x][y], DFS(nx,ny) + 1);
        }
        return dp[x][y];
    }

    static public void print() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
