import java.util.*;
class Solution {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean visited[][];
    static PriorityQueue<Node> q;
    public int solution(int[][] maps) {
        q  = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cnt - o2.cnt;
            }
        });
        q.add(new Node(0,0,1));
        visited = new boolean[maps.length][maps[0].length];
        visited[0][0]=true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == maps.length-1 && cur.y == maps[0].length-1) {
                return cur.cnt;
            }
            for(int i=0;i<4;i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >=maps.length || ny >= maps[0].length ||
                   maps[nx][ny] == 0 || visited[nx][ny])
                    continue;
                visited[nx][ny]=true;
                q.add(new Node(nx,ny,cur.cnt+1));
            }
        }
        return -1;
    }
    public class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x=x;
            this.y=y;
            this.cnt = cnt;
        }
        
    }
}