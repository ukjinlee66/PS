#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
int t, n, m, x, cnt;
int main()
{
	scanf("%d", &t);
	while (t--)
	{
		cnt = 0;
		queue<pair<int, int>> qu;
		priority_queue<int> pq;
		cin >> n >> m;
		for (int i = 0; i < n; i++)
		{
			cin >> x;
			qu.push(make_pair(x, i));
			pq.push(x);
		}
		while (qu.size())
		{
			int now = qu.front().first;
			int num = qu.front().second;
			qu.pop();
			if (pq.top() == now)
			{
				cnt++;
				pq.pop();
				if (num == m)break;
			}
			else
				qu.push(make_pair(now, num));
		}
		cout << cnt << '\n';
	}
	return 0;
}