import sys
from collections import deque
input = sys.stdin.readline

T = int( input().rstrip())
for _ in range(T):
    N = int( input().rstrip())
    startx, starty = list(map( int, input().split()))
    endx, endy = list(map( int, input().split()))
    visit = [[False for _ in range(N)] for _ in range(N)]
    D = deque()
    D.append((startx, starty, 0))
    visit[startx][starty] = True
    while D:
        curx, cury, cnt = D.popleft()
        if curx == endx and cury == endy:
            print(cnt)
            break
        for nextx, nexty in ((curx-2, cury-1), (curx-1, cury-2), (curx+2, cury-1), (curx+1, cury-2), (curx+2, cury+1), (curx+1, cury+2), (curx-2, cury+1), (curx-1, cury+2)):
            if nextx < 0 or nexty < 0 or nextx >=N or nexty >= N:
                continue
            if not visit[nextx][nexty]:
                visit[nextx][nexty] = True
                D.append((nextx,nexty, cnt+1))