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
        int K = arr[2];

        str = br.readLine();
        int []cost = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine();
            int []temp = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            merge(temp[0] - 1, temp[1] - 1, cost);
        }

        int sum = 0;
        for (int k = 0; k < N; k++) {
            if (parent[k] < 0) {
                sum += cost[k];
            }
        }
        if (sum <= K) {
            bw.write(sum + "\n");
        } else {
            bw.write("Oh no\n");
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

    public static void merge(int v1, int v2, int []cost) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parent[p1] += parent[p2]; // root size
        if (cost[p2] > cost[p1]) { // 두 root 중 저렴한 root를 선택
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }
}