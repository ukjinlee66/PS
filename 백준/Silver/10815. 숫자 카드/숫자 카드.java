import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int In[], In2[];

    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        In2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(In);
        for(int i=0;i<M;i++) {
            boolean ret = Solution(0, N-1, In2[i]);
            if (ret) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            if (i != In2.length-1) {
                bw.write(" ");
            } else {
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean Solution(int s, int e, int val) {

        while (s<=e) {
            int mid = (s+e)/2;
            if (In[mid] > val) {
                e = mid - 1;
            } else if (In[mid] < val) {
                s = mid + 1;
            } else if (In[mid] == val) {
                return true;
            }
        }
        return false;
    }
}