import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int Input[];
    static int LIS[];
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        int v[] = new int[N];
        LIS = new int[N];
        LIS[0] = Input[0];
        for(int i=1;i<N;i++) {
            if (LIS[cnt] < Input[i]) {
                cnt++;
                LIS[cnt] = Input[i];
                v[i] = cnt;
            } else {
                int idx = findIdx(0, cnt, Input[i]);
                LIS[idx] = Input[i];
                v[i] = idx;
            }
        }
        bw.write((cnt+1) + "\n");
        Stack<Integer> stack = new Stack<>();
        for(int i=N-1;i>=0;i--) {
            if (v[i] == cnt) {
                stack.push(Input[i]);
                cnt--;
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
    }

    public static int findIdx(int start, int end, int value) {
        while(start < end) {
            int mid = (start + end) / 2;
            if (value <= LIS[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}