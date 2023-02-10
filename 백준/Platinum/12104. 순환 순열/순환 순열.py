import sys
input = sys.stdin.readline
S = str(input().rstrip())
P = str(input().rstrip())
n = len(P)
cnt = 0
for i in range(n-1,-1,-1):
    temp =  P[i:] + P[:i]
    if(S == temp):
        cnt+=1
print(cnt)