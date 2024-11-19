import java.io.*;
import java.util.*;

    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static int V,E;
        static String str;
        static int ret;
        static int In[];
        static int dist[];
        static int start;
        static ArrayList<ArrayList<Node>> graph;
        static int INF = Integer.MAX_VALUE;
    

        public static void main(String[] args)    throws IOException {
        In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        V = In[0];
        E = In[1];
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        for(int i=0;i<V+1;i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++) {
            In = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(In[0]-1).add(new Node(In[1]-1, In[2]));
        }
        dist[start-1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.add(new Node(start-1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.number;
            if (graph.get(curNode).size() == 0) {
                continue;
            }
            for (Node node : graph.get(curNode)) {
                if (dist[node.number] > dist[curNode] + node.weight) {
                    dist[node.number] = dist[curNode] + node.weight;
                    node.weight = dist[node.number];
                    pq.add(node);
                }
            }
        }
        for(int i=0;i<V;i++) {
            if (dist[i] == INF)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static class Node {
        int number;
        int weight;
        public Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}