import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int M,N;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int map[][];
    static int In[];
    static int dp[][];
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = In[0];
        N = In[1];
        ret = 0;
        map = new int[M][N];
        dp = new int[M][N];
        for(int i=0;i<M;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<N;j++) {
                map[i][j] = In[j];
                dp[i][j] = -1;
            }
        }        
        DFSAndDP(0, 0);
        bw.write(dp[0][0] + "\n");
        bw.flush();
        bw.close();
    }
    static public int DFSAndDP(int x, int y) {
        if(x == M-1 && y == N-1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N || map[nx][ny] >= map[x][y])
                continue;
            dp[x][y] += DFSAndDP(nx, ny);
        }
        return dp[x][y];
    }

    static public void print() {
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}