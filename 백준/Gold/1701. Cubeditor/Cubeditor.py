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
ret = 0
S = str(input().rstrip())
for i in range(len(S) - 1):
    arr = create_fail(S[i:])
    ret = max(ret, max(arr))
print(ret)