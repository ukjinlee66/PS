import sys
from collections import deque
input = sys.stdin.readline

R, C = map(int, input().split())
INF = int(1e9)
graph = [list(map(int,input().strip())) for _ in range(R) ]
visit = [[[-1] * 2 for _ in range(C)] for _ in range(R)]
visit[0][0][0] = 1
Deq = deque()
Deq.append((0, 0, False)) # x, y, cnt, Destroy
ret = INF
while Deq:
    curx, cury, Dest = Deq.popleft()
    if curx == R-1 and cury == C-1:
        ret = min(ret, visit[curx][cury][Dest])
    for nextX, nextY in ((curx+1, cury), (curx-1, cury), (curx, cury+1), (curx, cury-1)):
        if nextX < 0 or nextY < 0 or nextX >= R or nextY >= C or visit[nextX][nextY][Dest] != -1:
            continue
        if graph[nextX][nextY] == 1 and Dest == False:
            visit[nextX][nextY][True] = visit[curx][cury][Dest] + 1
            Deq.append((nextX, nextY, True))
        if graph[nextX][nextY] == 0:
            visit[nextX][nextY][Dest] = visit[curx][cury][Dest] + 1
            Deq.append((nextX, nextY, Dest))
print(ret if ret != INF else -1)