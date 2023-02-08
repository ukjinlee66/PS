import sys
from collections import deque
input = sys.stdin.readline
N, M = list(map(int,input().split()))
adj = [ [] for _ in range(N+1)]
INF = int(1e9)
ret = INF
subret = INF
retid = INF
for _ in range(M):
    start, end = list(map(int, input().split()))
    adj[start].append(end)
    adj[end].append(start)

def BFS(start):
    global adj, visit
    visit[start]= True
    ret = 0
    d = deque()
    d.append((start,0))
    while d:
        cur, score = d.popleft()
        ret+=score
        for i in adj[cur]:
            if not visit[i]:
                visit[i] = True
                d.append((i, score + 1))
    return ret

for i in range(1,N+1):
    visit = [False] * (N + 1)
    a = BFS(i)
    if a < ret:
        ret = a
        retid = i
print(retid)