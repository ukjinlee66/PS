import sys
input = sys.stdin.readline
N, M = list(map(int, input().split()))
ret = 1
flag = False
while M != N:
    temp = M
    ret+=1
    if M % 2 == 0:
        M = M//2
    elif M % 10 == 1:
        M = M//10
    if temp == M:
        print(-1)
        flag = True
        break
if not flag:
    print(ret)