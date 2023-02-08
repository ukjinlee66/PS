import sys
input = sys.stdin.readline
N = int(input().rstrip())
arr = list(map(int, input().split()))
brr = []
bset = set()
ret = [0] * N

for i in range(len(arr)):
    bset.add(arr[i])
    brr.append((arr[i], i))
check={}
crr = sorted(list(bset))
for i in range(len(crr)):
    check[crr[i]]=i
for i in range(len(brr)):
    ret[brr[i][1]] = check[brr[i][0]]
for c in ret:
    print(c, end=' ')