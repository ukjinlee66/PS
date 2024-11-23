import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    static int visited[];
    static Queue<Jump> q = new LinkedList<>();
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        visited = new int[100001];
        Arrays.fill(visited, -1);
        ret = Integer.MAX_VALUE;
        q.offer(new Jump(In[0], 0));
        visited[N] = N;
        while (!q.isEmpty()) {
            Jump j = q.poll();
            if (j.x == M) {
                bw.write(j.cnt + "\n");
                int start = j.x;
                ArrayList<Integer> list = new ArrayList<>();
                while (start != visited[N]) {
                    list.add(start);
                    start = visited[start];
                }
                list.add(N);
                Collections.reverse(list);
                for(int i=0;i<list.size();i++) {
                    bw.write(list.get(i) + " ");
                }
                bw.write("\n");
                break;
            } else if (j.x < 0 || j.x > 100000) {
                continue;
            }
            if (j.x < M) {
                if (visited[j.x+1] == -1) {
                    visited[j.x+1] = j.x;
                    q.offer(new Jump(j.x+1, j.cnt+1)); 
                }
                if (j.x*2 <= 100000 && visited[j.x*2] == -1) {
                    visited[j.x*2] = j.x;
                    q.offer(new Jump(j.x*2, j.cnt + 1));
                }
                if (j.x-1 >= 0 && visited[j.x-1] == -1) {
                    visited[j.x-1] = j.x;
                    q.offer(new Jump(j.x-1, j.cnt+1));
                }
            } else {
                if (j.x-1 >= 0 && visited[j.x-1] == -1) {
                    visited[j.x-1] = j.x;
                    q.offer(new Jump(j.x-1, j.cnt+1));
                }
            }
        }
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