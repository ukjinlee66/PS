#include<cstdio>
#include<cstring>
#include<algorithm>
#include<queue>
using namespace std;
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
typedef pair<int, int> P;
int R, C, T, time;
P up, down;//공기청정기 위,아래 부분.
int map[51][51];
int copymap[51][51];
//미세먼지 확장->공기청정기작동 ->시간++
bool check(int x, int y) //범위구간체크.
{
	return (x < 0 || y < 0 || x >= R || y >= C);
}
void init()
{
	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			if (copymap[i][j] != -1)
				copymap[i][j] = 0;
}
void mapcopy2()
{
	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			map[i][j] = copymap[i][j];
}
int check2(int x, int y) //인접한 0의개수체크.
{
	int cnt = 0;
	if (map[x + 1][y] != -1 && !check(x + 1, y))
		cnt++;
	if (map[x][y + 1] != -1 && !check(x, y + 1))
		cnt++;
	if (map[x - 1][y] != -1 && !check(x - 1, y))
		cnt++;
	if (map[x][y - 1] != -1 && !check(x, y - 1))
		cnt++;
	return cnt;
}
void print()
{
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
			printf("%d ", map[i][j]);
		printf("\n");
	}
}
int sum()
{
	int res = 0;
	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			if (map[i][j] > 0)
				res += map[i][j];
	return res;
}
void upwind(P a)
{
	int x = a.first;
	int y = a.second;
	map[x - 1][y] = 0;//빨려들어간 미세먼지.
	for (int i = x - 2; i >= 0; i--)
		map[i + 1][y] = map[i][y];
	map[0][0] = 0;
	for (int i = 0; i < C; i++)
		map[0][i] = map[0][i + 1];
	map[0][C - 1] = 0;
	for (int i = 0; i < x; i++)
		map[i][C - 1] = map[i + 1][C - 1];
	map[x][C - 1] = 0;
	for (int i = C - 1; i > 0; i--)
		map[x][i] = map[x][i - 1];
	map[x][y + 1] = 0;
}
void downwind(P a)
{
	int x = a.first;
	int y = a.second;
	map[x + 1][y] = 0;//빨려들어간 미세먼지.
	for (int i = x + 2; i < R; i++)
		map[i - 1][y] = map[i][y];
	map[R - 1][y] = 0;
	for (int i = 0; i < C; i++)
		map[R - 1][i] = map[R - 1][i + 1];
	map[R - 1][C - 1] = 0;
	for (int i = R - 1; i > x; i--)
		map[i][C - 1] = map[i - 1][C - 1];
	map[x][C - 1] = 0;
	for (int i = C - 1; i > 1; i--)
		map[x][i] = map[x][i - 1];
	map[x][y + 1] = 0;
}
void bfs()
{
	queue<P> Q;
	for (int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			if (map[i][j] > 0)
				Q.push({ i,j });
	while (!Q.empty())
	{
		int Siz = Q.size();
		while (Siz--)
		{
			int curx = Q.front().first;
			int cury = Q.front().second;
			Q.pop();
			int dd = check2(curx, cury);
			for (int i = 0; i < 4; i++)
			{
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				if (check(nx, ny)) continue;
				if (map[nx][ny] != -1)//4방향중 칸을발견.
				{
					Q.push({ nx,ny });
					copymap[nx][ny] += map[curx][cury] / 5;
				}
			}
			copymap[curx][cury] += map[curx][cury] - (map[curx][cury] / 5)*dd;
			//남은 미세먼지의 양.
		}
		return;
	}
}
int main()
{
	scanf("%d %d %d", &R, &C, &T);
	bool flag = false;
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			scanf("%d", &map[i][j]);
			if (!flag && map[i][j] == -1)
			{
				up = make_pair(i, j);
				flag = true;
				copymap[i][j] = map[i][j];
			}
			else if (flag && map[i][j] == -1)
			{
				down = make_pair(i, j);
				copymap[i][j] = map[i][j];
			}
		}
	}
	flag = false;
	while (T--)
	{
		bfs();
		mapcopy2();
		init();
		upwind(up);
		downwind(down);
	}
	printf("%d", sum());
}