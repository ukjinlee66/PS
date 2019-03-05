#include<iostream>
#include<cstring>
using namespace std;
int n, cnt,k;
int main()
{
	ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	cin >> n >> k;
		bool* prime = new bool[n+1];
		memset(prime, 0, sizeof(bool) * (n+1));
		for (int i = 2; i <= n; i++) 
		{
			if (prime[i] == false) 
			{
				for (int j = i; j <= n; j += i) 
				{
					if (prime[j] == false)
					{
						prime[j] = true;
						cnt++;
					}
					if (cnt == k)
					{
						cout << j << '\n';
						return 0;
					}
				}
			}
		}
	return 0;
}