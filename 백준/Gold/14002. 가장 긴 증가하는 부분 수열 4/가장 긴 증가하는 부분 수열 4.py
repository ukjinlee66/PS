import sys
from bisect import bisect_left
input = sys.stdin.readline
INF = int(1e9)
N = int(input().rstrip())
ar = list(map(int,input().split()))
lis = [-INF]
dp = [0] * (N+1)
for i in range(N):
    if lis[-1] < ar[i]:
        lis.append(ar[i])
        dp[i] = len(lis) - 1
    else:
        dp[i] = bisect_left(lis, ar[i])
        lis[dp[i]] = ar[i]
print(len(lis) - 1)
maxlen = len(lis) - 1
ans = []
for i in range(N,-1,-1):
    if dp[i] == maxlen:
        ans.append(ar[i])
        maxlen-=1
print(*(reversed(ans)))