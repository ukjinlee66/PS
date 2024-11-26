import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    static int map[];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ret = 0;
        int start = 1;
        int end = 100000;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid)) {
                ret = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }

    public static boolean isPossible(int mid) {
        if (M == 1 && In[0] + mid >= N && In[0] - mid <= 0) {
            return true;
        } else {
            // 가로등 사이 거리 확인
            boolean flag = false;
            for(int i=1;i<M;i++) {
                if (((In[i] - In[i-1]) / 2.0) <= mid) {
                    flag = true;
                } else {
                    return false;
                }
            }
            // 처음과 끝
            if (In[0] - mid <= 0 && In[M-1] + mid >= N) {
                flag = true;
            } else {
                return false;
            }
            return flag;
        }
    }
}