import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // long []arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        // long N = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long ret = 0;
        for(int i=2;i<N;i++) {
            ret += ((N/i-1) * i);
        }
        System.out.println(ret % 1000000);
    }
}