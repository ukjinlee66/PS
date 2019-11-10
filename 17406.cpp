#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
typedef pair<int, int> P;
vector<pair<int, pair<int, int>>> turn;
int map[51][51];
int copmap[51][51];
int n, m, k;
int res = 987654321;
void print_map()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cout << map[i][j] << " ";
		puts("");
	}
	puts("");
}
void recover_map()
{
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			map[i][j] = copmap[i][j];
}
void copy_map()
{
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			copmap[i][j] = map[i][j];
}
void check_minnum_sum()
{
	for (int i = 0; i < n; i++)
	{
		int num = 0;
		for (int j = 0; j < m; j++)
		{
			num += map[i][j];
		}
		res = min(res, num);
	}
}
void turning(int r, int c, int s)
{
	while (s!=0) 
	{
		int temp = map[r - s][c - s];
		for (int i = r - s; i < r + s; i++)
			map[i][c - s] = map[i + 1][c - s];
		for (int j = c - s; j < c + s; j++)
			map[r + s][j] = map[r + s][j + 1];
		for (int i = r + s; i > r - s; i--)
			map[i][c + s] = map[i - 1][c + s];
		for (int j = c + s; j > c - s; j--)
			map[r - s][j] = map[r - s][j - 1];
		map[r - s][c - s + 1] = temp;
		s--;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> k;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> map[i][j];
	for (int i = 0; i < k; i++)
	{
		int a, b, c; cin >> a >> b >> c;
		turn.push_back(make_pair(a-1,make_pair(b-1,c)));
	}
	copy_map();//맵을복사.
	sort(turn.begin(), turn.end());//permutation 을사용하기위한 sort.
	do 
	{
		for (int i = 0; i < turn.size(); i++)
		{
			int r = turn[i].first;
			int c = turn[i].second.first;
			int s = turn[i].second.second;
			turning(r, c, s);
		}
		check_minnum_sum();
		recover_map();//원본을가져옴.
	} while (next_permutation(turn.begin(), turn.end()));
	//벡터에담긴 회전연산의 순서를 전부돌아본다 ->next_permutation
	//각연산은 한번씩적용.
	cout << res;
	return 0;
}