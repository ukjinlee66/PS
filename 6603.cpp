#include<iostream>
#include<algorithm>
using namespace std;
int k, ar[13],br[13];
void dfs(int start, int dep)
{
	if (dep == 6)//탈출 조건
	{
		for (int i = 0; i < 6; i++)
		{
			cout<<br[i] << " "; // 조합하나를 출력 뒤 탈출
		}
		cout << '\n';
		return;
	}
	for (int i = start; i < k; i++)
	{
		br[dep] = ar[i];
		dfs(i + 1, dep + 1);
	}
}
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	while (cin >> k && k)
	{
		for (int i = 0; i < k; i++)
			cin >> ar[i];
		dfs(0, 0);
		cout << '\n';
	}
	return 0;
}