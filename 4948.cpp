#include<iostream>
#include<cmath>
#include<cstring>
using namespace std;
int n, cnt, ccnt;
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	while (cin >> n)
	{
		if (n == 0)
			return 0;
		if (n == 1 || n ==2)
		{
			cout << "1" << '\n';
			continue;
		}
		bool* prime = new bool[(2*n) + 1];
		memset(prime, 0, sizeof(bool) * ((2*n) + 1));

		for (int i = 2; i <= 2*n; i++) {
			if (prime[i] == false) {
				for (int j = i * 2; j <= 2*n; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = 0; i <= 2*n; i++) {
			prime[i] = !prime[i];
		}
		for (int i = n + 1; i <= 2 * n; i++)
			if (prime[i] == true)
				cnt++;
		cout << cnt << '\n';
		cnt = 0;
		delete prime;
	}
	return 0;
}