//boj-1940
#include<bits/stdc++.h>
using namespace std;
int n, k, a[15001];
int res;
int main()
{
	scanf("%d", &n);
	scanf("%d", &k);
	for (int i = 0; i < n; i++)
		scanf("%d", a + i);
	sort(a, a + n);
	for (int i = 0; i < n; i++)
	{
		int t = k - a[i];
		if (lower_bound(a + (i + 1), a + n, t) - a + 1 != upper_bound(a + (i + 1), a + n, t) - a + 1)
			res++;
	}
	printf("%d", res);
}