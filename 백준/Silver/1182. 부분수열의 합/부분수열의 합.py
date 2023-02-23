import sys
from itertools import combinations, permutations
input = sys.stdin.readline
M, S = list( map( int, input().split()))
lis = list( map( int, input().split()))
ret = 0
for i in range(1,M+1):
    perm = list(combinations(lis, i))
    for p in perm:
        if sum(p) == S:
            ret+=1
print(ret)