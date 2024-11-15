import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,M;
    static int In[];
    static int map[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static boolean visited[][];
    static Queue<Point> q;

    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            String str[] = br.readLine().split("");
            for(int j=0;j<str.length;j++) {
                map[i][j] = str[j].equals("W") ? 0 : 1;
            }
        }
        // 각 대륙별 BFS로 순회 시 가장 멀리 있는 땅 까지의 횟수를 반환하여 가장 큰 값을 반환
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if (map[i][j] == 1)
                ret = Math.max(ret, BFS(i,j));
            }
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
    public static int BFS(int x,int y) {
        q = new LinkedList<>();
        int cnt = 0;
        visited = new boolean[N][M];
        q.add(new Point(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            cnt = Math.max(cnt, cur.cnt);
            for(int i=0;i<4;i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny,cur.cnt+1));
            }
        }
        return cnt;
    }

    public static class Point {
        int x;
        int y;
        int cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }
    }
}