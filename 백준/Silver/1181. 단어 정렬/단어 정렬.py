import sys
input = sys.stdin.readline
N = int(input().rstrip())
ar = []
for _ in range(N):
    ar.append(str(input().rstrip()))
ar = list(set(ar))
ar.sort(key=lambda x : (len(x), x))
for c in ar:
    print(c)