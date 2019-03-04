#include<iostream>
using namespace std;
int n, s;
int ar[21];
int cnt;
void dfs(int idx, int sum)
{
	if (idx == n)
	{
		if (sum == s)
			cnt++;
		return;
	}
	dfs(idx + 1, sum);
	dfs(idx + 1, sum + ar[idx]);
}
int main()
{
	int i;
	cin >> n >> s;
	for (i = 0; i < n; i++)
		cin >> ar[i];
	dfs(1, 0);
	dfs(1, ar[0]);

	if (s == 0)
		cnt--;
	cout << cnt;

	return 0;
}