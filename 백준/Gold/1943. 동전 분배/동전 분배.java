import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = Integer.MAX_VALUE;
    static int ret;
    static int N, M;
    static int In[];
    static int dp[][];
    static int sum;
    static ArrayList<Coin> coins;
    
    public static void main(String[] args)    throws IOException {
        for(int t=0;t<3;t++) {
            N = Integer.parseInt(br.readLine());
            sum = 0;
            coins = new ArrayList<>();
            
            for(int i=0;i<N;i++) {
                In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                coins.add(new Coin(In[0], In[1]));
                sum += In[0] * In[1];
            }
            dp = new int[N+1][(sum/2) + 1]; // 10, 50, 100, 500
            for(int i=0;i<N+1;i++) {
                Arrays.fill(dp[i], INF);
            }
            if (sum % 2 == 1) {
                bw.write("0\n");
                continue;
            }
            dp[0][0] = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<=sum/2;j++) {
                    if (dp[i][j] == INF) {
                        continue;
                    }
                    if (j+coins.get(i).value <= sum/2 && dp[i][j] < coins.get(i).cnt) {
                        dp[i][j+coins.get(i).value] = Math.min(dp[i][j+coins.get(i).value], dp[i][j] + 1);
                    }
                    dp[i+1][j] = 0;
                }
            }
            if (dp[N][sum/2] == 0) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        
        bw.flush();
        bw.close();
    }

    public static class Coin {
        int value;
        int cnt;
        public Coin(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
}
