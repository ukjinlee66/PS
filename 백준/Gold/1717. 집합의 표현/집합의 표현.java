import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N, M;
    static int In[];
    static int par[];
    static int rank[];
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        par = new int[N + 1];
        rank = new int[N+1];
        for(int i=1;i<=N;i++)
            par[i] = i;

        for(int i=0;i<M;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (In[0] == 0) {
                union(In[1], In[2]);
            } else {
                if (find(In[1]) == find(In[2])) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    public static int find(int x) {
        if (par[x] == x)
            return x;
        else {
            par[x] = find(par[x]);
            return find(par[x]);
        }
    }

    public static void union(int x, int y) {

        int A = find(x);
        int B = find(y);
        if (A == B)
            return;
        else if (rank[x] > rank[y]) {
            par[B] = A;
        } else if (rank[x] < rank[y]) {
            par[A] = B;
        } else if (rank[x] == rank[y]) {
            par[B] = A;
            rank[A]++;
        }
    }
}