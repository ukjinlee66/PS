import java.io.*;
import java.util.Arrays;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int ret;
        static int In[];
        static int N,M;
        static int dp[];
    

        public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        ret = 0;
        Arrays.fill(dp, -1);
        Sol(N);
        if (dp[N] >= 9999)
            dp[N] = -1;
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }
    public static int Sol(int x) {
        if (x < 0)
            return 9999;

        if (x == 0) 
            return 0;

        if (dp[x] != -1)
            return dp[x];
        dp[x] = 0;
        dp[x] = Math.min(Sol(x - 3) + 1, Sol(x - 5) + 1);
        return dp[x];
    }
}