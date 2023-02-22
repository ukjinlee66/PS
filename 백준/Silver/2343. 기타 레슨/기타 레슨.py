import sys
input = sys.stdin.readline

N, M = list( map( int, input().split()))
t = list( map( int, input().split()))
if M == N:
    print(max(t))
    exit()
if M == 1:
    print(sum(t))
    exit()
start, end = max(t), sum(t)
ret = 10000000000
while start <= end:
    mid = (end+start) // 2
    
    su = 0
    temp = M
    for i in range(N):
        if temp <= 0:
            break
        if su + t[i] <= mid:
            su += t[i]
        else:
            if temp > 0:
                temp-=1
                su = t[i]
    if temp > 0:
        end = mid - 1
        if mid >= max(t):
            ret = min(ret, mid)
    else:
        start = mid + 1
        
print(ret)