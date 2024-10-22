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
        for(int i=2;i<=N;i++) {
            while (N >= i) {
                if (N % i == 0) {
                    N /= i;
                    bw.write(i + "\n");
                } else {
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}