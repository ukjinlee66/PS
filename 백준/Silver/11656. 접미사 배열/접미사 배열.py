import sys
input = sys.stdin.readline

S = str(input().rstrip())
arr = []
arr.append(S)
for i in range(1, len(S)):
    arr.append(S[i:])
arr = sorted(arr)
for ch in arr:
    print(ch)