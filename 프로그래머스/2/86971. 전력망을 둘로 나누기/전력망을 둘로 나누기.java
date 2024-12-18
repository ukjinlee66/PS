class Solution {
    static boolean visited[];
    static int graph[][];
    static int N;
    public int solution(int n, int[][] wires) {
        int answer = 999999999;
        N = n;
        for(int i=0;i<wires.length;i++) {
            graph = new int[n][n];
            visited = new boolean[n];
            for(int j=0;j<wires.length;j++) {
                if (i==j)
                    continue;
                graph[wires[j][0]-1][wires[j][1]-1] = 1;
                graph[wires[j][1]-1][wires[j][0]-1] = 1;
            }
            int call=0;
            boolean flag =false;
            int sum = 0;
            for(int j=0;j<n;j++) {
                if (!visited[j]) {
                    call++;
                    visited[j] = true;
                    if (call==1)
                        sum+=DFS(j);
                    else{
                        if (call > 2)
                            break;
                        sum = Math.abs(sum-DFS(j));
                    }
                }
            }
            if (!flag) {
                answer = Math.min(sum,answer);
            }
        }
        return answer;
    }
    
    public int DFS(int x) {
        int ret = 1;
        for(int i=0;i<N;i++) {
            if (graph[x][i] == 1 && !visited[i]) {
                visited[i] = true;
                ret += DFS(i);
            }
        }
        return ret;
    }
}