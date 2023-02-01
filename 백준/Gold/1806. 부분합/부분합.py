import sys
input = sys.stdin.readline
INF = int(1e9)
N, S = map(int, input().split())
arr = list(map(int,input().split()))
prefixsum = []
sum = 0
maxidx = -1
ret = INF
idx2 = 0
for idx in range(len(arr)):
    if arr[idx] == S:
        print(1)
        exit()
    sum+=arr[idx]
    prefixsum.append(sum)
    if maxidx == -1 and sum >= S:
        maxidx = idx

for idx in range(maxidx, len(prefixsum)):
    if prefixsum[idx] >= S:
        while idx > idx2:
            if prefixsum[idx] - prefixsum[idx2] >= S:
                idx2+=1
            else:
                break
        if idx-idx2 >0:
            ret = min(ret, idx - idx2 + 1)
print(ret if ret!=INF else 0)