import sys
input = sys.stdin.readline
N = int(input().rstrip())
ar = list(map(int,input().split()))
le = [1] * N
for i in range(N):
    for j in range(i):
        if ar[i] < ar[j]:
            le[i] = max(le[i], le[j] + 1)
print(max(le))