import sys
input = sys.stdin.readline
INF = int(1e9)
M, N = list(map(int,input().split()))
graph = []
W = [['' for _ in range(8)] for _ in range(8)]
B = [['' for _ in range(8)] for _ in range(8)]
W[0][0] = 'W'
B[0][0] = 'B'
for i in range(8):
    for j in range(8):
        if i == 0 and j == 0:
            continue
        if j != 0:
            W[i][j] = 'W' if W[i][j-1] == 'B' else 'B'
            B[i][j] = 'W' if B[i][j-1] == 'B' else 'B'
        elif i != 0:
            W[i][j] = 'W' if W[i-1][j] == 'B' else 'B'
            B[i][j] = 'W' if B[i-1][j] == 'B' else 'B'

for _ in range(M):
    graph.append(list(map(str,input().rstrip())))

def diffList(A, B):
    cnt = 0
    for i in range(len(A)):
        for j in range(len(A[0])):
            if A[i][j] != B[i][j]:
                cnt+=1
    return cnt

ret = INF
for i in range(M-7):
    for j in range(N-7):
        temp = [row[j:j+8] for row in graph[i:i+8]]
        ret = min(ret, diffList(temp, W))
        ret = min(ret, diffList(temp, B))
print(ret if ret != INF else 0)