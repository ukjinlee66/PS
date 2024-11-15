import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long ret;
    static int N,M;
    static int In[];

    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        ret = 0;
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(In);
        long s = 0;
        long e = In[N-1];
        while (s<=e) {
            long mid = (s+e)/2;
            long value = slice(mid);
            if (value >= M) {
                ret = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }

    public static long slice(long val) {
        long cost = 0;
        for(int i=0;i<N;i++) {
            if (In[i] > val) {
                cost += In[i] - val;
            }
        }
        return cost;
    }
}