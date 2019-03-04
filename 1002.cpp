#include <iostream>
using namespace std;

int distance(int x1, int y1, int x2, int y2) {
	int d = (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);
	return d;
}

int main() {
	int T;
	cin >> T;
	int x1, y1, r1, x2, y2, r2;
	int d;
	int result;
	while (T--) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		d = distance(x1, y1, x2, y2);
		if (d == 0) //동심원인 경우
		{
			if (r1 == r2) result = -1;
			else result = 0;
		}
		else {
			if ((r2 - r1)*(r2 - r1) < d && (r1 + r2)*(r1 + r2) > d) result = 2; //두 원이 두 점에서 만나는 경우
			else if ((r1 + r2)*(r1 + r2) == d || (r2 - r1)*(r2 - r1) == d) result = 1; // 두원이 한 점에서 만나는 경우
			else result = 0; // 두 경우가 아닌 경우
		}
		cout << result << '\n';
	}
	return 0;
}