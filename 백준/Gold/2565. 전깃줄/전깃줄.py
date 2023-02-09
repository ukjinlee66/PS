import sys
input = sys.stdin.readline
N = int(input().rstrip())
le = []
dp = [0 for _ in range(N+1)]
for _ in range(N):
    start, end = list(map(int, input().split()))
    le.append((start, end))
le.sort(key=lambda x : (x[0], x[1]))
for i in range(N):
    for j in range(i):
        if le[i][1] > le[j][1] and dp[i]<dp[j]:
            dp[i] = dp[j]
    dp[i]+=1
print(N - max(dp))