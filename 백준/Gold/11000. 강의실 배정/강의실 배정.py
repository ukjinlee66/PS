import sys
import heapq
input = sys.stdin.readline
N = int( input().rstrip())
H = []
lis = list(list(map(int,input().split())) for _ in range(N))
lis = sorted(lis, key=lambda x : (x[0], x[1]))
heapq.heappush(H, (lis[0][1], lis[0][0]))
for i in range(1,N):
    if lis[i][0] < H[0][0]:
        heapq.heappush(H, (lis[i][1], lis[i][0]))
    else:
        heapq.heappop(H)
        heapq.heappush(H, (lis[i][1], lis[i][0]))
print(len(H))