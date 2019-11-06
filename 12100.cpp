#include<bits/stdc++.h>
using namespace std;
int T;
int n;
int res;
int ar[22][22];
int br[22][22];
int checkmax()
{
	int re = 0;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			re = max(re, ar[i][j]);
	}
	return re;
}
void dfs(int num, int cnt = 0)
{
	int cr[22][22] = { 0 };
	if (cnt == 5)
	{
		res = max(res, checkmax());
		return;
	}
	if (num == 0) //up
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (ar[j][i] == 0) //(1) 0인 자리를전부채움.
				{
					for (int k = j + 1; k <= n; k++)
					{
						if (ar[k][i] != 0)
						{
							ar[j][i] = ar[k][i];
							ar[k][i] = 0;
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (ar[j][i] == ar[j + 1][i])
				{
					ar[j][i] = ar[j][i] * 2;
					ar[j + 1][i] = 0;
					for (int k = j + 1; k <= n - 1; k++)
					{
						ar[k][i] = ar[k + 1][i];
						ar[k + 1][i] = 0;
					}
				}
			}
		}
	}
	else if (num == 1)//left
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (ar[i][j] == 0) //(1) 0인 자리를전부채움.
				{
					for (int k = j + 1; k <= n; k++)
					{
						if (ar[i][k] != 0) {
							ar[i][j] = ar[i][k];
							ar[i][k] = 0;
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (ar[i][j] == ar[i][j + 1])
				{
					ar[i][j] = ar[i][j] * 2;
					ar[i][j + 1] = 0;
					for (int k = j + 1; k <= n - 1; k++)
					{
						ar[i][k] = ar[i][k + 1];
						ar[i][k + 1] = 0;
					}
				}
			}
		}
	}
	else if (num == 2)//right
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = n; j >= 1; j--)
			{
				if (ar[i][j] == 0) //(1) 0인 자리를전부채움.
				{
					for (int k = j - 1; k >= 1; k--)
					{
						if (ar[i][k] != 0) {
							ar[i][j] = ar[i][k];
							ar[i][k] = 0;
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = n; j >= 1; j--)
			{
				if (ar[i][j] == ar[i][j - 1])
				{
					ar[i][j] = ar[i][j] * 2;
					ar[i][j - 1] = 0;
					for (int k = j - 1; k >= 2; k--)
					{
						ar[i][k] = ar[i][k - 1];
						ar[i][k - 1] = 0;
					}
				}
			}
		}
	}
	else if (num == 3)//down
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = n; j >= 1; j--)
			{
				if (ar[j][i] == 0) //(1) 0인 자리를전부채움.
				{
					for (int k = j - 1; k >= 1; k--)
					{
						if (ar[k][i] != 0) {
							ar[j][i] = ar[k][i];
							ar[k][i] = 0;
							break;
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = n; j >= 1; j--)
			{
				if (ar[j][i] == ar[j - 1][i])
				{
					ar[j][i] = ar[j][i] * 2;
					ar[j - 1][i] = 0;
					for (int k = j - 1; k >= 2; k--)
					{
						ar[k][i] = ar[k - 1][i];
						ar[k - 1][i] = 0;
					}
				}
			}
		}
	}
	for (int i = 0; i < 4; i++)
	{
		memcpy(cr, ar, sizeof(ar));
		dfs(i, cnt + 1);
		memcpy(ar, cr, sizeof(cr));
	}
	return;
}
int main()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++) {
			scanf("%d", &ar[i][j]);
			br[i][j] = ar[i][j];
		}
	////명령5번.
	for (int i = 0; i < 4; i++) {
		dfs(i);
		memcpy(ar, br, sizeof(br)); //초기상태.
	}
	printf("%d", res);
	return 0;
}