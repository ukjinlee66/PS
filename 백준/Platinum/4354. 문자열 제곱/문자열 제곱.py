import sys
input = sys.stdin.readline

def create_fail(pattern):
    le = len(pattern)
    fail = [0 for _ in range(le)]
    pidx = 0
    for idx in range(1, le):
        while pidx > 0 and pattern[idx] != pattern[pidx]:
            pidx = fail[pidx - 1]
        if pattern[idx] == pattern[pidx]:
            pidx+=1
            fail[idx] = pidx
    return fail

S = str(input().rstrip())
while True:
    if S == '.': break
    le = len(S)
    arr = create_fail(S)
    if le % (le - arr[-1]) != 0:
        print(1)
    else:
        print(le // (le - arr[-1]))
    S = str(input().rstrip())