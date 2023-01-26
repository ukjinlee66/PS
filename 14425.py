import sys
input = sys.stdin.readline

N, M = map(int, input().split())
cnt = 0
findSet = set()
for _ in range(N):
    temp = str(input().rstrip())
    findSet.add(temp)
for _ in range(M):
    temp = str(input().rstrip())
    if temp in findSet:
        cnt+=1
print(cnt)