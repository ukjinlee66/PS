import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int eat[];
    static Integer dp[];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            N = Integer.parseInt(br.readLine());
            eat = new int[N+1];
            dp = new Integer[N+1];
            int t = 0;
            for(int K = 1; K < N+1;K++) {
                t = Integer.parseInt(br.readLine());
                eat[K] = t;
            }
            dp[0] = 0;
            dp[1] = eat[1];
            if(N > 1)
                dp[2] = eat[1]+eat[2];
            
            bw.write(sol(N)+"\n");
            bw.flush();
            bw.close();
        }
        public static int sol(int n) {
            if (dp[n] == null) {
                dp[n] = Math.max(Math.max(sol(n-2), sol(n-3)+eat[n-1]) + eat[n],sol(n-1));
            }
            return dp[n];
        }
}