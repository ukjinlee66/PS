import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long dist[];
    static long cost[];
    static long curMinCost;
    static long ans;
        public static void main(String[] args)    throws IOException {
            
            N = Integer.parseInt(br.readLine());
            
            dist = new long[N];
            ans = 0;
            cost = new long[N];

            dist = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            cost = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            curMinCost = cost[0];
            for(int i=0;i<N-1;i++) {
                curMinCost = Math.min(curMinCost, cost[i]);
                ans+= curMinCost * dist[i];
            }
            bw.write(ans + "\n");
            bw.flush();
            bw.close();
        }
}