import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int INF = Integer.MAX_VALUE;
    static int ret;
    static int N, M;
    static int In[];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int map[][];
    static int visited[][][];
    
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = In[0];
        M = In[1];
        ret = INF;
        map = new int[N][M];
        visited = new int[2][N][M];
        for(int i=0;i<N;i++) {
            In = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<M;j++) {
                map[i][j] = In[j];
                visited[0][i][j] = -1;
                visited[1][i][j] = -1;
            }
        }
        visited[0][0][0]=1;
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0,0, false));
        while(!q.isEmpty()) {
            Move m = q.poll();
            int status = m.use ? 1 : 0;
            if (m.x == N-1 && m.y == M-1) {
                ret = Math.min(ret,visited[status][m.x][m.y]);
            }
            for(int i=0;i<4;i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[status][nx][ny] != -1)
                    continue;
                if (map[nx][ny] == 1 && visited[1][nx][ny] == -1 && !m.use) {
                    visited[1][nx][ny] = visited[status][m.x][m.y] + 1;
                    q.add(new Move(nx,ny, true));
                } else if (map[nx][ny] == 0 && visited[status][nx][ny] == -1) {
                    visited[status][nx][ny] = visited[status][m.x][m.y] + 1;
                    q.add(new Move(nx,ny, m.use));
                }
            }
        }
        if (ret == INF)
        {
            bw.write("-1\n");
        } else {
            bw.write(ret + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static class Move {
        int x;
        int y;
        boolean use;
        public Move(int x, int y, boolean use) {
            this.x = x;
            this.y = y;
            this.use = use;
        }
    }
}