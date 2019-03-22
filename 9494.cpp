#include <cstdio>
#include <iostream>
#include <string>
using namespace std;
int n;
int main()
{
	while (1)
	{
		scanf("%d", &n);
		if (n == 0) break;
		getchar();
		int idx = 0;
		for (int i = 0; i < n; i++)
		{
			string str;
			getline(cin, str);
			int len = str.size();
			for (; idx < len; idx++)
			{
				if (str[idx] == ' ')
				{
					break;
				}
			}
		}
		printf("%d\n", idx + 1);
	}
	return 0;
}