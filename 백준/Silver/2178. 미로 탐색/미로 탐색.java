import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static Queue<Pair> q = new LinkedList<>();
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int map[][] = new int[N[0]][N[1]];
        boolean visited[][] = new boolean[N[0]][N[1]];
        for(int i=0;i<N[0];i++) {
            int t[] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<t.length;j++) {
                map[i][j] = t[j];
            }
        }
        q.add(new Pair(0,0));
        visited[0][0]=true;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int curx = cur.x;
            int cury = cur.y;
            int cost = cur.cost;
            for(int n = 0; n < 4; n++) {
                int nextX = curx + dx[n];
                int nextY = cury + dy[n];
                if(nextX < 0 || nextY < 0 || nextX >= N[0] || nextY >= N[1] || visited[nextX][nextY] == true
                    || map[nextX][nextY] == 0)
                    continue;
                if(nextX == N[0]-1 && nextY == N[1]-1){
                    bw.write((cost+1) + "\n");
                    flag = true;
                    break;
                }
                q.add(new Pair(nextX, nextY, cost+1));
                visited[nextX][nextY] = true;
            }
            if (flag)
                break;
        }
        bw.flush();
        bw.close();
    }
    public static class Pair{
        int x;
        int y;
        int cost;
        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.cost = 1;
        }
    }
}