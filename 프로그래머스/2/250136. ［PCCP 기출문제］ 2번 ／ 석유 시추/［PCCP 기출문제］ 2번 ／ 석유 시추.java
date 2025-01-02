import java.util.*;
class Solution {
    static int visited[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static int cnt = 0;
    static HashMap<Integer,Integer> oilCnt = new HashMap<Integer, Integer>();
    static int map[][];
    static boolean check[];
    public int solution(int[][] land) {
        int answer = 0;
        visited = new int[land.length][land[0].length];
        map = land;
        for(int i=0;i<land.length;i++)
            Arrays.fill(visited[i],-1);
        int index = 1;
        for(int i=0;i<land.length;i++) {
            for(int j=0;j<land[i].length;j++) {
                if (land[i][j] == 1 && visited[i][j] == -1){
                    cnt = 0;
                    visited[i][j] = index;
                    DFS(i,j,index);
                    oilCnt.put(index++, cnt);
                }
            }
        }
        for(int j=0;j<land[0].length;j++) {
            cnt = 0;
            check = new boolean[index];
            for(int i=0;i<land.length;i++) {
                if (visited[i][j] != -1 && !check[visited[i][j]]) {
                    check[visited[i][j]]=true;
                    cnt+=oilCnt.get(visited[i][j]);
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    
    public void DFS(int x, int y, int index) {
        cnt++;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length ||
               visited[nx][ny] != -1 || map[nx][ny] == 0)
                continue;
            if (visited[nx][ny] == -1) {
                visited[nx][ny] = index;
                DFS(nx,ny,index);
            }
        }
    }
}