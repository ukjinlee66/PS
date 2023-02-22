import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000000)
N = int(input().rstrip())
graph = []
ret = 1
for _ in range(N):
    graph.append(list(map(int, input().split())))

def DFS(x, y, c):
    global graph, N, visit

    visit[x][y] = True
    for nextx, nexty in ((x + 1, y), (x - 1, y), (x, y+1), (x, y-1)):
        if nextx < 0 or nexty < 0 or nextx >= N or nexty >= N or visit[nextx][nexty]:
            continue
        if c >= graph[nextx][nexty] and not visit[nextx][nexty]:
            DFS(nextx,nexty, c)
def InvDFS(x, y):
    global graph, N, visit

    visit[x][y] = True
    for nextx, nexty in ((x + 1, y), (x - 1, y), (x, y+1), (x, y-1)):
        if nextx < 0 or nexty < 0 or nextx >= N or nexty >= N or visit[nextx][nexty]:
            continue
        if not visit[nextx][nexty]:
            InvDFS(nextx, nexty)
for i in range(0,101):
    visit=[[False for _ in range(N)] for _ in range(N)]
    cnt = 0
    for ii in range(N):
        for jj in range(N):
            if not visit[ii][jj] and graph[ii][jj]<=i:
                DFS(ii,jj,i)
    for ii in range(N):
        for jj in range(N):
            if not visit[ii][jj]:
                cnt+=1
                InvDFS(ii, jj)
    ret = max(ret, cnt)
print(ret)