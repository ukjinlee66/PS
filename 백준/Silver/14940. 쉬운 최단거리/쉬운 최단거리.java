import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int In[];
    static int map[][];
    static int ret[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int startX, startY;
    public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = In[0];
        N = In[1];
        map = new int[M][N];
        ret = new int[M][N];
        for(int i=0;i<M;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<In.length;j++) {
                map[i][j] = In[j];
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        ret[startX][startY] = 0;
        boolean visited[][] = new boolean[M][N];
        Queue<Block> q = new LinkedList<>();
        visited[startX][startY] = true;
        q.add(new Block(startX, startY, 0));
        while (!q.isEmpty()) {
            Block cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for(int k=0;k<4;k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                ret[nx][ny] = cur.cnt+1;
                visited[nx][ny] = true;
                q.add(new Block(nx, ny, cur.cnt+1));
            }
        }
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    ret[i][j] = -1;
                }
                if (j != N-1)
                    bw.write(ret[i][j] + " ");
                else    
                    bw.write(ret[i][j] + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static class Block {
        int x;
        int y;
        int cnt;
        public Block(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}