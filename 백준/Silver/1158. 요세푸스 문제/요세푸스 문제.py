import sys
from collections import deque
input = sys.stdin.readline

N, K = list(map(int,input().split()))
D = deque()
print('<',end='')
for i in range(1,N+1):
    D.append(i)

while len(D) != 0:
    for _ in range(K-1):
        temp = D.popleft()
        D.append(temp)
    if len(D) == 1:
        print(D.popleft(),end='')
    else:
        print(D.popleft(),end=', ')
print('>')