#include<cstdio>
#include<algorithm>
using namespace std;
int dx[] = { 0,1 };
int dy[] = { 1,0 };
int n, ans;
char map[55][55];
int check()
{
	int ret = 1;
	int cnt = 1;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			if (map[i][j] == map[i][j + 1])
				cnt++;
			else
				ret = max(ret, cnt), cnt = 1;
		}
		ret = max(ret, cnt), cnt = 1;
		for (int j = 1; j < n; j++)
		{
			if (map[j][i] == map[j + 1][i])
				cnt++;
			else
				ret = max(ret, cnt), cnt = 1;
		}
		ret = max(ret, cnt), cnt = 1;
	}
	return ret;
}
int main()
{
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
		scanf("%s", map[i] + 1);
	for(int x=1;x<=n;x++)
		for (int y = 1; y <= n; y++)
		{
			for (int d = 0; d < 2; d++)
			{
				int nx = x + dx[d], ny = y + dy[d];
				if (!map[nx][ny])
					continue;
				swap(map[x][y], map[nx][ny]);
				ans = max(ans, check());
				swap(map[x][y], map[nx][ny]);
			}
		}
	printf("%d", ans);

	return 0;
}