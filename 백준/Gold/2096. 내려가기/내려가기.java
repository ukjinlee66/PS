import java.io.*;
import java.util.Arrays;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int ret;
        static int In[];
        static int N,M;
        static int map[][];
        static int dp[][];
        static int dp2[][];
    

        public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        dp = new int[N][3];
        dp2 = new int[N][3];
        for(int i=0;i<N;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<3;j++) {
                map[i][j] = In[j];
                if (i == 0) {
                    dp[i][j] = map[i][j];
                    dp2[i][j] = map[i][j];
                }
            }
        }
        for(int i=1;i<N;i++) {
            for(int j=0;j<3;j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]) + map[i][j];
                    dp2[i][j] = Math.min(dp2[i-1][j], dp2[i-1][j+1]) + map[i][j];
                } else if (j==1) {
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i-1][j+1])) + map[i][j];
                    dp2[i][j] = Math.min(dp2[i-1][j-1], Math.min(dp2[i-1][j], dp2[i-1][j+1])) + map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
                    dp2[i][j] = Math.min(dp2[i-1][j-1], dp2[i-1][j]) + map[i][j];
                }
            }
        }
        int max = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
        int min = Math.min(dp2[N-1][0], Math.min(dp2[N-1][1], dp2[N-1][2]));
        bw.write(max + " " + min + "\n");
        bw.flush();
        bw.close();
    }
}