import sys
from collections import deque, defaultdict

input = sys.stdin.readline

N, Q = list(map(int,input().split()))
matrix = defaultdict(list)

for _ in range(N-1):
    a, b, c = list(map(int, input().split()))
    matrix[a].append((b , c))
    matrix[b].append((a , c))

def BFS(start, K):
    global matrix, visited

    D = deque()
    D.append(start)
    visited[start] = True
    cnt = 0
    while D:
        cur = D.popleft()
        for i in matrix[cur]:
            if i[1] >= K and not visited[i[0]]:
                cnt+=1
                D.append(i[0])
                visited[i[0]] = True
    return cnt
for _ in range(Q):
    K, node = list(map(int, input().split()))
    visited = [False] * (N + 1)
    print(BFS(node, K))