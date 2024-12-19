import java.util.*;
class Solution {
    static int INF = 9999999;
    static int dist[];
    static int dist2[];
    static boolean visited[];
    static ArrayList<Node> graph[];
    static PriorityQueue<Node> pq;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        for(int i=0;i<n+1;i++)
            graph[i] = new ArrayList<>();
        
        for(int i=0;i<fares.length;i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int dis = fares[i][2];
            graph[from].add(new Node(to, dis));
            graph[to].add(new Node(from, dis));
        }
        
        pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        int []S = dijstra(s,n);
        int []A = dijstra(a,n);
        int []B = dijstra(b,n);
        
        for(int i=1;i<=n;i++) {
            answer = Math.min(answer , S[i]+A[i]+B[i]);
        }
        return answer;
    }
    public class Node {
        int index;
        int weight;
        int cost;
        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
    
    public int[] dijstra(int s, int n) {
        pq.clear();
        visited = new boolean[n+1];
        dist2 = new int[n+1];
        Arrays.fill(dist2, INF);
        
        dist2[s] = 0;
        pq.add(new Node(s,0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int index = cur.index;
            int weight = cur.weight;
            if(visited[index])
                continue;
            visited[index]=true;
            for(Node node : graph[index]) {
                if (dist2[node.index] > dist2[index] + node.weight) {
                    dist2[node.index] = dist2[index] + node.weight;
                    pq.add(new Node(node.index, dist2[node.index]));
                }
            }
        }
        return dist2;
    }
}