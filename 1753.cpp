#include<cstdio> //다익스트라
#include<vector>
#include<queue>
#include<algorithm>
#include<functional>
#include<utility>
using namespace std;
const int MAX_V = 20000;
const int INF = 1000000000;
int V, E, K;
typedef pair<int, int> P;
int main()
{
	scanf("%d %d %d", &V, &E,&K);
	vector<P> adj[MAX_V];
	K--;
	for (int i = 0; i < E; i++) {
		int u, v, w;
		scanf("%d %d %d", &u, &v, &w);
		adj[u - 1].push_back(P(v - 1, w)); //(이어진 정점,비용 이 담긴다.)
	}
	int dist[MAX_V];
	fill(dist, dist + MAX_V, INF); //처음 초기화.
	bool visit[MAX_V] = { NULL }; //초기화.
	priority_queue<P, vector<P>, greater<P>> PQ;
	
	dist[K] = 0; //시작점으로 거리는 0
	PQ.push(P(0, K)); //시작점만 PQ에 넣고 시작.
	while (!PQ.empty())
	{
		int curr;
		do {
			curr = PQ.top().second;
			PQ.pop();
		} while (!PQ.empty() && visit[curr]); //curr 가 방문한 정점이라면 무시.
		//더 이상 방문할 수 있는 정점이 없으면 종료.
		if (visit[curr]) break;

		visit[curr] = true;
		for (auto &p : adj[curr]) {
			int next = p.first, d = p.second;
			//거리가 갱신될 경우 PQ에 새로넣음
			if (dist[next] > dist[curr] + d) {
				dist[next] = dist[curr] + d;
				PQ.push(P(dist[next], next));
			}
		}
	}

	//결과
	for (int i = 0; i < V; i++)
	{
		if (dist[i] == INF)
			puts("INF");
		else printf("%d\n", dist[i]);
	}
}