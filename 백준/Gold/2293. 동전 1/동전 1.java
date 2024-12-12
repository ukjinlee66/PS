import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long LINF = Long.MAX_VALUE;
    static int INF = Integer.MAX_VALUE;
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
        dp[0] = 1;
        for(int i=0;i<N;i++) {
            for(int j=coin[i];j<=K;j++) {
                dp[j] += dp[j-coin[i]];
            }
        }
        bw.write(dp[K] + "\n");
        
        bw.flush();
        bw.close();
    }
}