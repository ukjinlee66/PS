import sys
from collections import defaultdict

input = sys.stdin.readline
N = int( input().rstrip())
like = defaultdict(set)
graph = [[0 for _ in range(N)] for _ in range(N)]
stu = []

for _ in range(N**2):
    temp = list(map(int, input().split()))
    stu.append(temp[0])
    like[temp[0]]
    for i in range(1, len(temp)):
        if temp[i] not in like[temp[0]]:
            like[temp[0]].add(temp[i])

def check(st):
    global graph, like

    t = like[st]
    mm = []
    for i in range(N):
        for j in range(N):
            if graph[i][j] != 0:
                continue
            cnt = 0
            cnt2 = 0
            for nextx, nexty in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)):
                if nextx < 0 or nexty < 0 or nextx >= N or nexty >= N:
                    continue
                if graph[nextx][nexty] in t:
                    cnt+=1
                elif graph[nextx][nexty] == 0:
                    cnt2+=1
            mm.append((cnt, cnt2, i, j))
    mm = sorted(mm, key=lambda x : (-x[0], -x[1], x[2], x[3]))
    return(mm[0][2], mm[0][3])

for i in range(N**2):
    newx , newy = list(check(stu[i]))
    graph[newx][newy] = stu[i]
ret = 0
for i in range(N):
    for j in range(N):
        S = ''
        cnt = 0
        for nextx, nexty in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)):
            if nextx < 0 or nexty < 0 or nextx >= N or nexty >= N:
                continue
            if graph[nextx][nexty] in like[graph[i][j]]:
                cnt+=1
        if cnt >= 1:
            S = int('1' + ('0' * (cnt-1)))
        else:
            S = 0
        ret += S
print(ret)