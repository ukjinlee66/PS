#include<iostream>
#include<vector>
#include<deque>
#include<algorithm>
using namespace std;
int n, k;
int map[13][13];
bool level[11];//말이 바닥인지 올라타있는지.
deque<int> M[13][13];//2차원 공간관리.
pair<int, int> dir[4] = { {0,1},{0,-1},{-1,0},{1,0} }; //-> <- ^ v
vector<pair<int, pair<int, int>>> hor;//말의 좌표와 방향관리.
void checksize()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cout << M[i][j].size() << " ";
		cout << "\n";
	}
}
bool checkturn()
{
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (M[i][j].size() >= 4) //사이즈가4이상인 말이존재할경우.
			{
				return true;
			}
	return false;
}
void moving(int idx)//말의번호.
{
	if (!level[idx]) return; //올라타있는놈일경우 skip.
	int curx = hor[idx].first; //x좌표
	int cury = hor[idx].second.first; // y좌표
	int mo = hor[idx].second.second; //방향
	int nx = curx + dir[mo].first;//이동하려는 x좌표
	int ny = cury + dir[mo].second;//이동하려는 y좌표
	int w = map[nx][ny];
	if (w == 2 || (nx < 0 || ny < 0 || nx >= n || ny >= n))//파랑 일경우 반대바꿔서이동.
	{
		//방향전환.
		if (mo == 0) hor[idx].second.second = 1;
		else if (mo == 1) hor[idx].second.second = 0;
		else if (mo == 2) hor[idx].second.second = 3;
		else hor[idx].second.second = 2;
		mo = hor[idx].second.second; //바뀐방향 업데이트.
		nx = curx + dir[mo].first;
		ny = cury + dir[mo].second;//새로운이동.
		if ((nx < 0 || ny < 0 || nx >= n || ny >= n) || map[nx][ny] == 2)//파랑이거나 범위를넘어간경우.
			return;//방향을바꿧으니 그대로종료.
		else //파랑이거나 범위밖이아니므로 이동.
			moving(idx);
	}
	else if (w == 1)//빨강 덱을뒤집는다.
	{
		//말의좌표와공간을 이동시킨후 공간을 뒤집는다.
		if (M[nx][ny].size() >= 1) //빨간공간의 말이 이미 존재할경우.
		{
			while (!M[curx][cury].empty()) //빼면서 현재말의방향으로 전부이동시킨다. 현재칸의뒤에서빼서 뒤로집어넣음.
			{
				int val = M[curx][cury].back(); //말의 idx
				M[curx][cury].pop_back();
				M[nx][ny].push_back(val);
				if (M[nx][ny].size() >= 4)
					return;
				hor[val].first = nx;
				hor[val].second.first = ny; //말의좌표를바꾸어준다.
				level[val] = false;
			}
		}
		else //없을경우.
		{
			while (!M[curx][cury].empty()) //빼면서 현재말의방향으로 전부이동시킨다. //밑에서빼서 아래로집어넣음.
			{
				int val = M[curx][cury].front();
				M[curx][cury].pop_front();
				M[nx][ny].push_front(val);
				if (M[nx][ny].size() >= 4)
					return;
				hor[val].first = nx;
				hor[val].second.first = ny; //말의좌표를바꾸어준다. 그 후 꼭대기있던놈만 바닥으로간다.
				level[val] = false;
			}
			level[M[nx][ny].front()] = true;
		}
	}
	else//하양
	{
		if (M[nx][ny].size() >= 1)//말이 이미 존재할경우.
		{
			while (!M[curx][cury].empty())//현재있던칸을 전부비움
			{
				int val = M[curx][cury].front();//말의 번호.
				M[nx][ny].push_back(val);//새로운칸에 말을 쌓아올림.
				if (M[nx][ny].size() >= 4)
					return;
				M[curx][cury].pop_front();

				//말의 좌표변경 방향은 그대로둔다.
				hor[val].first = nx;
				hor[val].second.first = ny;
				level[val] = false;//전부올라탈예정.
			}
		}
		else //말이존재하지않을경우그대로이동. level 변화는없다.
		{
			while (!M[curx][cury].empty())
			{
				int val = M[curx][cury].front();//말의 번호.
				M[nx][ny].push_back(M[curx][cury].front());
				if (M[nx][ny].size() >= 4)
					return;
				M[curx][cury].pop_front();

				//말의 좌표변경 방향은 그대로둔다.
				hor[val].first = nx;
				hor[val].second.first = ny;
			}
		}
	}
	return;
}
int main()
{
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	cin >> n >> k;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];
	//이동방향 -> <- ^ v 1 2 3 4
	//체스판 0흰 1빨 2파
	for (int i = 0; i < k; i++) //체스를 받음.
	{
		int row, column, move;
		cin >> row >> column >> move;
		move--;
		row--;
		column--;
		hor.push_back({ row,{column,move} }); //말의 좌표와 방향을저장.
		M[row][column].push_back(i); //체스판의 공간에 할당.(i번)
		//같은칸에 말이두개이상 입력으로주어지지않는다.
		level[i] = true; //초기 모든말은 맨아래 바닥칸에 존재한다.
	}
	int turn = 1;
	while (true)
	{
		if (turn >= 1000) {
			turn = -1;
			break;
		}
		for (int i = 0; i < k; i++) {//말을돌아보며 턴을시작.
			moving(i);
			if (checkturn()) //만약 높이가4이상인말이있을경우 끝냄.
				break;
		}
		/*checksize();*/
		if (checkturn()) //만약 높이가4이상인말이있을경우 끝냄.
			break;
		turn++;//아닐경우 턴을증가.
	}
	cout << turn;
	return 0;
}