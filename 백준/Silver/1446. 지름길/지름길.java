import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long LINF = Long.MAX_VALUE;
    static int INF = Integer.MAX_VALUE;
    static int ret;
    static int N,D;
    static int In[];
    static int dp[];
    static ArrayList<Node> list[];
        public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[10001];
        ret = INF;
        N = In[0];
        D = In[1];
        list = new ArrayList[10011];
        for(int i=0;i<=10001;i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dp, -1);
        for(int i=0;i<N;i++) {
            int start, dest, dist;
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            start = In[0];
            dest = In[1];
            dist = In[2];
            list[start].add(new Node(dest, dist));
        }
        sol(0);
        bw.write(dp[0]+"\n");
        bw.flush();
        bw.close();
    }

    public static int sol(int index) {
        if (index == D) {
            return 0;
        }
        if (index > D) {
            return 9999999;
        }
        if (dp[index] != -1)
            return dp[index];
        
        dp[index] = 9999999;
        if (list[index].size() > 0) {
            for(int i=0;i<list[index].size();i++) {
                dp[index] = Math.min(Math.min(sol(index+1) + 1, sol(list[index].get(i).dest)+list[index].get(i).dist),dp[index]);
            }
        } else {
                dp[index] = Math.min(dp[index], sol(index+1)+1);
        }
        return dp[index];
    }

    public static class Node {
        int dest;
        int dist;
        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }
    }
}