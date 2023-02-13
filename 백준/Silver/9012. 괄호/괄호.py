import sys
from collections import deque
input = sys.stdin.readline

N = int(input().rstrip())
for _ in range(N):
    D = deque()
    S = str(input().rstrip())
    flag = False
    for s in S:
        if s == '(':
            D.append(s)
        else:
            if len(D) == 0:
                print('NO')
                flag = True
                break
            to = D.pop()
            if to == '(':
                continue
            else:
                print('NO')
                flag = True
                break
    if not flag:
        if len(D) == 0:
            print('YES')
        else:
            print('NO')