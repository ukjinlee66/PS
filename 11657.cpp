#include<iostream> //벨만포드
#include<vector>
#include<algorithm>
#include<utility>
using namespace std;
typedef pair<int, int> P;
const int INF = 1000000000;
int N, M, dist[500];
bool minuscycle;
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	vector<P> adj[500];
	for (int i = 0; i < M; i++)
	{
		int A, B, C; cin >> A >> B >> C;
		adj[A - 1].push_back(P(B - 1, C));
	}
	fill(dist, dist + N, INF);//처음 초기화.
	dist[0] = 0;
	for (int i = 0; i < N; i++) //N-1  +1루프
	{
		for (int j = 0; j < N; j++)
		{//N-1루프를 돌면서 각 정점이 i+1 개 정점을 거쳐오는 최단경로 갱신
			for (auto &p : adj[j]) {
				int next = p.first, d = p.second;
				if (dist[j] != INF && dist[next] > dist[j] + d) {
					dist[next] = dist[j] + d;
					if (i == N - 1)
						minuscycle = true;
				}
			}
		}
	}
	if (minuscycle)
	{
		cout << "-1\n";
	}
	else
	{
		for (int i = 1; i < N; i++)
			cout << (dist[i] != INF ? dist[i] : -1) << '\n';
	}
	return 0;
}