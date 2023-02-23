import sys
input = sys.stdin.readline
M, N = list( map( int, input().split()))
graph = [list(map(int, input().split())) for _ in range(M)]
visit = [[False for _ in range(N)] for _ in range(M)]
dp = [[-1 for _ in range(N)] for _ in range(M)]
def dfs(x, y):
    if dp[x][y] != -1:
        return dp[x][y]
    if x == M - 1 and y == N - 1:
        return 1
    dp[x][y] = 0
    for nextx, nexty in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
        if nextx < 0 or nexty < 0 or nextx >= M or nexty >= N:
            continue
        if graph[nextx][nexty] < graph[x][y]:
            dp[x][y] += dfs(nextx, nexty)
    return dp[x][y]

dfs(0,0)
print(dp[0][0])