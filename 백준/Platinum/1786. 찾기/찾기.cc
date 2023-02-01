#include <iostream>
#include <vector>
#include <string>
#include <utility>
using namespace std;
# define MAXNUM 1000000

int N,M;

vector<int> InitNext(string p)
{
	int m = (int)p.size();
	int j = 0;
	vector<int> pi(m, 0);
	
	for(int i=1;i<m;i++)
	{
		while(j > 0 && p[i] != p[j])
			j = pi[j - 1];
		if (p[i] == p[j])
			pi[i] = ++j;
	}
	return (pi);
}

vector<int> kmp(string s, string p)
{
	vector<int> ans;
	vector<int> pi = InitNext(p);
	int n = (int)s.size(), m = (int)p.size(), j = 0;
	for(int i=0;i<n;i++)
	{
		while(j > 0 && s[i] != p[j])
			j = pi[j - 1];
		if (s[i] == p[j])
		{
			if (j == m - 1)
			{
				ans.push_back(i - m + 1);
				j = pi[j];
			}
			else
				j++;
		}
	}
	return (ans);
}

int main(void)
{
	string s,p;
	getline(cin, s);
	getline(cin, p);
	vector<int> ret = kmp(s,p);
	printf("%d\n",(int)ret.size());
	for (auto i : ret)
		printf("%d ",i + 1);
    return (0);
}