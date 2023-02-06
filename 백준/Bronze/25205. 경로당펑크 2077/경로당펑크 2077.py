import sys

input = sys.stdin.readline

checker = ['k', 'o', 'i', 'j', 'p', 'u', 'h', 'y', 'n', 'b', 'm', 'l']
n = int(input().rstrip())
S = str(input().rstrip())
print(0) if S[len(S)-1] in checker else print(1)