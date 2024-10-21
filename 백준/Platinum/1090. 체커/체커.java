import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(br.readLine());
        int XPoints[] = new int[N];
        int YPoints[] = new int[N];

        for (int i=0;i<N;i++) {
            int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            XPoints[i] = arr[0];
            YPoints[i] = arr[1];
        }

        int ret[] = sol(N, XPoints, YPoints);
        for (int i=0;i<N;i++) {
            if (i == N-1) {
                bw.write(ret[i] + "\n");
            }
            else {
                bw.write(ret[i] + " ");
            }
        }


        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] sol(int N, int[] XPoints, int[] YPoints) {
        int ret[] = new int[N];
        Arrays.fill(ret, Integer.MAX_VALUE);
        for (int x : XPoints) {
            for (int y : YPoints) {
                int dist[] = new int[N];
                int sum = 0;
                for (int k = 0;k<N;k++) {
                    dist[k] = Math.abs(x - XPoints[k]) + Math.abs(y - YPoints[k]);
                }
                Arrays.sort(dist);
                for (int k=0;k<N;k++) {
                    sum += dist[k];
                    ret[k] = Math.min(ret[k], sum);
                }
            }
        }
        return ret;
    }
}