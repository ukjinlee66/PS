import sys
input = sys.stdin.readline
N = int(input().rstrip())
arr = []
for _ in range(N):
    start, end = list(map(int,input().split()))
    arr.append((start, end))
arr.sort(key = lambda x : (x[1], x[0]))
ret = 1
prevend = -1
for i in range(len(arr)):
    if i == 0:
        prevend = arr[i][1]
    else:
        if arr[i][0] >= prevend:
            ret+=1
            prevend = arr[i][1]
print(ret)