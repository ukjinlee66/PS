#include<iostream>
using namespace std;
int n, r, x, y, i, j, a[101][101];
int main() 
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n;
	while (n--) {
		cin >> x >> y;
		for (i = x; i < x + 10; i++) 
			for (j = y; j < y + 10; j++) 
				r = r + !a[i][j]++;
	}
	for (int i = 0; i < 100; i++)
	{
		for (int j = 0; j < 100; j++)
			cout << a[i][j];
		cout << '\n';
	}
	cout << r << '\n';
	return 0;
}