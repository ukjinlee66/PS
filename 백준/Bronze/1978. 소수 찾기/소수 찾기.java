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
        int ret = 0;
        boolean pr[] = new boolean[1001];
        for(int i=2;i<1001;i++) {
            pr[i] = true;
        }
        for(int i=2;i*i<=1000;i++) 
        {
            if (pr[i] == true) {
                for(int j=i*i;j<=1000;j+=i){
                    pr[j]=false;
                }
            }
        }
        int []arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<arr.length;i++) {
            if(pr[arr[i]]) {
                ret++;
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}