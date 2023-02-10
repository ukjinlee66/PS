import sys
input = sys.stdin.readline

N, M = list(map(int,input().split()))
ar = [ 0 for _ in range(N)]
arr = sorted(list(map(int,input().split())))
visit = [False for _ in range(10000 + 1)]

def DFS(n,cnt):
    global N, M, arr
    if cnt == M:
        for i in range(M):
            print(ar[i],end=' ')
        print()
        return

    for i in range(n,len(arr)):
        ar[cnt] = arr[i]
        DFS(i,cnt + 1)
DFS(0,0)