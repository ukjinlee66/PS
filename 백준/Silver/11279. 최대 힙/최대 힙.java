import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, T;
    static int In[];
    public static void main(String[] args)    throws IOException {
        T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
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