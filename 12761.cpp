#include<cstdio>
#include<queue>
using namespace std;
const int MAXN = 100001;
int n, m, a,b,cnt,x;
bool visit[MAXN];
queue<pair<int,int>> Q;
int main()
{
	scanf("%d%d%d%d", &a, &b, &n, &m);
	Q.push(make_pair(n,0));
	visit[n] = true;
	while (!Q.empty())
	{
		int now = Q.front().first;
		int count = Q.front().second;
		Q.pop();
		if (now == m)
		{
			printf("%d\n", count);
			return 0;
		}
		if (now + 1 < MAXN && !visit[now + 1]) {
			Q.push(make_pair(now + 1,count+1));
			visit[now + 1] = true;
		}
		if (now - 1 >= 0 && !visit[now - 1]) {
			Q.push(make_pair(now - 1,count+1));
			visit[now - 1] = true;
		}
		if (now - a >= 0 && !visit[now - a]) {
			Q.push(make_pair(now - a, count + 1));
			visit[now - a] = true;
		}
		if (now + a < MAXN && !visit[now + a]) {
			Q.push(make_pair(now + a, count + 1));
			visit[now + a] = true;
		}
		if (now - b >= 0 && !visit[now - b]) {
			Q.push(make_pair(now - b, count + 1));
			visit[now - b] = true;
		}
		if (now + b < MAXN && !visit[now + b]) {
			Q.push(make_pair(now + b, count + 1));
			visit[now + b] = true;
		}
		if (now * a < MAXN && !visit[now * a]) {
			Q.push(make_pair(now * a, count + 1));
			visit[now*a] = true;
		}
		if (now * b < MAXN && !visit[now * b]) {
			Q.push(make_pair(now * b,count+1));
			visit[now*b] = true;
		}
	}
	return 0;
}