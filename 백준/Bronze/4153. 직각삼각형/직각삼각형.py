import sys
input = sys.stdin.readline
li = list(map(int,input().split()))
li = sorted(li)
while li[0] != 0 and li[1] != 0 and li[2] != 0:
    if li[2]**2 == li[0]**2 + li[1]**2:
        print('right')
    else:
        print('wrong')
    li = list(map(int,input().split()))
    li = sorted(li)