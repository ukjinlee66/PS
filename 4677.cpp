#include<iostream>
#include<queue>
#include<cstring>
using namespace std;
int n, m,cnt;
int dx[8] = { 0,0,-1,1,1,1,-1,-1 };
int dy[8] = { 1,-1,0,0,1,-1,1,-1 };
queue<pair<int,int>> Q;
bool visit[101][101];
char map[101][101];
void BFS(int x, int y)
{
	Q.push(make_pair(x, y));
	visit[x][y] = true;
	while (!Q.empty())
	{
		int x = Q.front().first;
		int y = Q.front().second;
		Q.pop();
		for (int i = 0; i < 8; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (map[nx][ny] == '@' && !visit[nx][ny])
			{
				visit[nx][ny] = true;
				Q.push(make_pair(nx, ny));
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	while (cin >> n >> m)
	{
		if (n == 0 && m == 0)
			break;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				cin >> map[i][j];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (map[i][j] == '@'&&!visit[i][j])
				{
					BFS(i, j);
					cnt++;
				}
		}
		cout << cnt << '\n';
		memset(visit, false, sizeof(visit));
		memset(map, 0, sizeof(map));
		cnt = 0;
	}
}