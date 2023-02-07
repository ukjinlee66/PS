import sys
import math
input = sys.stdin.readline
N = int(input().rstrip())

S = str(math.factorial(N))[::-1]
cnt = 0
for s in S:
    if s != '0':
        break
    cnt+=1
print(cnt)