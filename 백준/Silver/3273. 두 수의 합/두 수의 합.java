import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,M;
    static int In[];

    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(In);
        M = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start = 0;
        int end = In.length-1;
        while (start < end) {
            if (In[start] + In[end] == M) {
                cnt++;
                start++;
                end--;
            } else if (In[start] + In[end] < M) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}