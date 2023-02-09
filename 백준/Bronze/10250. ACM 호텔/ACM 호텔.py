import sys
input = sys.stdin.readline
T = int(input().rstrip())
for _ in range(T):
    H, W, N = list(map(int,input().split()))
    for i in range(1, W+1):
        for j in range(1, H+1):
            N-=1
            if N == 0:
                if i <= 9:
                    print(str(j)+'0'+str(i))
                else:
                    print(str(j)+str(i))