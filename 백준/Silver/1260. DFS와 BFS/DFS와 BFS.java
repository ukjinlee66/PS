import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = Integer.MAX_VALUE;
    static int ret;
    static int N,M,V;
    static int In[];
    static String str;
    static int zero, one;
    
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        V = In[2]-1;
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        for(int i=0;i<N;i++) {
            list.add(new LinkedList<>());
        }
        for(int i=0;i<M;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(In[0]-1).add(In[1]-1);
            list.get(In[1]-1).add(In[0]-1);
        }
        DFS(list, V);
        BFS(list, V);
        bw.flush();
        bw.close();
    }

    public static void DFS(LinkedList<LinkedList<Integer>> list, int s) throws IOException {
        boolean visited[] = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (!visited[cur]) {
                visited[cur] = true;
                bw.write(cur+1 + " ");
                Collections.sort(list.get(cur), Collections.reverseOrder());
                for(int i=0;i<list.get(cur).size();i++) {
                    int next = list.get(cur).get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
        bw.write("\n");
    } 

    public static void BFS(LinkedList<LinkedList<Integer>> list, int s) throws IOException {
        boolean visited[] = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur+1 + " ");
            Collections.sort(list.get(cur));
            for(int i=0;i<list.get(cur).size();i++) {
                int next = list.get(cur).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        bw.write("\n");
    } 
}