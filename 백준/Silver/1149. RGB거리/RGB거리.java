import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,K;
    static int dp[][];
    static int In[][];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        In = new int[N][3];
        for(int i=0;i<N;i++) {
            int ar[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<3;j++) {
                In[i][j] = ar[j];
            }
        }
        dp = new int[N][3];
        dp[0][0] = In[0][0];
        dp[0][1] = In[0][1];
        dp[0][2] = In[0][2];

        for(int i=1;i<N;i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + In[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + In[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + In[i][2];
        }
        ret = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}