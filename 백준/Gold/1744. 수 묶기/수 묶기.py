import sys
import heapq
input = sys.stdin.readline
N = int( input().rstrip())
max_ar=[]
min_ar=[]
zerocnt = 0
onecnt = 0
sum = 0
sum2 = 0
for _ in range(N):
    temp = int(input().rstrip())
    sum2+= temp
    if temp == 0:
        zerocnt += 1
    if temp == 1:
        onecnt += 1
    elif temp > 1:
        heapq.heappush(max_ar, -temp)
    elif temp < 0:
        heapq.heappush(min_ar, temp)
while len(max_ar) > 1:
    fir = heapq.heappop(max_ar)
    sec = heapq.heappop(max_ar)
    sum += fir*sec
while len(min_ar) > 1:
    fir = heapq.heappop(min_ar)
    sec = heapq.heappop(min_ar)
    sum += fir*sec
if max_ar:
    sum += -max_ar[0]
if min_ar:
    if zerocnt == 0:
        sum+= min_ar[0]
sum+=onecnt
print(sum if sum > sum2 else sum2)