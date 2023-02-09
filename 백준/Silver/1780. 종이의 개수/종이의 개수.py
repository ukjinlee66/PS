import sys
input = sys.stdin.readline
N = int(input().rstrip())
graph = [list(map(int,input().split())) for _ in range(N)]
lis = [0] * 3
def checkgraph(G):
    t = G[0][0]
    for i in range(len(G)):
        for j in range(len(G[0])):
            if t != G[i][j]:
                return False
    return True

def solution(G):
    global lis
    if len(G) == 1 and len(G[0]) == 1:
        lis[G[0][0] + 1] += 1
        return
    if checkgraph(G):
        lis[G[0][0] + 1] += 1
        return
    
    n = len(G)
    solution([row[:n//3] for row in G[:n//3]])
    solution([row[n//3:2*n//3] for row in G[:n//3]])
    solution([row[:n//3] for row in G[n//3:2*n//3]])
    solution([row[2*n//3:n] for row in G[:n//3]])
    solution([row[:n//3] for row in G[2*n//3:n]])
    solution([row[n//3:2*n//3] for row in G[n//3:2*n//3]])
    solution([row[n//3:2*n//3] for row in G[2*n//3:n]])
    solution([row[2*n//3:n] for row in G[n//3:2*n//3]])
    solution([row[2*n//3:n] for row in G[2*n//3:n]])
    return
solution(graph)
for c in lis:
    print(c)