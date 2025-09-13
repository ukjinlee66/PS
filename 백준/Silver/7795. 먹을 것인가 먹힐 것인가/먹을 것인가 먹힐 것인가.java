import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
        public static void main(String[] args)    throws IOException {
                int T = Integer.parseInt(br.readLine());
                for(int t = 0; t< T;t++) {
                    int answer = 0;
                    int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    Arrays.sort(N);
                    Arrays.sort(M);
                    for(int i = N.length-1;i>=0;i--) {
                        for(int j=0;j<M.length;j++) {
                            if(N[i] <= M[j])
                                break;
                            answer++;
                        }
                    }
                    bw.write(answer+"\n");
                }
                bw.flush();
                bw.close();
            }
}