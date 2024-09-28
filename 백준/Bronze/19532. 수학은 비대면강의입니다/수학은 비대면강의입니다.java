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
        int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // int N = Integer.parseInt(br.readLine());
        int retX = 0;
        int retY = 0;
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];
        int e = arr[4];
        int f = arr[5];

        for (int i=-999;i<=999;i++) {
            boolean flag = false;
            for(int j=-999;j<=999;j++) {
                if ((a*i + b*j) == c && d*i + e*j == f) {
                    bw.write(i + " " + j + "\n");
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}