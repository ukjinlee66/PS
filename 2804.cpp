#include<iostream>
#include<string>
#include<cstring>
#include<algorithm>
using namespace std;
string str1, str2;
char map[31][31],idx,idx2,cnt,flag,k;
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> str1 >> str2;
	int N = str1.length();
	int M = str2.length();
	memset(map, '.', sizeof(map));
	for (int i = 0; i < N; i++)
	{
		for(int j=0;j<M;j++)
		if (!flag&&str1[i] == str2[j]) {
			idx = i;idx2 = j;flag = 1;
			break;
		}
	}
	for (int i = 0; i < M; i++)
	{
		map[i][idx] = str2[i];
	}
	for (int j = 0; j < N; j++)
	{
		map[idx2][j] = str1[j];
	}
	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++ )
			cout << map[i][j];
		cout << '\n';
	}
}