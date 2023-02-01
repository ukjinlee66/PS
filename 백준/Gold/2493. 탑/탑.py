import sys

input = sys.stdin.readline
N = int(input().strip())
graph = list(map(int,input().split()))
stack = [(0,graph[0])]
ret = [0 for i in range(len(graph))]
for i in range(1, len(graph)):
    while stack:
        if stack[-1][1] >= graph[i]:
            ret[i] = stack[-1][0] + 1
            break
        else:
            stack.pop()
    stack.append((i, graph[i]))
for i in range(len(ret)):
    if i == len(ret)-1:
        print(ret[i])
    else:
        print(ret[i], end=' ')