import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int map[][];
    static boolean visited[][];
    static Queue<Pair> q;
    static Queue<Pair> tempQ;
    static int totalCnt = 0;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,1,-1};
    static int answer = 0;
        public static void main(String[] args)    throws IOException {
            int []in2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = in2[0];
            N = in2[1];
            map = new int[N][M];
            visited = new boolean[N][M];
            q = new LinkedList<Pair>();


            for(int i=0;i<N;i++) {
                int []in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int j=0;j<in.length;j++) {
                    map[i][j] = in[j];
                    if (in[j] == 1)
                        q.add(new Pair(i,j));
                    else if (in[j] == 0)
                        totalCnt++;
                }
            }
            
            while(!q.isEmpty()) {
                tempQ = new LinkedList<Pair>();
                tempQ.addAll(q);
                q.clear();
                while(!tempQ.isEmpty()) {
                    Pair current = tempQ.poll();
                    int x = current.x;
                    int y = current.y;

                    for(int i=0;i<4;i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] == true || map[nx][ny] == -1 || map[nx][ny] == 1)
                            continue;
                        visited[nx][ny] = true;
                        totalCnt--;
                        map[nx][ny] = 1;
                        q.add(new Pair(nx,ny));
                    }
                }
                if(!q.isEmpty())
                    answer++;
            }
            if (totalCnt == 0)
                bw.write(answer + "\n");
            else
                bw.write("-1\n");

            bw.flush();
            bw.close();
        }
        public static class Pair {
            int x;
            int y;
            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
}