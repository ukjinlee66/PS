#include<iostream>
#include<algorithm>
#include<queue>
#include<stack>
using namespace std;
int n, pre;
int main()
{
	cin >> n;
	queue<int> qu;
	stack<int> st;
	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		qu.push(num);
	}
	while (!qu.empty())
	{
		if (!st.empty() && st.top() == pre + 1)
		{
			pre = st.top();
			st.pop();
		}
		else if (qu.front() == pre + 1)
		{
			pre = qu.front();
			qu.pop();
		}
		else
		{
			st.push(qu.front());
			qu.pop();
		}
	}
	while (!st.empty())
	{
		if (st.top() != pre + 1)
			break;
		pre = st.top();
		st.pop();
	}
	if (st.empty())
		cout << "Nice" << '\n';
	else
		cout << "Sad" << '\n';
	return 0;
}