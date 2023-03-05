import sys
input = sys.stdin.readline
N = int(input().rstrip())

N = 1000 - N
ret = 0
while N != 0:
    if N >= 500:
        ret += N // 500
        N %= 500
    elif N >= 100:
        ret += N // 100
        N %= 100
    elif N >= 50:
        ret += N // 50
        N %= 50
    elif N >= 10:
        ret += N // 10
        N %= 10
    elif N >= 5:
        ret += N // 5
        N %= 5
    else:
        ret += N // 1
        N %= 1
print(ret)