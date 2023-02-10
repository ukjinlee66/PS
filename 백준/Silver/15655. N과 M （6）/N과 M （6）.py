import sys
input = sys.stdin.readline

N, M = list(map(int,input().split()))
ar = [ 0 for _ in range(N)]
arr = sorted(list(map(int,input().split())))
visit = [False for _ in range(10000 + 1)]

def DFS(n, cnt):
    global N, M, arr
    if cnt == M:
        for i in range(M):
            print(ar[i],end=' ')
        print()
        return

    for i in range(n,len(arr)):
        if not visit[i]:
            visit[i]= True
            ar[cnt] = arr[i]
            DFS(i+1,cnt + 1)
            visit[i]=False
DFS(0,0)