import sys
from collections import deque
input = sys.stdin.readline

N = int(input().rstrip())
D = deque()
for _ in range(N):
    S = str(input().rstrip())
    if len(S) > 5:
        com, con = list(map(str,S.split()))
    else:
        com = S
    if com == 'push':
        D.append(int(con))
    elif com == 'top':
        if len(D) < 1:
            print(-1)
        else:
            temp = D.pop()
            print(temp)
            D.append(temp)
    elif com == 'size':
        print(len(D))
    elif com == 'empty':
        if len(D) < 1:
            print(1)
        else:
            print(0)
    elif com == 'pop':
        if len(D) < 1:
            print(-1)
        else:
            temp = D.pop()
            print(temp)