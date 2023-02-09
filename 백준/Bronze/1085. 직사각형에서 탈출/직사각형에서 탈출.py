import sys
input = sys.stdin.readline
x, y, w, h = list(map(int,input().split()))
print(min(min(x, abs(w-x)), min(y, abs(h-y))))