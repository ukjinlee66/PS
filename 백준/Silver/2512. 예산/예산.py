import sys
input = sys.stdin.readline
N = int( input().rstrip())
cost = list( map( int, input().split()))
K = int( input().rstrip())

start , end = 0, max(cost)
while start <= end:
    mid = (end + start) // 2
    s = 0
    for c in cost:
        s+=min(mid, c)
    if s <= K:
        start = mid + 1
    else:
        end = mid - 1
print(end)