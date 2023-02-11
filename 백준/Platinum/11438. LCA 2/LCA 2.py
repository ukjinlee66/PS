import collections
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 8)

n = int(input())
graph = collections.defaultdict(list)
for _ in range(n - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)


h = [0 for _ in range(n+1)]
for i in range(2, n+1):
    h[i] = h[i>>1] + 1
height = h[-1]

d = [0 for _ in range(n)]  # depth table
parent = [[0 for _ in range(n)] for _ in range(height+1)]
visited = [False for _ in range(n)]


def dfs(node, depth):
    d[node - 1] = depth

    for next in graph[node]:
        if not visited[next - 1]:
            visited[next - 1] = True
            parent[0][next - 1] = node
            dfs(next, depth + 1)


start = 1
visited[start - 1] = True
dfs(start, 0)

# set parents
for i in range(1, h[-1] + 1):
    for j in range(n):
        mid = parent[i - 1][j]
        parent[i][j] = parent[i - 1][mid - 1]


# LCA
def lca(a, b):
    # 깊이가 더 깊은 노드를 a로 만들어주기
    if d[a - 1] < d[b - 1]:
        a, b = b, a

    # 같은 깊이로 맞추기
    diff = d[a - 1] - d[b - 1]
    for i in range(height, -1, -1):
        if diff & (1 << i):
            diff -= (1 << i)
            a = parent[i][a - 1]

    if a == b:
        return a

    # 위에서부터 내려오며 LCA 찾기
    for i in range(height, -1, -1):
        if parent[i][a - 1] != parent[i][b - 1]:
            a = parent[i][a - 1]
            b = parent[i][b - 1]

    return parent[0][a - 1]


m = int(input())
for _ in range(m):
    x, y = map(int, input().split())
    print(lca(x, y))