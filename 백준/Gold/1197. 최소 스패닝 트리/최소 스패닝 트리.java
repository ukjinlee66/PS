import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    static int par[];
    static int rank[];
    static ArrayList<Edge> link = new ArrayList<>();
    public static void main(String[] args)    throws IOException {
        //MST -> 프림 알고리즘 -> 다익스트라 -> 트리(MST)
        //MST -> 크루스칼 알고리즘 -> 유니온파인드 -> 트리(MST)
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        ret = 0;
        for(int i=0;i<M;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = In[0];
            int b = In[1];
            int w = In[2];
            link.add(new Edge(a,b,w));
        }
        Collections.sort(link);
        par = new int[N+1];
        rank = new int[N+1];
        for(int i=1;i<=N;i++) {
            par[i] = i;
        }
        for(int i=0;i<link.size();i++) {
            int x = link.get(i).x;
            int y = link.get(i).y;
            int w = link.get(i).weight;
            if (find(x) != find(y)) {
                union(x,y);
                ret += w;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }

    public static int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }

    public static void union(int x, int y) {
        int A = par[x];
        int B = par[y];
        if (A==B)
            return;
        if (rank[A] < rank[B]) {
            par[A] = B;
        } else if (rank[B] < rank[A]) {
            par[B] = A;
        } else {
            par[A]=B;
            rank[B]++;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int weight;
        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o1) {
            return this.weight - o1.weight;
        }
    }
}