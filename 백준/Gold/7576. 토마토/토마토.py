import sys
from collections import deque
input = sys.stdin.readline

M, N = list(map(int, input().split()))
graph = [list(map(int, input().split()))for _ in range(N)]
visit = [[False for _ in range(M)] for _ in range(N)]
flag = False
def addDeque():
    global graph, M, N, flag
    d = deque()
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                d.append((i, j))
            if graph[i][j] == 0:
                flag = True
    return d

def checkgraph():
    global graph, M, N

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                return False
    return True

D = addDeque()
if not D:
    if flag:
        print(-1)
    else:
        print(0)
    exit()

sub = deque()
cnt = 0
while len(D) != 0:
    curx, cury = D.popleft()
    for nextx, nexty in ((curx+1,cury),(curx-1,cury),(curx,cury+1),(curx,cury-1)):
        if nextx < 0 or nexty < 0 or nextx >= N or nexty >= M or visit[nextx][nexty] or graph[nextx][nexty] == -1 or graph[nextx][nexty]==1:
            continue
        visit[nextx][nexty]=True
        graph[nextx][nexty]=1
        sub.append((nextx,nexty))
    if len(D) == 0:
        if len(sub)!=0:
            cnt+=1
        D = sub.copy()
        sub.clear()
if checkgraph():
    print(cnt)
else:
    print(-1)