import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long dp[];
    static int dist[];
    static int cost[];
        public static void main(String[] args)    throws IOException {
            
            N = Integer.parseInt(br.readLine());
            
            dist = new int[N];
            dp = new long[N];
            cost = new int[N];

            Arrays.fill(dp, Integer.MAX_VALUE);
            dist = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp[0] = dist[0]*cost[0]; // init value
            for(int i=1;i<N;i++) {
                if (i != N-1)
                    dp[i] = Math.min(Math.min(dp[i-1] + cost[i]*dist[i], dp[i-1] + cost[i-1]*dist[i]), dp[i]);
                else
                    dp[i] = dp[i-1];
            }
            
            bw.write(dp[N-1] + "\n");
            bw.flush();
            bw.close();
        }
}