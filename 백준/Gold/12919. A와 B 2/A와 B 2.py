# 1) 문자열 뒤에 A를 추가
# 2) 문자열을 뒤집고 뒤에 B를 추가

import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline
In = input().rstrip()
Target = input().rstrip()
Check = False
def solve(Target, In):
    global Check
    if len(Target) <= 0:
        return
    if Target == In:
        Check=True
        return
    if Target[-1] == 'A':
        solve(Target[:-1], In)
    if Target[0] == 'B':
        solve((Target[1:])[::-1], In)
solve(Target, In)
print(1 if Check else 0)