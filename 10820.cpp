#include<iostream>
#include<string>
using namespace std;
string str;
int res;
int a, b, c, d;
int main()
{
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	while (getline(cin, str))
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (97 <= (int)str[i] && (int)str[i] <= 122)
			{
				a++;
			}
			else if (65 <= (int)str[i] && (int)str[i] <= 90)
			{
				b++;
			}
			else if (str[i] == ' ')
				d++;
			else
				c++;
		}
		cout << a << " " << b << " " << c << " " << d << '\n';
		a = 0; b = 0; c = 0; d = 0;
	}

	return 0;
}