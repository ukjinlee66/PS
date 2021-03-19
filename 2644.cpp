#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
int n, m;

vector< vector<int> > vec;
vector<int> ret;
int c1,c2;

int bfs(int mo)
{
    vector<bool> visit(n, false);
    queue<int> Q;
    Q.push(mo);
    visit[mo] = true;
    while (!Q.empty())
    {
        int cur = Q.front();
        Q.pop();
        for(int next : vec[cur])
        {
            if (next == c2)
                return ret[cur] + 1;
            if (!visit[next])
            {
                visit[next] = true;
                Q.push(next);
                ret[next] = ret[cur] + 1;
            }
        }
    }
    return (-1);
}

int main(void)
{
    scanf("%d",&n);
    scanf("%d %d",&c1,&c2);
    --c1,--c2;
    scanf("%d", &m);
    vec.resize(n);
    ret.resize(n, 0);
    for(int i=0;i<m;i++)
    {
        int n1,n2;
        scanf("%d %d",&n1,&n2);
        --n1,--n2;
        vec[n1].push_back(n2);
        vec[n2].push_back(n1);
    }
    printf("%d",bfs(c1));
    return (0);
}