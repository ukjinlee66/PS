import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        Arrays.sort(In);
        int start = 1;
        int end = In[N-1];
        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for(int i=0;i<N;i++) {
                sum += Math.min(mid, In[i]);
            }
            if (sum > M) {
                end = mid -1;
            } else {
                start = mid + 1;
                ret = mid;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}