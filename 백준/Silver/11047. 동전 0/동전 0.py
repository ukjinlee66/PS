import sys
input = sys.stdin.readline

N, K = list(map(int, input().split()))
lis = []
id = 0
for _ in range(N):
    coin = int(input().rstrip())
    if coin > K:
        id +=1
    lis.append(coin)
cnt=0
idx = len(lis)-1-id
while K > 0:
    if K>=lis[idx]:
        cnt+=K // lis[idx]
        K=K % lis[idx]
    else:
        idx-=1
print(cnt)