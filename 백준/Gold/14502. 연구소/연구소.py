from collections import deque
import sys, copy

def BFS(x, y):
    global copy_map
    global visit
    visit[x][y] = True
    queue = deque([(x,y)])

    while queue:
        x, y = queue.popleft()
        copy_map[x][y] = 2
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M or visit[nx][ny] or (copy_map[nx][ny] != 0):
                continue
            visit[nx][ny] = True
            queue.append((nx,ny))

def check():
    global copy_map
    global ans
    cnt = 0
    for i in range(N):
        for j in range(M):
            if copy_map[i][j] == 0:
                cnt+=1
    ans = max(ans,cnt)

def sol(cnt):
    global origin_map
    global copy_map
    global visit

    if cnt == 0:
        copy_map = copy.deepcopy(origin_map)
        for i in range(N):
            for j in range(M):
                if copy_map[i][j] == 2:
                    BFS(i,j)
        visit = [[False for _ in range(M)]for _ in range(N)]
        check()
        return
    for i in range(N):
        for j in range(M):
            if origin_map[i][j]==0:
                origin_map[i][j]=1
                sol(cnt - 1)
                origin_map[i][j]=0
    return

N, M = map(int,input().split())
dx = [-1,1,0,0]
dy = [0,0,-1,1]
origin_map = [list(map(int, input().split())) for _ in range(N)]
visit = [[False for _ in range(M)] for _ in range(N)]
ans = -2147483648
sol(3)
print(ans)