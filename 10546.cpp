#include<iostream>
#include<set>
#include<algorithm>
#include<string>
#include<queue>
using namespace std;
int n;
queue<string> Q;
multiset<string> ms;
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		string str; cin >> str;
		ms.insert(str);
	}
	for (int i = 0; i < n - 1; i++)
	{
		string str; cin >> str;
		ms.erase(ms.find(str));
	}
	for (auto a : ms)
		cout << a << '\n';
}