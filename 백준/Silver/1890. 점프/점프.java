import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N;
    static int map[][];
    static int dx[] = {1,0};
    static int dy[] = {0,1};
    static int In[];
    static long dp[][];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for(int i=0;i<N;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<N;j++) {
                map[i][j] = In[j];
                dp[i][j] = -1;
            }
        }
        DP(0,0);
        bw.write(dp[0][0] + "\n");
        bw.flush();
        bw.close();
    }
    static public long DP(int x, int y) {
        if (dp[x][y] != -1)
            return dp[x][y];
        if (x == N-1 && y == N-1)
            return 1;
        dp[x][y] = 0;
        for(int i=0;i<2;i++) {
            int nx = x + (dx[i] * map[x][y]);
            int ny = y + (dy[i] * map[x][y]);
            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;
            dp[x][y] += DP(nx,ny);
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