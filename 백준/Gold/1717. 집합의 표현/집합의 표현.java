import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int parent[] = new int[1000001];
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int []arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        for (int i = 0; i <= N; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            int op = arr[0];
            int a = arr[1];
            int b = arr[2];
            if (op == 0) {
                if (a != b){
                    merge(a, b);
                }
            } else {
                if (a == b) {
                    bw.write("YES\n");
                    continue;
                }
                if (find(a) == find(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static int find(int vertex) {
        if (parent[vertex] < 0) return vertex;
        parent[vertex] = find(parent[vertex]);
        return parent[vertex];
    }

    public static void merge(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parent[p1] += parent[p2]; // root size
        parent[p2] = p1;
    }
}