#include<cstdio>
using namespace std;
int n, t;
int dp[41];
int fibo(int n)
{

	if (dp[n] > 0)
		return dp[n];
	if (n == 0) return 0;
	if (n == 1) return 1;
	return dp[n] = fibo(n - 1) + fibo(n - 2);
}
int main()
{
	scanf("%d", &t);
	for (int i = 0; i < t; i++)
	{
		scanf("%d", &n);
		if (n == 0) {
			printf("1 0\n");
			continue;
		}
		if (n == 1) {
			printf("0 1\n");
			continue;
		}
		printf("%d %d\n", fibo(n - 1), fibo(n));
	}
}