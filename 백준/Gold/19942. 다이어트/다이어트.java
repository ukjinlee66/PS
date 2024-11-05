import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int map[][];
    static String retPath;
    static int N;
    static boolean visited[];
    static int A,B,C,D;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][5];
        visited = new boolean[N];
        ret = Integer.MAX_VALUE;
        int In[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        A = In[0];
        B = In[1];
        C = In[2];
        D = In[3];
        for(int i=0;i<N;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<In.length;j++) {
                map[i][j] = In[j];
            }
        }
        for(int i=0;i<N;i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            Solution(i, visited, map[i][0], map[i][1], map[i][2], map[i][3], map[i][4], (i+1)+ " ");
        }
        if (ret == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(ret + "\n");
            bw.write(retPath + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void Solution(int idx, boolean visited[], int a, int b, int c, int d, int cost, String path) {
        if (a >= A && b >= B && c >= C && d >= D) {
            if (cost < ret) {
                ret = cost;
                retPath = path;
            }
            return;
        }
        for(int i=idx+1;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                Solution(i, visited, a+map[i][0], b+map[i][1], c+map[i][2], d+map[i][3], cost+map[i][4], path + (i+1) + " ");
                visited[i] = false;
            }
        }
    }
}