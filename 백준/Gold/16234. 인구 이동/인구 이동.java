import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int L = arr[1];
        int R = arr[2];
        int map[][] = new int[N + 1][N + 1];
        int visited[][] = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int ret = 0;
        while (true) {
            if (GoDfs(map, visited, N, L, R) == 0)
                break;
            ret++;
            // printMap(map, N);
            clearMap(visited, N);
        }
        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int checkMap(int[][] visited, int N, int L, int R) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void fillMap(int[][] map, boolean[][] visited, int N, int val) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    map[i][j] = val;
            }
        }
    }

    public static void clearMap(int[][] visited, int N) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], 0);
        }
    }

    public static void printMap(int [][]map, int N) {
        System.out.println("----------------------------------");
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    public static int GoDfs(int[][] map, int[][] visited, int N, int L, int R) {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    int sum = DFS(map, visited, N, L, R, i, j, 1);
                    if (sum != 0) {
                        fillDFS(map, visited, N, L, R, i, j, sum / checkMap(visited, N, L, R));
                        flag = true;
                    }
                }
            }
        }
        return flag ? 1 : 0;
    }

    public static int DFS(int[][] map, int[][] visited, int N, int L, int R, int x, int y, int deps) {
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { 1, -1, 0, 0 };
        int sum = map[x][y];
        visited[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < N
                    && ny >= 0 && ny < N && visited[nx][ny] == 0 && Math.abs(map[x][y] - map[nx][ny]) >= L
                    && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                sum += DFS(map, visited, N, L, R, nx, ny, deps+1);
            }
        }
        if (deps == 1 && sum == map[x][y]) {
            visited[x][y] = 0;
            return 0;
        }
        return sum;
    }

    public static void fillDFS(int[][] map, int[][] visited, int N, int L, int R, int x, int y, int newVal) {
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        visited[x][y] = 2;
        map[x][y] = newVal;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == 1) {
                fillDFS(map, visited, N, L, R, nx, ny, newVal);
            }
        }
    }
}