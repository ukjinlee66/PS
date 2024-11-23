import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    static boolean visited[];
    static Queue<Jump> q = new LinkedList<>();
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        visited = new boolean[100001];
        ret = Integer.MAX_VALUE;
        q.offer(new Jump(In[0], 0));
        while (!q.isEmpty()) {
            Jump j = q.poll();
            visited[j.x] = true;
            if (j.x == M) {
                ret = Math.min(ret, j.cnt);
                continue;
            } else if (j.x < 0 || j.x > 100000) {
                continue;
            }
            if (j.x < M) {
                if (!visited[j.x+1])
                    q.offer(new Jump(j.x+1, j.cnt+1));
                if (j.x*2 <= 100000 && !visited[j.x*2])
                    q.offer(new Jump(j.x*2, j.cnt));
                if (j.x-1 >= 0 && !visited[j.x-1])
                    q.offer(new Jump(j.x-1, j.cnt+1));
            } else {
                if (j.x-1 >= 0 && !visited[j.x-1])
                    q.offer(new Jump(j.x-1, j.cnt+1));
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
    public static class Jump {
        int x;
        int cnt;
        public Jump(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}