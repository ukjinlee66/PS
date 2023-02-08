import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000000)
node, edge = map(int, input().split())

adj = [ [] for _ in range(node+1)]
visit = [False] * (node+1)
for _ in range(edge):
    start, end = list(map(int, input().split()))
    adj[start].append(end)
    adj[end].append(start)

def DFS(x):
    global adj, visit
    visit[x] = True

    for i in adj[x]:
        if not visit[i]:
            DFS(i)
ret = 0
for i in range(1, node+1):
    if not visit[i]:
        ret += 1
        DFS(i)
print(ret)