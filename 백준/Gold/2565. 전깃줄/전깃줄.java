import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,K;
    static int LIS[];
    static int In[][];
    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        In = new int[N][2];
        for(int i=0;i<N;i++) {
            int ar[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<ar.length;j++) {
                In[i][j] = ar[j];
            }
        }
        Arrays.sort(In, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) 
                {
                    return -1;
                } else if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return 1;
                }
            }
        });
        LIS = new int[N];
        // 전체 전깃줄 개수 중 LIS 의 길이를 빼주면 끊어야하는 없애야하는 최소 전깃줄의 개수가 나옴.
        LIS[0] = In[0][1];
        int idx = 0;
        for(int i=1;i<N;i++) {
            if (LIS[idx] < In[i][1]) {
                LIS[++idx] = In[i][1];
            } else {
                int id = findIdx(0, idx, In[i][1]);
                LIS[id] = In[i][1];
            }
        }

        bw.write(N - (idx+1) + "\n");
        bw.flush();
        bw.close();
    }

    public static int findIdx(int start, int end, int value) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if (LIS[mid] < value) {
                start = mid + 1;
            } else if (LIS[mid] > value) {
                end = mid -1;
            } else {
                return mid;
            }
        }
        return start;
    }
}