import sys
sys.setrecursionlimit(100000000)
input = sys.stdin.readline
N, K = list( map( int, input().split()))
tree = list( map( int, input().split()))

def calculate_height(height):
    global tree, K

    sum = 0
    for i in range(N):
        sum += tree[i] - height if height < tree[i] else 0
    return sum

start , end = 0, 1000000000

while (start + 1 < end):
    mid = (end + start) // 2
    sum = calculate_height(mid)
    if sum >= K:
        start = mid
    else:
        end = mid
print(start)