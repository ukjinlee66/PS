#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
char str[4];
int ar[4], k;
queue<pair<char, int>> Q;
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	char A = 'A';
	for (int i = 0; i < 3; i++)
		cin >> ar[i];
	for (int i = 0; i < 3; i++)
		cin >> str[i];
	sort(ar, ar + 3);
	for (int i = 0; i < 3; i++)
		Q.push(make_pair(A++, ar[i]));
	while (!Q.empty())
	{
		if (Q.front().first == str[k])
		{
			cout << Q.front().second << " ";
			Q.pop();
			k++;
		}
		else
		{
			char w = Q.front().first;
			int ww = Q.front().second;
			Q.pop();
			Q.push(make_pair(w, ww));
		}
	}
}