import sys
import heapq
input = sys.stdin.readline
N, K = list(map(int, input().split()))
ar = []
bag = []
ar2 = []
ret = 0
for _ in range(N):
    W, V = list(map(int,input().split()))
    heapq.heappush(ar, (W, V))
for _ in range(K):
    bag.append(int(input().rstrip()))
idx = 0
bag = sorted(bag)
for b in bag:
    while ar and ar[0][0] <= b:
        heapq.heappush(ar2, -heapq.heappop(ar)[1])
    if ar2:
        ret+= -heapq.heappop(ar2)
print(ret)