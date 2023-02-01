import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)
num = 1
N = int(input().rstrip())

while N != 0:
    graph = [list(map(int,input().split())) for _ in range(N)]
    distance = [[INF] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]
    q = [[graph[0][0], 0, 0]]
    distance[0][0] = graph[0][0]
    while q:
        cost, curx, cury = heapq.heappop(q)
        visited[curx][cury] = True
        for next in ((curx + 1, cury), (curx, cury + 1), (curx - 1, cury), (curx, cury - 1)):
            if (next[0] < 0 or next[1] < 0 or next[0] >= N or next[1] >= N) or visited[next[0]][next[1]]:
                continue
            if distance[next[0]][next[1]] > cost + graph[next[0]][next[1]]:
                distance[next[0]][next[1]] = cost + graph[next[0]][next[1]]
                heapq.heappush(q,[distance[next[0]][next[1]], next[0], next[1]])
    print("Problem " + str(num) + ": "+str(distance[N-1][N-1]))
    num+=1
    N = int(input())