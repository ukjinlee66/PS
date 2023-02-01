import sys
input = sys.stdin.readline
import heapq
INF = int(1e9)
N, M = list(map(int,input().split()))
graph = [[] for _ in range(N)]
distance = [INF] * (N)

for _ in range(M):
    A, B, C = list(map(int, input().split()))
    graph[A-1].append((B-1, C))
    graph[B-1].append((A-1, C))

def dijkstra(start):
    global distance, graph
    H = []
    distance[start] = 0
    heapq.heappush(H, (distance[start], start))
    

    while H:
        dist, node = heapq.heappop(H)

        if distance[node] < dist:
            continue
        for no, co in graph[node]:
            cost = co + distance[node]
            if cost < distance[no]:
                distance[no] = cost
                heapq.heappush(H, (cost, no))


dijkstra(0)
print(distance[N - 1])