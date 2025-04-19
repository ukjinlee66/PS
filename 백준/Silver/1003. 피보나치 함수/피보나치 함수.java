import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static pair dp[];
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            N = Integer.parseInt(br.readLine());
            while(N > 0) {
                N--;

                int num = Integer.parseInt(br.readLine());
                
                dp = new pair[num+1];
                for(int i=0;i<=num;i++)
                    dp[i] = new pair();
                pair res = sol(num);
                bw.write(res.zero  + " " + res.one + "\n");
            }
            bw.flush();
            bw.close();
        }
        public static pair sol(int n) {
            if (dp[n].one != -1 && dp[n].zero != -1)
                return dp[n];
            if (n == 1) {
                return new pair(0,1);
            }
            if (n == 0) {
                return new pair(1,0);
            }
            dp[n] = new pair(0,0);
            dp[n] = Sum(sol(n-1),sol(n-2));
            return dp[n];
        }

        public static pair Sum(pair a, pair b) {
            pair New = new pair(0,0);
            New.zero = a.zero + b.zero;
            New.one = a.one + b.one;
            return New;
        }

        public static class pair {
            int zero;
            int one;

            public pair(int zero, int one) {
                this.zero = zero;
                this.one = one;
            }
            
            public pair() {
                this.zero = -1;
                this.one = -1;
            }

        }
}