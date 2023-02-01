import sys
import queue
input = sys.stdin.readline
INF = int(1e9)
MAXN = 100000
N, K = map(int, input().split())
visited = [False] * (MAXN + 1)
q = queue.Queue()
q.put((N,0))
ret = INF
retCount = 0
time = 0
while not q.empty():
    current, time = q.get()
    if current < 0 or current > MAXN:
        continue
    visited[current] = True
    if current == K:
        if ret > time:
            ret = time
            retCount = 1
        elif ret == time:
            retCount += 1
        continue
    if (current - 1) >= 0 and not visited[current - 1]:
        q.put(((current - 1), time + 1))
    if current < K and (current + 1) <= MAXN and not visited[current + 1]:
        q.put(((current + 1), time + 1))
    if current < K and (current * 2) <= MAXN and not visited[current * 2]:
        q.put(((current * 2), time))
print(ret)