import sys
from collections import deque
input = sys.stdin.readline
MAXN = 100010
visited = [-1] * (MAXN)
N, K = map(int, input().split())
def bfs(start, dest):
    q = deque()
    q.append((start, 0))
    visited[start] = start
    while q:
        current, time = q.popleft()
        if current == dest:
            print(time)
            ret = []
            while start != current:
                ret.append(current)
                current = visited[current]
            ret.append(start)
            ret.reverse()
            print(' '.join(map(str,ret)))
            return
        for next in (current - 1, current + 1, current * 2):
            if MAXN > next and next >= 0:
                if visited[next] == -1:
                    visited[next] = current
                    q.append((next, time + 1))
bfs(N, K)