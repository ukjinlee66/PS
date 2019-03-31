#include<cstdio>
#include<queue>
using namespace std;
int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };
char map[251][251];
bool visit[251][251];
int O, V,r,c;
void BFS(int x, int y)
{
	int o=0, v=0;
	queue<pair<int, int>>Q;
	Q.push(make_pair(x, y));
	visit[x][y] = true;
	while (!Q.empty())
	{
		int x = Q.front().first;
		int y = Q.front().second;
		Q.pop();
		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= r || ny >= c)
				continue;
			if (map[nx][ny] != '#'&& !visit[nx][ny] )
			{
				visit[nx][ny] = true;
				if (map[nx][ny] == 'o')
					o++;
				if (map[nx][ny] == 'v')
					v++;
				Q.push(make_pair(nx, ny));
			}
		}
	}
	if (o > v)
		O += o;
	else
		V += v;
}
int main()
{
	scanf("%d %d", &r, &c);
	char dum;
	for (int i = 0; i < r; i++) {
		getchar();
		for (int j = 0; j < c; j++)
			scanf("%c", &dum),map[i][j] = dum;
	}
	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			BFS(i, j);
	printf("%d %d", O, V);
}