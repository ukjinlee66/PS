import sys
input = sys.stdin.readline
INF = int(1e9)
N = int(input().rstrip())
ar = list(map(int,input().split()))
lis = [INF] * N

def binarysearch(left, right, val):
    global lis

    while (left < right):
        mid = (right + left) // 2
        if lis[mid] < val:
            left = mid + 1
        else:
            right = mid
    return right

lis[0] = ar[0]
idx = 1
idx2 = 0
while idx < N:
    if lis[idx2] < ar[idx]:
        lis[idx2+1] = ar[idx]
        idx2+=1
    else:
        id = binarysearch(0,idx2,ar[idx])
        lis[id] = ar[idx]
    idx+=1
cnt = 0
for l in lis:
    if l == INF:
        break
    cnt+=1
print(cnt)