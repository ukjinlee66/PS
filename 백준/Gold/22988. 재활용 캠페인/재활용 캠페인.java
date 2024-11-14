import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long ret;
    static int N;
    static long K;
    static long In[];

    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        N = (int)In[0];
        K = In[1];
        In = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(In);
        int s = 0;
        int e = N-1;
        ret = 0;
        int remain = 0;
        while(s<=e) {
            if (In[e] == K) {
                ret++;
                e--;
                continue;
            }
            if (s==e) {
                remain++;
                break;
            }
            if (In[s] + In[e] >= (K/2.0)) {
                ret++;
                s++;
                e--;
            } 
            else {
                remain++;
                s++;
            }
        }
        ret+= (long)(remain/3);
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}