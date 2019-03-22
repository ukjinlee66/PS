#include<iostream>
#include<cstdio>
#include<string>
using namespace std;
char str[101];
int main()
{
	scanf("%s", str);
	for (int i = 0; i < 101; i++)
	{
		if (65 <= (int)str[i] && (int)str[i] <= 90)
			printf("%c", ((int)str[i] + 32));
		else if (97 <= (int)str[i] && (int)str[i] <= 122)
			printf("%c", ((int)str[i] - 32));
		else
			break;
	}
	return 0;
}