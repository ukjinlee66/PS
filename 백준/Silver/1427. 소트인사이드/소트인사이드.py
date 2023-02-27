import sys
input = sys.stdin.readline
S = list(input().rstrip())
S = sorted(S, reverse=True)
print(''.join(S))