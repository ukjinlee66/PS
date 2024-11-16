import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret[];
    static int N;
    static int In[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N];
        ret = new int[N];
        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<N-1;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(In[0]-1).add(In[1]-1);
            graph.get(In[1]-1).add(In[0]-1);
        }
        visited[0] = true;
        dfs(0);
        for(int i=1;i<N;i++) {
            bw.write(ret[i]+1 + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int start) throws IOException {
        for(int i=0;i<graph.get(start).size();i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                visited[next] = true;
                ret[next] = start;
                dfs(next);
            }
        }
        return ;
    }
}