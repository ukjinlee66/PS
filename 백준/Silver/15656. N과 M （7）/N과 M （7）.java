import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int arr[];
    static int ar[];
    static int result[];

    public static void main(String[] args) throws IOException {
        // long N = Long.parseLong(br.readLine());
        // int N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ar = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(ar);
        N = arr[0];
        M = arr[1];
        boolean[] visited = new boolean[N];
        result = new int[M];

        permutation(0,0);


        bw.flush();
        bw.close();
    }

    public static void permutation(int depth, boolean[] visited, int start) throws IOException {
        if (depth == M) {
            for(int i=0;i<M;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=start;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = ar[i];
                permutation(depth+1, visited, start+1);
                visited[i] = false;
            }
        }
    }

    public static void permutation(int depth, int start) throws IOException {
        if (depth == M) {
            for(int i=0;i<M;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0;i<N;i++) {
            result[depth] = ar[i];
            permutation(depth+1, i);
        }
    }

    public static void combination(int cnt, int start, boolean visited[]) throws IOException {
        if (cnt == M) {
            for(int i=0;i<N;i++) {
                if (visited[i]){
                    bw.write(ar[i] + " ");
                }
            }
            bw.write("\n");
            return;
        }
        if (start == N) {
            return;
        }
        visited[start] = true;
        combination(cnt+1, start + 1, visited);
        visited[start] = false;
        combination(cnt, start + 1, visited);
    }

    public static void combination(int idx, int cnt, int start) throws IOException {
        if (cnt == M) {
            for(int i=0;i<result.length;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        if (start == N) {
            return;
        }
        result[idx] = ar[start];
        combination(idx+1,cnt+1, start);
        combination(idx,cnt, start+1);
    }
}