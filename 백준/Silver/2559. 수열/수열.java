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
        int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // long N = Long.parseLong(br.readLine());
        // int N = Integer.parseInt(br.readLine());
        int N = arr[0];
        int windowSize = arr[1];
        int []arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ret = Integer.MIN_VALUE;
        int prefix[] = new int[N+1];
        prefix[0] = arr2[0];
        for(int i=1;i<arr2.length;i++) {
            prefix[i] = prefix[i-1] + arr2[i];
        }
        for(int i=windowSize-1;i<N;i++) {
            if(i == windowSize-1) {
                ret = Math.max(ret, prefix[i]);
            } else {
                ret = Math.max(ret, prefix[i] - prefix[i-windowSize]);
            }
        }
        bw.write(ret + "\n");
        bw.flush();
    }
}