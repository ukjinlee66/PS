# 1) 문자열 뒤에 A를 추가
# 2) 문자열을 뒤집고 뒤에 B를 추가

import sys
from collections import deque

input = sys.stdin.readline
In = input().rstrip()
Target = input().rstrip()

while len(Target) != len(In):
    if Target[-1] == 'A':
        Target = Target[:-1]
    else:
        Target = (Target[:-1])[::-1]
print(1 if Target == In else 0)