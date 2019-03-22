#include<iostream>
#include<string>
using namespace std;
string s;
int ar[26];
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> s;
	for (int i = 0; i < s.length(); i++)
	{
		for (int j = 0; j < 26; j++)
		{
			if (j == s[i] - 'a')
			{
				ar[j]++;
			}
		}
	}
	for (int i = 0; i < 26; i++)
		cout << ar[i] << " ";
}