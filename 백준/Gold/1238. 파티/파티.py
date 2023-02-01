import sys
import heapq

input = sys.stdin.readline
N, M, X = map(int,input().split())
INF = int(1e9)
graph = [[] for _ in range(N + 1)]
inversegraph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)

for i in range(0,M):
    start, end, cost = map(int, input().split())
    graph[start].append((end, cost))
    inversegraph[end].append((start, cost))

def dijkstra(graph, start):
    q = []
    heapq.heappush(q, (0,start))
    distance[start] = 0
    while q:
        dist, node = heapq.heappop(q)
        if distance[node] < dist: continue
        for next in graph[node]:
            cost = distance[node] + next[1]
            if cost < distance[next[0]]:
                distance[next[0]] = cost
                heapq.heappush(q, (cost, next[0]))

dijkstra(graph, X)
definitionToHome = distance
distance = [INF] * (N + 1)
dijkstra(inversegraph, X)

ret_val = -INF
for i in range(len(distance)):
    if distance[i] != INF and definitionToHome[i] != INF:
        ret_val = max(ret_val, distance[i] + definitionToHome[i])
print(ret_val)