#include <string>
#include <vector>
#include <iostream>

using namespace std;
int curx, cury;
vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    for(int i=0;i<park.size();i++)
    {
        for(int j=0;j<park[i].size();j++)
        {
            if (park[i][j] == 'S'){
                curx = i;
                cury = j;
            }
        }
    }
    for(int S = 0; S < routes.size();S++)
    {
        char dir = routes[S][0];
        int cost = (routes[S][2] - '0');
        int nextx = 0;
        int nexty = 0;
        bool flag = false;
        
        switch (dir) {
            case 'E':
                nexty = 1;
                break;
            case 'S':
                nextx = 1;
                break;
            case 'W':
                nexty = -1;
                break;
            case 'N':
                nextx = -1;
                break;
        }
        if ((curx + (cost * nextx) < park.size()) && (cury + (cost * nexty)) < park[0].size() && (curx + (cost * nextx)) >= 0 && (cury + (cost * nexty)) >= 0){
            for (int k = 1; k <=cost;k++) {
                if (park[curx + (nextx * k)][cury + (nexty * k)] == 'X'){
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                curx += (cost * nextx);
                cury += (cost * nexty);
            }
        }
    }
    answer.push_back(curx);
    answer.push_back(cury);
    return answer;
}