import sys
input = sys.stdin.readline

N, M = list(map(int,input().split()))
ar = [ 0 for _ in range(N)]
arr = sorted(list(map(int,input().split())))
visit = [False for _ in range(10000 + 1)]

def DFS(cnt):
    global N, M, arr
    if cnt == M:
        for i in range(M):
            print(ar[i],end=' ')
        print()
        return
    flag = 0
    for i in range(len(arr)):
        if arr[i] != flag:
            ar[cnt] = arr[i]
            flag = ar[cnt]
            DFS(cnt + 1)
DFS(0)