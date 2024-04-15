import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int N = arr[0];
        int d = arr[1];
        int k = arr[2];
        int c = arr[3];

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int ret = 0;

        for (int i = 0; i < N; i++) {
            Set<Integer> eat = new HashSet<>();
            for (int j = 0; j < k; j++) {
                if (i + j >= N) {
                    eat.add(sushi[i + j - N]);
                } else {
                    eat.add(sushi[i + j]);
                }
            }
            eat.add(c);
            ret = Math.max(ret, eat.size());
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}