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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i=1;i<=N;i++) {
            parent[i] = -1;
        }
        for (int i=0;i<N;i++) {
            String str = br.readLine();
            int []arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0;j<N;j++) {
                int num = arr[j];
                if (num == 1) {
                    merge(i+1, j+1);
                }
            }
        }
        String str = br.readLine();
        int []arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        int root = find(arr[0]);
        boolean flag = true;
        for (int i=1;i<arr.length;i++) {
            if (root != find(arr[i])) {
                bw.write("NO\n");
                flag = false;
                break;
            }
        }
        
        if (flag) {
            bw.write("YES\n");
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