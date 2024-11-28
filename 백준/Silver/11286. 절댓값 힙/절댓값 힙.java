import java.io.*;
import java.util.*;
import java.util.Comparator;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, T;
    static int In[];
    public static void main(String[] args)    throws IOException {
        T = Integer.parseInt(br.readLine());
        Comp comp = new Comp();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
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
    public static class Comp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) < Math.abs(o2))
                return -1;
            else if (Math.abs(o1) == Math.abs(o2))
            {
                return Integer.compare(o1,o2);
            }
            return Integer.compare(Math.abs(o1),Math.abs(o2));
        }
    }
}