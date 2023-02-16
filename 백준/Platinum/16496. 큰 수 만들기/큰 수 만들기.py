import sys
import functools
input = sys.stdin.readline
N = int( input().rstrip())
lis = list(map(int, input().split()))
le = len(str(max(lis)))
for i in range(len(lis)):
    l = str(lis[i])
    if len(l) < le:
        temp = (l * ((le-len(l)) + 1))[:le]
        lis[i] = (int(temp),str(l))
    else:
        lis[i] = (int(l), str(l))
def compare(s2, s1):
    if s1[0] > s2[0]:
        return 1
    elif s1[0] < s2[0]:
        return -1
    else:
        if len(s1[1]) < len(s2[1]):
            return 1
        else:
            return -1
lis2 = sorted(lis, reverse=True)
lis = sorted(lis ,key=functools.cmp_to_key(compare))
ret2 = int(''.join([li[1] for li in lis]))
ret = int(''.join([li[1] for li in lis2]))
if ret2 > ret:
    print(ret2)
else:
    print(ret)