import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,K;
    static Item items[];
    static int dp[][];
    static int In[];
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        K = In[1];
        ret = Integer.MIN_VALUE;
        dp = new int[N+1][K+1];
        items = new Item[N];
        for(int i=0;i<N;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            items[i] = new Item(In[0], In[1]);
            for(int j=0;j<=K;j++) {
                dp[i][j] = -1;
            }
        }
        bw.write(Solution(0, 0) + "\n");
        bw.flush();
        bw.close();
    }
    public static int Solution(int cnt, int weight) {
        
        if (weight > K) {
            return -9999;
        }
        if (dp[cnt][weight] != -1) {
            return dp[cnt][weight];
        }

        if (cnt == N) {
            return 0;
        }

        dp[cnt][weight] = Math.max(Solution(cnt+1, weight+items[cnt].weight) + items[cnt].value, Solution(cnt+1, weight));

        return dp[cnt][weight];

    }

    public static class Item {
        int weight;
        int value;
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}