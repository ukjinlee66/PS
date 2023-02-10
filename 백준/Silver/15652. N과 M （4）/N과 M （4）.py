import sys
input = sys.stdin.readline

N, M = list(map(int,input().split()))
ar = [ 0 for _ in range(N)]
visit = [False for _ in range(N + 1)]

def DFS(n, cnt):
    global N, M
    if cnt == M:
        for i in range(M):
            print(ar[i],end=' ')
        print()
        return

    for i in range(n, N+1):
        ar[cnt] = i
        DFS(i, cnt + 1)
DFS(1,0)