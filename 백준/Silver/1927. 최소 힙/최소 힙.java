import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, T;
    static int In[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args)    throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(x);
            }
        }

        bw.flush();
        bw.close();
    }
}