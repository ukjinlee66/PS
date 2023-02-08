import sys
import heapq
input = sys.stdin.readline
T = int(input().rstrip())
for _ in range(T):
    c = int(input().rstrip())
    minH = []
    maxH = []
    visit = [False] * c
    for k in range(c):
        command, content = list(map(str,input().split()))
        if command == 'I':
            heapq.heappush(minH,(int(content), k))
            heapq.heappush(maxH,(-int(content), k))
            visit[k] = True
        else:
            if content == '1':
                while maxH and not visit[maxH[0][1]]:
                    heapq.heappop(maxH)
                if maxH:
                    visit[maxH[0][1]] = False
                    heapq.heappop(maxH)
            else:
                while minH and not visit[minH[0][1]]:
                    heapq.heappop(minH)
                if minH:
                    visit[minH[0][1]] = False
                    heapq.heappop(minH)
    while minH and not visit[minH[0][1]]:
        heapq.heappop(minH)
    while maxH and not visit[maxH[0][1]]:
        heapq.heappop(maxH)
    if minH and maxH:
        print(-maxH[0][0], minH[0][0])
    else:
        print('EMPTY')