import sys
input = sys.stdin.readline
def FailFunction(pattern):
    le = len(pattern)
    fail = [ 0 for _ in range(le)]

    idx = 0
    for idx2 in range(1,le):
        while idx > 0 and pattern[idx] != pattern[idx2]:
            idx = fail[idx-1]
        if pattern[idx] == pattern[idx2]:
            idx+=1
            fail[idx2] = idx
    return fail
def KMP(S, P):
    fail = FailFunction(P)
    res = []
    idx = 0
    ret = 0
    for idx2 in range(len(S)):
        while idx > 0 and S[idx2] != P[idx]:
            idx = fail[idx - 1]
        
        if S[idx2] == P[idx]:
            if idx == len(P)-1:
                ret+=1
                idx = fail[idx]
            else:
                idx+=1
    return ret
N = int(input().rstrip())
M = int(input().rstrip())
S = str(input().rstrip())
if N > 1:
    P = 'IOI' + ('OI' * (N-1))
else:
    P = 'IOI'
print(KMP(S,P))