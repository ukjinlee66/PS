import sys
input = sys.stdin.readline
N = int(input().rstrip())
graph = [ [0 for _ in range(N)] for _ in range(N)]
for i in range(N):
    In = list(map(int, input().split()))
    for j in range(len(In)):
        graph[i][j] = In[j]

for i in range(1,N):
    for j in range(N):
        if j != 0:
            graph[i][j] = max(graph[i-1][j], graph[i-1][j-1]) + graph[i][j]
        else:
            graph[i][j] = graph[i-1][j] + graph[i][j]
print(max(graph[N-1]))