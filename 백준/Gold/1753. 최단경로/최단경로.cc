#include <iostream>
#include <cmath>
#include <algorithm>
#include <utility>
#include <queue>
#include <climits>
using namespace std;

//다익스트라

const int MAX_V = 20000;
const int INF = INT_MAX;
typedef pair<int, int> P;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int V, E, K;
	vector<P> adj[MAX_V]; // 인접 리스트
	cin>>V>>E>>K;
	K--;
	for(int i=0;i<E;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		adj[u-1].push_back(P(v-1,w));
	}

	int dist[MAX_V];
	int prev[MAX_V];
	fill(dist, dist+MAX_V, INF);
	fill(prev, prev+MAX_V, INF);
	bool visit[MAX_V] = {false};
	priority_queue<P, vector<P>, greater<P>> PQ;

	//다익스트라 알고리즘 시작
	dist[K] = 0; //시작점의 거리는 0
	PQ.push(P(0,K));
	while(!PQ.empty())
	{
		int cur;
		do
		{
			cur = PQ.top().second;
			PQ.pop();
		} while (!PQ.empty() && visit[cur]); //cur 방문정점일 경우 무시
		if(visit[cur]) break;

		visit[cur] = true; //방문 체크
		for (auto &p : adj[cur])
		{
			int next = p.first, d = p.second;
			//거리가 갱신될 경우 PQ에 새로 넣음
			if(dist[next] > dist[cur] + d)
			{
				dist[next] = dist[cur] + d;
				prev[next] = cur + 1;
				PQ.push(P(dist[next],next));
			}
		}
	}

	//결과
	for(int i=0;i<V;i++)
	{
		if (dist[i] == INF) puts("INF");
		else printf("%d\n", dist[i]);
	}
	return (0);
}