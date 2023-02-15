import sys
import heapq
input = sys.stdin.readline
N = int( input().rstrip())
ar=[]
for _ in range(N):
    heapq.heappush(ar,int(input().rstrip()))
ret = 0
while len(ar) > 1:
    fir = heapq.heappop(ar)
    sec = heapq.heappop(ar)
    ret += fir+sec
    heapq.heappush(ar, fir + sec)
print(ret)