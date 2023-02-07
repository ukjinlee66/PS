import sys
from collections import deque
input = sys.stdin.readline
M, N, H = list(map(int,input().split()))
visit = [[[False for _ in range(M)] for _ in range(N)] for _ in range(H)]
graph = [[list(map(int,input().split())) for _ in range(N)] for _ in range(H)]
flag = False
def addDeque():
    global graph, visit, flag
    d = deque()

    for k in range(H):
        for i in range(N):
            for j in range(M):
                if graph[k][i][j] == 1:
                    visit[k][i][j] = True
                    d.append((k,i,j))
                if graph[k][i][j] == 0:
                    flag = True
    return d

def checkgraph():
    global graph

    for k in range(H):
        for i in range(N):
            for j in range(M):
                if graph[k][i][j] == 0:
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
    curh, curx, cury = D.popleft()
    for nexth, nextx, nexty in ((curh, curx + 1, cury), (curh, curx - 1, cury), (curh, curx, cury + 1), (curh, curx, cury - 1), 
    (curh + 1, curx, cury), (curh - 1, curx, cury)):
        if nexth < 0 or nextx < 0 or nexty < 0 or nextx >= N or nexth >= H or nexty >= M or visit[nexth][nextx][nexty] or graph[nexth][nextx][nexty] == -1 or graph[nexth][nextx][nexty] == 1:
            continue
        visit[nexth][nextx][nexty] = True
        graph[nexth][nextx][nexty] = 1
        sub.append((nexth, nextx, nexty))
    if len(D) == 0:
        if len(sub) != 0:
            cnt+=1
        D = sub.copy()
        sub.clear()
if checkgraph():
    print(cnt)
else:
    print(-1)