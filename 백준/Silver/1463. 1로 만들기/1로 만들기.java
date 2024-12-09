import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = Integer.MAX_VALUE;
    static int ret;
    static int N,M;
    static int In[];
    static int dp[];
    static String str;
    static int zero, one;
    
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        if (N != 1) {
            Sol(N);
            bw.write(dp[N] + "\n");
        } else 
            bw.write("0\n");
        bw.flush();
        bw.close();
    }
    public static int Sol(int n) {
        if (n == 1) {
            return 0;
        }
        if (n < 1)
            return INF;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = Math.min((n % 2 == 0 ? Sol(n/2) : Sol(n-1)) + 1, (n % 3 == 0 ? Sol(n/3) : Sol(n-1)) + 1);
    }
}