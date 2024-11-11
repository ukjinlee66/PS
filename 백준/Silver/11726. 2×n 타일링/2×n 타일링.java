import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,K;
    static int dp[];
    static int In[];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=N+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 10007;
        }
        bw.write(dp[N+1] % 10007 + "\n");
        bw.flush();
        bw.close();
    }
}