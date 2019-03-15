#include<iostream>
#include<algorithm>
using namespace std;
int T, ar[8],mnum=98765432,sum;
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> T;
	while (T--)
	{
		for (int i = 0; i < 7; i++)
		{
			cin >> ar[i];
			if (ar[i] % 2 == 0) 
				sum += ar[i],mnum = min(mnum, ar[i]); 
		}
		cout << sum << " " << mnum << '\n';
		sum = 0; mnum = 98765432;
	}
}