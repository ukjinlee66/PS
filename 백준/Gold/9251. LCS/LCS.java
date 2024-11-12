import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static String N,M;
    static int dp[][];
    public static void main(String[] args)    throws IOException {
        M = br.readLine();
        N = br.readLine();
        dp = new int[N.length()+2][M.length()+2];
        
        dp[0][0] = 0;
        for(int i=1;i<=N.length();i++) {
            for(int j=1;j<=M.length();j++) {
                if (N.charAt(i-1) == M.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        ret = 0;
        for(int i=0;i<=N.length();i++) {
            for(int j=0;j<=M.length();j++) {
                ret = Math.max(ret, dp[i][j]);
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}