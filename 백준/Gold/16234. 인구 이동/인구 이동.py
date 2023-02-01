# 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
# 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
# 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
# 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
# 연합을 해체하고, 모든 국경선을 닫는다. 1
import sys
from collections import deque
import copy

input = sys.stdin.readline
ret = 0
N, L, R = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

def solve(x, y):
    global graph, visited
    D = deque()
    D.append((x, y))
    path = {}
    path[(x, y)] = True
    visited[x][y] = True
    sum = 0
    while D:
        curx, cury = D.popleft()
        curcost = int(graph[curx][cury])
        sum += graph[curx][cury]
        for nextX, nextY in ((curx + 1, cury), (curx - 1, cury), (curx, cury + 1), (curx, cury - 1)):
            if nextX < 0 or nextY < 0 or nextX >= N or nextY >= N or visited[nextX][nextY]:
                continue
            diffcost = abs(int(graph[nextX][nextY]) - curcost)
            if L <= diffcost <= R and visited[nextX][nextY] == False:
                visited[nextX][nextY]= True
                D.append((nextX, nextY))
                path[(nextX, nextY)] = True
    if len(path) == 1:
        return False
    for curx, cury in path.keys():
        graph[curx][cury] = int(sum / len(path.keys()))
    return True
cnt = 0
while True:
    cnt+=1
    prevgraph = copy.deepcopy(graph)
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                solve(i, j)
    if prevgraph == graph:
        print(cnt - 1)
        break