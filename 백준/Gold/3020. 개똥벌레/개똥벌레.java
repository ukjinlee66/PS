import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int down[];
    static int up[];
    static int N,H;
    public static void main(String[] args)    throws IOException {
        int In[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        H = In[1];
        down = new int[H+2];
        up = new int[H+2];
        for(int i=0;i<N/2;i++) {
            int downHeight = Integer.parseInt(br.readLine());
            int upHeight = Integer.parseInt(br.readLine());
            down[downHeight]++;
            up[H-upHeight+1]++;
        }

        for(int i=1;i<=H;i++) {
            down[i] += down[i-1];
        }
        for(int i=H;i>=1;i--) {
            up[i] += up[i+1];
        }
        int ret = Integer.MAX_VALUE;
        int retcnt = 0;

        for(int i=1;i<=H;i++) {
            //높이별 개수 구하기
            int cnt = 0;
            cnt += down[H] - down[i-1];
            cnt += up[1] - up[i+1];
            if (ret > cnt) {
                ret = cnt;
                retcnt = 1;
            } else if (ret == cnt) {
                retcnt++;
            }
        }
        bw.write(ret + " " + retcnt + "\n");
        
        bw.flush();
        bw.close();
    }
}