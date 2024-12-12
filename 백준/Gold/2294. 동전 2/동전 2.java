import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long LINF = Long.MAX_VALUE;
    static int INF = 1000000;
    static int ret;
    static int N,K;
    static int In[];
    static int dp[];
    static int coin[];
        public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        K = In[1];
        coin = new int[N];
        for(int i=0;i<N;i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[100001];
        Arrays.fill(dp, INF);
        Arrays.sort(coin);
        dp[0] = 0;
        for(int i=0;i<N;i++) {
            for(int j=coin[i];j<=K;j++) {
                dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }
        if(dp[K] == INF) {
            bw.write("-1\n");
        } else {
            bw.write(dp[K] + "\n");
        }
        bw.flush();
        bw.close();
    }
}