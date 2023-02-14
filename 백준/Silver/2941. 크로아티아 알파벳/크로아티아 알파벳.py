import sys
input = sys.stdin.readline
Dict = {
        'c=' : 1,
        'c-' : 1,
        'dz=' : 1,
        'd-' : 1,
        'lj' : 1,
        'nj' : 1,
        's=' : 1,
        'z=' : 1
        }
ret = 0
S = str(input().rstrip())
i = 0
while i < len(S):
    sub = S[i:i+2]
    if i + 3 <= len(S) and S[i:i+3] in Dict:
        ret+=1
        i+=3
    elif i + 2 <= len(S) and sub in Dict:
        ret+=1
        i+=2
    else:
        ret+=1
        i+=1
print(ret)