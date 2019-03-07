#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int n, k, l, dir;
int map[102][102];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
vector<pair<int, int>> snake;
queue<pair<int, char>> Q;
void turn(char c)
{
	if (c == 'L')
		dir = (dir - 1 < 0) ? 3 : dir - 1;
	else
		dir = (dir + 1 > 3) ? 0 : dir + 1;
}
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n >> k;
	for (int i = 0; i < k; i++)
	{
		int a, b;
		cin >> a >> b;
		map[a][b] = 2;
	}
	cin >> l;
	for (int i = 0; i < l; i++)
	{
		int d; char c;
		cin >> d >> c;
		Q.push(make_pair(d, c));
	}
	map[1][1] = 1;
	snake.push_back(make_pair(1, 1));
	dir = 1;
	int time = 0;
	while (true)
	{
		if (!Q.empty())
		{
			if (Q.front().first == time)
			{
				turn(Q.front().second);
				Q.pop();
			}
		}
		time++;
		int nx = snake[snake.size() - 1].first + dx[dir];
		int ny = snake[snake.size() - 1].second + dy[dir];

		if (nx<1 || ny<1 || nx>n || ny>n || map[nx][ny] == 1)
			break;
		if (map[nx][ny] != 2)
		{
			map[snake[0].first][snake[0].second] = 0;
			snake.erase(snake.begin());
		}
		snake.push_back(make_pair(nx, ny));
		map[nx][ny] = 1;
	}
	cout << time << '\n';
	return 0;
}