import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int ret, ret2;
    static String In[];
    static String map[][];
    static int dx[] = {0, 1};
    static int dy[] = {1, 0};
    static boolean visited[][];

    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];
        ret = Integer.MIN_VALUE;
        ret2 = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            In = br.readLine().split(" ");
            for(int j=0;j<N;j++) {
                map[i][j] = In[j];
            }
        }
        visited[0][0] = true;
        DFS(0,0, "", Integer.parseInt(map[0][0]));
        bw.write(ret + " " + ret2 + "\n");
        bw.flush();
        bw.close();
    }

    public static void DFS(int x, int y, String p, int cost) {
        if (x == N-1 && y == N-1) {
            ret = Math.max(ret, cost);
            ret2 = Math.min(ret2, cost);
            return;
        }
        for(int i=0;i<2;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                continue;
            }
            if (!visited[nx][ny]) {
                if ((map[nx][ny].equals("+") || map[nx][ny].equals("-") || map[nx][ny].equals("*"))) {
                    // 가려는 곳이 연산자인 경우
                    visited[nx][ny] = true;
                    DFS(nx, ny, map[nx][ny], cost);
                    visited[nx][ny] = false;
                } else {
                    // 가려는 곳이 숫자인 경우
                    visited[nx][ny] = true;
                    switch(p) {
                        case "+":
                            DFS(nx, ny, "", cost + Integer.parseInt(map[nx][ny]));
                            break;
                        case "-":
                            DFS(nx, ny, "", cost - Integer.parseInt(map[nx][ny]));
                            break;
                        case "*":
                            DFS(nx, ny, "", cost * Integer.parseInt(map[nx][ny]));
                            break;
                    }
                    visited[nx][ny] = false;
                }
            }
        }
    }
}