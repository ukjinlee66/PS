import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E;
    static long MOD = 1000000009L;
    static ArrayList<ArrayList<Node>> graph;
    static long[] dist, dp;
    static List<Integer>[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dist = new long[N];
        dp = new long[N];
        prev = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Long.MAX_VALUE;
            dp[i] = -1;
            prev[i] = new LinkedList<>();
        }

        dijkstra();

        System.out.println(countPaths(E));
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));
        dist[S] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.idx]) continue;

            for (Node next : graph.get(current.idx)) {
                if (dist[next.idx] > dist[current.idx] + next.cost) {
                    dist[next.idx] = dist[current.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                    prev[next.idx].clear();
                    prev[next.idx].add(current.idx);
                } else if (dist[next.idx] == dist[current.idx] + next.cost) {
                    prev[next.idx].add(current.idx);
                }
            }
        }
    }

    static long countPaths(int idx) {
        if (dp[idx] != -1) return dp[idx];
        if (idx == S) return 1;

        dp[idx] = 0;
        for (int pre : prev[idx]) {
            dp[idx] += countPaths(pre);
            dp[idx] %= MOD;
        }

        return dp[idx];
    }

    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}