import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int Ti[];
    static int Pi[];
    static int dp[];
    static int N;
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        Ti = new int[N];
        Pi = new int[N];
        dp = new int[N+1];
        for(int i=0;i<N;i++) {
            int ar[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Ti[i] = ar[0];
            Pi[i] = ar[1];
        }
        for(int i=0;i<N;i++) {
            if (Ti[i] + i <= N) { // N+1 일 퇴사하기 떄문에 N일까지 상담을 할 수 있다.
                // 현재 상담을 진행 가능하면
                dp[Ti[i]+i] = Math.max(dp[Ti[i]+i], dp[i] + Pi[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }
}