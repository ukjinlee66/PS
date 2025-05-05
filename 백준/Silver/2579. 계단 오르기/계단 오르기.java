import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int dp[];
    static int in[];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            N = Integer.parseInt(br.readLine());
            in = new int[N+1];
            dp = new int[N+1];
            for(int i=0;i<N;i++) {
                int temp = Integer.parseInt(br.readLine());
                in[i] = temp;
            }
            if(N < 3) {
                if (N == 1) 
                    bw.write(in[0]+"\n");
                else
                    bw.write(in[0]+in[1]+"\n");
            } else {
                dp[0] = in[0];
                dp[1] = in[0]+in[1];
                dp[2] = Math.max(in[0]+in[2], in[1]+in[2]);
                for(int i=3;i<N;i++) {
                    dp[i] = Math.max(dp[i-3]+in[i-1], dp[i-2]) + in[i];
                }
                bw.write(dp[N-1]+"\n");
            }
            bw.flush();
            bw.close();
        }
}