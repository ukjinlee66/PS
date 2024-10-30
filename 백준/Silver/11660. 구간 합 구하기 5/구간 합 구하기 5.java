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
        int map[][] = new int[N+1][N+1];
        int prefixSum[][] = new int[N+1][N+1];
        int ret = 0;
        for(int i=0;i<N;i++) {
            int []ar = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<N;j++) {
                map[i][j] = ar[j];
            }
        }
        prefixSum[0][0] = map[0][0];
        prefixSum[1][0] = prefixSum[0][0] + map[1][0];
        prefixSum[0][1] = prefixSum[0][0] + map[0][1];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if (i==0 && j > 0) {
                    prefixSum[i][j] = prefixSum[i][j-1] + map[i][j];
                }
                else if (j==0 && i > 0) {
                    prefixSum[i][j] = prefixSum[i-1][j] + map[i][j];
                }
                else if (i > 0 && j > 0) {
                    prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + map[i][j];
                }
            }
        }
        for(int i=0;i<M;i++) {
            int []ar = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = ar[0]-1;
            int y1 = ar[1]-1;
            int x2 = ar[2]-1;
            int y2 = ar[3]-1;
            if (x1 == 0 && y1 == 0) {
                ret = prefixSum[x2][y2];
            }
            else if (x1 == 0 && y1 > 0) {
                ret = prefixSum[x2][y2] - prefixSum[x2][y1-1];
            }
            else if (x1 > 0 && y1 == 0) {
                ret = prefixSum[x2][y2] - prefixSum[x1-1][y2];
            }
            else if (x1 > 0 && y1 > 0) {
                ret = prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
            }
            bw.write(ret + "\n");
        }
        bw.flush();
    }
}