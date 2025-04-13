import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int dp[];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            N = Integer.parseInt(br.readLine());
            while(N > 0) {
                N--;
                int num = Integer.parseInt(br.readLine());
                dp = new int[num+1];
                Arrays.fill(dp, -1);
                bw.write(sol(num) + "\n");
            }
            bw.flush();
            bw.close();
        }
        public static int sol(int n) {
            if (n < 0)
                return 0;
            if (n == 0)
                return 1;
            if (dp[n] != -1)
                return dp[n];
            dp[n] = 0;
            dp[n] += sol(n-1) + sol(n-2) + sol(n-3);
            return dp[n];
        }
}