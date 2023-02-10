import sys
input = sys.stdin.readline

S = str(input().rstrip())
P = str(input().rstrip())
ret = 0
def makefail(pattern):
    fail = [0 for _ in range(len(pattern))]
    idx = 0
    for idx2 in range(1,len(pattern)):
        while idx > 0 and pattern[idx2] != pattern[idx]:
            idx = fail[idx-1]
        if pattern[idx2] == pattern[idx]:
            idx+=1
            fail[idx2] = idx
    return fail

def KMP(S, P):
    global ret
    fail = makefail(P)
    idx = 0
    for idx2 in range(len(S)):
        while idx > 0 and S[idx2] != P[idx]:
            idx = fail[idx-1]
        if P[idx] == S[idx2]:
            if idx == len(P)-1:
                ret+=1
                idx = fail[idx]
            else:
                idx+=1
    return

n = len(P)
cnt = 0
for i in range(n-1,-1,-1):
    temp =  P[i:] + P[:i]
    if(S == temp):
        cnt+=1
print(cnt)