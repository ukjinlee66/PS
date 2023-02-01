# 1. 알파벳 소문자로 이루어진 문자열 W가 주어진다.
# 2. 양의 정수 K가 주어진다.
# 3. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다. aqua
# 4. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다. raquator
# -> 맨앞과 맨뒤가 같은 알파벳으로 구성되며 가장 짧은 문자열과 긴 문자열을 출력
import sys
from collections import defaultdict

input = sys.stdin.readline
INF = int(1e9)
T = int(input())

for _ in range(T):
    s = str(input().strip())
    K = int(input())
    if K == 1:
        print("1 1")
        continue
    S = defaultdict(list)
    shortret = INF
    longret = -1

    alpa = list(0 for _ in range(26)) # alpabet List

    for ch in s:
        alpa[ord(ch) - ord('a')] += 1 # Count alphabet
    for idx in range(len(s)):
        if s.count(s[idx]) >= K:
            S[s[idx]].append(idx)
    if not S:
        print(-1)
        continue
    for st in S.values(): # Window Width (Window end point)
        for idx in range(len(st) - K + 1): # Window Start point
            temp = st[idx+K-1]-st[idx]+1
            shortret = min(shortret, temp)
            longret = max(longret, temp)
    print(str(shortret)+" "+str(longret))