import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int parent[] = new int[200001];
    static Map<String, Integer> person = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            Arrays.fill(parent, -1);
            person.clear();
            int cnt = 0;
            for (int j=0;j<F;j++) {
                String []arr = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
                if (!person.containsKey(arr[0])) {
                    person.put(arr[0], cnt++);
                }
                if (!person.containsKey(arr[1])) {
                    person.put(arr[1], cnt++);
                }
                merge(person.get(arr[0]), person.get(arr[1]));
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

    public static void merge(int v1, int v2) throws IOException {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) {
            bw.write(-parent[p1] + "\n");
            return;
        } 
        parent[p1] += parent[p2]; // root size
        parent[p2] = p1;
        bw.write(-parent[p1] + "\n");
    }
}