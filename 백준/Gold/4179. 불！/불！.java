import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, jx, jy;
    static LinkedList<Integer> fx, fy;
    static String In[];
    static int In2[];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static String map[][];
    static boolean visited[][];
    public static void main(String[] args)    throws IOException {
        In2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In2[0];
        M = In2[1];
        fx = new LinkedList<>();
        fy = new LinkedList<>();
        map = new String[N+1][M+1];
        visited = new boolean[N+1][M+1];
        boolean flag = false;
        for(int i=0;i<N;i++) {
            In = br.readLine().split("");
            for(int j=0;j<In.length;j++) {
                map[i][j] = In[j];
                if (In[j].equals("J")) {
                    jx = i;
                    jy = j;
                } else if (In[j].equals("F")) {
                    fx.add(i);
                    fy.add(j);
                }
            }
        }
        Queue<Move> q = new LinkedList<>();
        for(int i=0;i<fx.size();i++) {
            q.add(new Move(fx.get(i), fy.get(i), "F", 0));
        }
        q.add(new Move(jx, jy, "J", 0));
        while (!q.isEmpty()) {
            Move cur = q.poll();
            visited[cur.x][cur.y] = true;
            if (cur.val == "J" && (cur.x == N-1 || cur.y == M-1 || cur.x == 0 || cur.y == 0)) {
                bw.write(cur.cnt+1 + "\n");
                flag = true;
                break;
            }
            for(int i=0;i<4;i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == null ||
                    map[nx][ny].equals("#") || !map[nx][ny].equals(".") || visited[nx][ny])
                    continue;
                if (cur.val.equals("F")) {
                    map[nx][ny] = "F";
                    q.add(new Move(nx, ny, "F", cur.cnt+1));
                } else {
                    map[nx][ny] = "J";
                    q.add(new Move(nx, ny, "J", cur.cnt+1));
                }
            }
        }
        if (!flag) {
            bw.write("IMPOSSIBLE\n");
        }
        bw.flush();
        bw.close();
    }

    public static class Move {
        int x;
        int y;
        String val;
        int cnt;
        public Move(int x, int y, String val, int cnt) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static void print() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}