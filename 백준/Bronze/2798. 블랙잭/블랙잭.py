import sys
input = sys.stdin.readline

N, M = map(int,input().split())
new_list = list(map(int,input().split()))
ret = 0
for i in range(N):
    for j in range(N):
        for k in range(N):
            if (i != j and j != k) and (i < j  and j < k):
                if (new_list[i]+new_list[j]+new_list[k]) <= M:
                    ret = max(ret, new_list[i]+new_list[j]+new_list[k])
print(ret)