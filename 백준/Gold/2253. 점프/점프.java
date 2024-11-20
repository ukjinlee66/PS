import java.io.*;
import java.util.Arrays;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int ret;
        static int In[];
        static int N,M;
        static int map[];
        static int dp[][]; // 돌의 위치와 그때의 속도를 통해 현재 위치의 점프 횟수의 최소를 저장.
        static int dx[] = {-1,0,1};
    

        public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        map = new int[N];
        dp = new int[N][N/2 + 1];
        for(int i=0;i<N;i++) {
            Arrays.fill(dp[i], -1);
        }
        ret = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            map[i] = i;
        }
        for(int i=0;i<M;i++) {
            int k = Integer.parseInt(br.readLine());
            map[k-1] = -1;
        }
        if (map[1] == -1)
            ret = -1;
        else {
            ret = Sol(1, 1);
            if (ret == 100001) {
                ret = -1;
            }
        }
        bw.write(ret + "\n"); // 처음 속도는 1이다.
        bw.flush();
        bw.close();
    }

    public static int Sol(int x, int acc) {
        if (x == N-1)
            return 1;//도착
        
        if (dp[x][acc] != -1)
            return dp[x][acc];
        
        if (acc >= N)
            return 100001;
        dp[x][acc] = 100001;

        //현재 위치에서부터는 가속, 감속, 유지 세 가지 선택이 가능하다.
        for(int i=0;i<3;i++) {
            int nx = x + (dx[i] + acc);
            if (nx < 0 || nx >= N || map[nx] == -1 || (dx[i]+acc) <= 0) {
                continue;
            }
            dp[x][acc] = Math.min(dp[x][acc], Sol(nx, dx[i] + acc) + 1);
        }
        return dp[x][acc];
    }
}