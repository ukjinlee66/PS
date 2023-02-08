import sys
input = sys.stdin.readline
D = set()
M = int(input().rstrip())
for _ in range(M):
    S = str(input().rstrip()).split()
    if len(S) == 1:
        com = S[0]
    else:
        com = S[0]
        num = int(S[1])
    if com == 'add':
        if num not in D:
            D.add(num)
    elif com == 'remove':
        if num in D:
            D.remove(num)
    elif com == 'check':
        print(1) if num in D else print(0)
    elif com == 'toggle':
        if num in D:
            D.remove(num)
        else:
            D.add(num)
    elif com == 'all':
        D = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}
    else:
        D.clear()