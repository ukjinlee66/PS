import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        
        for (int i=2;i<=N-4;i+=2) {
            for (int j=1;j<=N-i;j++) {
                int k = N - i - j;
                if (j+2<=k) {
                    ret++;
                }
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}