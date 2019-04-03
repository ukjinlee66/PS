#include<iostream>
#include<algorithm>
#include<queue>
#include<functional>
#include<string>
#include<set>
#include<utility>
using namespace std;
int n, k, kk;
set<string> mset;
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		string str; string str2;
		cin >> str >> str2;
		if (str2 == "enter")
			mset.insert(str);
		else
		{
			mset.erase(str);
		}
	}
	set<string>::reverse_iterator key;
	for (key = mset.rbegin(); key != mset.rend(); key++) {
		cout << *key << "\n";
	}
	return 0;
}