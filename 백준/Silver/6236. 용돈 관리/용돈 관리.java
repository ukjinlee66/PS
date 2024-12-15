import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long LINF = Long.MAX_VALUE;
    static int INF = 1000000001;
    static int res;
    static int N,K;
    static int In[];
    static int day[];
        public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        K = In[1];
        day = new int[N];
        int maxnum = -1;
        int end = 0;
        for(int i=0;i<N;i++) {
            day[i] = Integer.parseInt(br.readLine());
            maxnum = Math.max(maxnum, day[i]);
            end += day[i];
        }
        int start = maxnum;
        while(start <= end) {
            int mid = (end + start) / 2;
            int ret = sol(mid);
            if (ret > 0) {
                start = mid + 1;
            } else {
                res = mid;
                end = mid - 1;
            }
        }
        bw.write(res + "\n");
        bw.flush();
        bw.close();
    }

    public static int sol(int m) {
        int money = m;
        int cnt = 1;
        for(int i=0;i<N;i++) {
            if (day[i] > money) {
                cnt++;
                money = m;
            }
            money -= day[i];
        }
        if (cnt <= K) {
            return 0;
        } else {
            return 1;
        }
    }
}