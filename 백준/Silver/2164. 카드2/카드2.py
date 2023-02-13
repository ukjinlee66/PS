import sys
from collections import deque
input = sys.stdin.readline
N = int(input().rstrip())
D = deque()
for i in range(1,N+1):
    D.append(i)
while D:
    if len(D) == 1:
        print(D[0])
        break
    D.popleft()
    temp = D.popleft()
    D.append(temp)