import sys
import functools
input = sys.stdin.readline
N = int( input().rstrip())
lis = []
for _ in range(N):
    Ti, Si = list(map(int,input().split()))
    lis.append((Si, Ti))
lis = sorted(lis)
for i in range(lis[0][0]-1,-1,-1):
    curtime = 0
    flag = False
    for j in range(len(lis)):
        Si , Ti = lis[j]
        if j == 0:
            if i + Ti <= Si:
                curtime = i + Ti
            else:
                flag = True
                break
        else:
            if curtime + Ti <= Si:
                curtime += Ti
            else:
                flag = True
                break
    if not flag:
        print(i)
        exit()
print(-1)