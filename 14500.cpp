#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int map[501][501];
int n, m;
int res;
bool check(int x, int y)
{
	if (x<1 || y<1 || x>n || y>m) return false;
	return true;
}
void one(int x, int y)
{
	if (check(x + 1, y + 1) && check(x + 1, y) && check(x, y + 1))
		res = max(res, map[x + 1][y + 1] + map[x + 1][y] + map[x][y + 1] + map[x][y]);
}
void two(int x, int y)
{
	if (check(x + 1, y) && check(x + 2, y) && check(x + 3, y))
		res = max(res, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 3][y]);
	//회전
	if (check(x, y + 1) && check(x, y + 2) && check(x, y + 3))
		res = max(res, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x][y + 3]);
}
void three(int x, int y)
{
	if (check(x + 1, y) && check(x + 2, y) && check(x + 2, y + 1))
		res = max(res, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 2][y + 1]);
	//회전 3가지.
	if (check(x, y + 1) && check(x, y + 2) && check(x - 1, y + 2))
		res = max(res, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 2]);
	if (check(x, y + 1) && check(x + 1, y + 1) && check(x + 2, y + 1))
		res = max(res, map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1]);
	if (check(x + 1, y) && check(x, y + 1) && check(x, y + 2))
		res = max(res, map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x][y + 2]);
	//반전1 +회전 3가지
	if (check(x, y + 1) && check(x - 1, y + 1) && check(x - 2, y + 1))
		res = max(res, map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x - 2][y + 1]);
	if (check(x, y + 1) && check(x, y + 2) && check(x + 1, y + 2))
		res = max(res, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 2]);
	if (check(x, y + 1) && check(x + 1, y) && check(x + 2, y))
		res = max(res, map[x][y] + map[x][y + 1] + map[x + 1][y] + map[x + 2][y]);
	if (check(x + 1, y) && check(x + 1, y + 1) && check(x + 1, y + 2))
		res = max(res, map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2]);
}
void four(int x, int y)
{
	if (check(x + 1, y) && check(x + 1, y + 1) && check(x + 2, y + 1))
		res = max(res, map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y + 1]);
	if (check(x, y + 1) && check(x - 1, y + 1) && check(x - 1, y + 2))
		res = max(res, map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x - 1][y + 2]);
	if (check(x + 1, y) && check(x, y + 1) && check(x - 1, y + 1))
		res = max(res, map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x - 1][y + 1]);
	if (check(x, y + 1) && check(x + 1, y + 1) && check(x + 1, y + 2))
		res = max(res, map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y + 2]);
}
void five(int x, int y)
{
	if (check(x, y + 1) && check(x, y + 2) && check(x - 1, y + 1))
		res = max(res, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
	if (check(x, y + 1) && check(x + 1, y + 1) && check(x - 1, y + 1))
		res = max(res, map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x - 1][y + 1]);
	if (check(x, y + 1) && check(x, y + 2) && check(x + 1, y + 1))
		res = max(res, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);
	if (check(x + 1, y) && check(x + 2, y) && check(x + 1, y + 1))
		res = max(res, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);
}
void sol(int x, int y, int number) //도형의 번호를받음. (1~5)
{
	switch (number)
	{
	case 1:
		one(x, y);
		break;
	case 2:
		two(x, y);
		break;
	case 3:
		three(x, y);
		break;
	case 4:
		four(x, y);
		break;
	case 5:
		five(x, y);
		break;
	}
	return;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			cin >> map[i][j];
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			for (int k = 1; k <= 5; k++)
			{
				sol(i, j, k);
			}
		}
	}
	cout << res;
	return 0;
}