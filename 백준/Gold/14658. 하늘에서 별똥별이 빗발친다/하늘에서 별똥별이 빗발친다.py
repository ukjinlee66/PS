import sys

input = sys.stdin.readline

N, M, L, K = map(int,input().split())
Star = []
for i in range(K):
    curx, cury = map(int, input().split())
    Star.append((curx, cury))
Maxn = -1
for idx in range(K):
    for idx2 in range(K):
        curx = Star[idx][0]
        cury = Star[idx2][1]
        cnt = 0
        for idx3 in range(K):
            newx = Star[idx3][0]
            newy = Star[idx3][1]
            if curx+L >= newx >= curx and cury+L >= newy >= cury:
                cnt+=1
        Maxn = max(Maxn,cnt)
print(K-Maxn)