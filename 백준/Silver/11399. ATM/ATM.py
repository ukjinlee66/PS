import sys
input = sys.stdin.readline

N = int(input().rstrip())
lis = list(map(int,input().split()))
lis = sorted(lis)
prelis = [0] * len(lis)
prelis[0] = lis[0]
ret = 0
for i in range(1,len(lis)):
    prelis[i] = prelis[i-1]+lis[i]
    ret+=prelis[i]
ret+=prelis[0]
print(ret)