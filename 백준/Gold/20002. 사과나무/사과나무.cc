#include <iostream>
#include <climits>
#include <cmath>
using namespace std;
int N,K;
int map[302][302];
int pmap[302][302];
int ret = INT_MIN;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> N;
	for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
		{
			cin>>map[i][j];
			ret = max(ret, map[i][j]);
			pmap[i+1][j+1] = pmap[i+1][j] + pmap[i][j+1] - pmap[i][j] + map[i][j];
		}
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++)
		{
			for (int k=0;k<N;k++)
			{
				if (i+k > N || j+k > N || i-1 < 0 || j-1 < 0) break;
				ret = max(ret, pmap[i+k][j+k] - pmap[i-1][j+k] - pmap[i+k][j-1] + pmap[i-1][j-1]);
			}
		}
	}
	cout << ret;
	return (0);
}