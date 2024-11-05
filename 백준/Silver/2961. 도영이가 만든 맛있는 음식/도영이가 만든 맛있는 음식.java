import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int map[][];
    static boolean visit[];
    static long ret;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Taste ar[] = new Taste[N];
        visit = new boolean[N];
        for(int i=0;i<N;i++) {
            int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ar[i] = new Taste(a[0], a[1]);
        }
        ret = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++) {
            Arrays.fill(visit, false);
            Solution(ar,0,i, 1,0, visit);
        }
        
        
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }

    public static class Taste {
        //sourness(신맛) *,bitterness(쓴맛) +
        int sour;
        int bitt;
        public Taste(int sour, int bitt) {
            this.sour = sour;
            this.bitt = bitt;
        }
    }
    public static void Solution(Taste ar[], int cnt, int pick, long sour, long bitt, boolean visit[]) {
        if (cnt == pick) {
            ret = Math.min(Math.abs(sour-bitt), ret);
        }
        for(int i=0;i<ar.length;i++) {
            if(!visit[i]) {
                visit[i] = true;
                Solution(ar, cnt+1, pick, sour * ar[i].sour, bitt + ar[i].bitt, visit);
                visit[i] = false;
            }
        }
    }
}