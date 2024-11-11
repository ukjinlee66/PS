#include<cstdio>
#include<algorithm>
using namespace std;
int n,maxnum;
int ar[16], br[16];
void dfs(int day, int sum)
{
	if (day == n+1)
	{
		maxnum = max(sum, maxnum);
		return;
	}
	if (day + ar[day] <= n + 1)
		dfs(day + ar[day], sum + br[day]);
	if(day+1 <= n+1)
		dfs(day + 1, sum);
}
int main()
{
	scanf("%d", &n);
	for (int i = 1; i <=n; i++)
		scanf("%d %d", &ar[i], &br[i]);
	dfs(1, 0);
	printf("%d", maxnum);
}