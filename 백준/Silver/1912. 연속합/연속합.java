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
        // int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // long N = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        // int N = arr[0];
        int []arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dp[] = new int[N+1];
        dp[0] = arr2[0]; // init
        int ret = arr2[0];
        for(int i=1;i<N;i++) {
            dp[i] = Math.max(dp[i-1] + arr2[i], arr2[i]);
            ret = Math.max(ret, dp[i]);
        }
        bw.write(ret + "\n");
        bw.flush();
    }
}