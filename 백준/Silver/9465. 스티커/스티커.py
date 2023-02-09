import sys
sys.setrecursionlimit(100000000)
input = sys.stdin.readline
T = int(input().rstrip())
for _ in range(T):
    N = int(input().rstrip())
    graph = [list(map(int,input().split())) for _ in range(2)]
    dp = [[0 for _ in range(N+1)] for _ in range(3)]
    for i in range(N):
        dp[0][i+1] = max(dp[0][i+1], dp[0][i], dp[1][i], dp[2][i])
        dp[1][i+1] = max(dp[1][i+1], dp[0][i], max(dp[0][i], dp[2][i]) + graph[0][i])
        dp[2][i+1] = max(dp[2][i+1], dp[0][i], max(dp[1][i], dp[0][i]) + graph[1][i])
    print(max(dp[0][N],dp[1][N],dp[2][N]))