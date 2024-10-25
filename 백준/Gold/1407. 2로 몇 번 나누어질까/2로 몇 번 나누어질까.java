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
        long []arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        // int N = Integer.parseInt(br.readLine());
        long start = arr[0];
        long end = arr[1];
        long ret2 = 0;
        long ret = 0;
        if (start > 1 && start != end)
            ret2 = cal(start - 1);
        ret = cal(end) - ret2;
        bw.write(ret + "\n");
        bw.flush();
    }

    public static long cal(long n) {
        long ret = n;
        long mul = 1;
        if (n > 1) {
            for(long k = 2;k<=n;k*=2) {
                ret += (n / k)*mul;
                mul*=2;
            }
        }
        return ret;
    }
}