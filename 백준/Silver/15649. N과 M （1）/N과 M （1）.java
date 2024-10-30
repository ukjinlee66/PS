import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // long N = Long.parseLong(br.readLine());
        // int N = Integer.parseInt(br.readLine());
        int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        boolean visited[] = new boolean[N];
        int result[] = new int[M];

        permutation(result, 0, N, M, visited);


        bw.flush();
        bw.close();
    }

    public static void permutation(int[] result, int depth, int N, int M, boolean[] visited) throws IOException {
        if (depth == M) {
            for(int i=0;i<M;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i+1;
                permutation(result, depth+1, N, M, visited);
                visited[i] = false;
            }
        }
    }

    public static void permutation(int[] result, int depth, int N, int M) throws IOException {
        if (depth == M) {
            for(int i=0;i<M;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=0;i<N;i++) {
            result[depth] = i+1;
            permutation(result, depth+1, N, M);
        }
    }
}