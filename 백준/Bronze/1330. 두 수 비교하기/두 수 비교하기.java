import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        if (N < M) {
            bw.write("<" + "\n");
        } else if (N > M) {
            bw.write(">" + "\n");
        } else {
            bw.write("==" + "\n");
        }
        bw.flush();
        bw.close();
    }
}