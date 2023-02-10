import sys
input = sys.stdin.readline

N, M = list(map(int,input().split()))
ar = [ 0 for _ in range(N)]
visit = [False for _ in range(N + 1)]

def DFS(cnt):
    global N, M
    if cnt == M:
        for i in range(M):
            print(ar[i],end=' ')
        print()
        return

    for i in range(1, N+1):
        ar[cnt] = i
        DFS(cnt + 1)

DFS(0)