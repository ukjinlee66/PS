import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,M;
    static int In[];
    static LinkedList<LinkedList<Integer>> graph;
    static boolean visited[];
    static Queue<Integer> q;

    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new LinkedList<LinkedList<Integer>>();
        q = new LinkedList<Integer>();
        visited = new boolean[N];
        ret = 0;
        for(int i=0;i<N;i++) {
            graph.add(new LinkedList<Integer>());
        }

        for(int i=0;i<M;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(In[0]-1).add(In[1]-1);
            graph.get(In[1]-1).add(In[0]-1);
        }
        visited[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            LinkedList<Integer> cur = graph.get(q.poll());
            for(int i=0;i<cur.size();i++) {
                if (!visited[cur.get(i)]) {
                    visited[cur.get(i)] = true;
                    q.add(cur.get(i));
                    ret++;
                }
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}