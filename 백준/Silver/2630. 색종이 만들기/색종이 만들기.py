import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline
N = int(input().rstrip())
w = 0
b = 0
graph = [list(map(int,input().split()))for _ in range(N)]
def solution(G):
    global w, b

    n = len(G)
    if len(G) == 1 and len(G[0]) == 1:
        if G[0][0] == 1:
            b+=1
        else:
            w+=1
        return
    if checkgraph(G):
        if G[0][0] == 0:
            w+=1
        else:
            b+=1
        return
    solution([row[0:n//2] for row in G[0:n//2]])
    solution([row[n//2:n] for row in G[0:n//2]])
    solution([row[0:n//2] for row in G[n//2:n]])
    solution([row[n//2:n] for row in G[n//2:n]])
    return

def checkgraph(G):
    temp = G[0][0]
    for i in range(len(G)):
        for j in range(len(G[0])):
            if G[i][j] != temp:
                return False
    return True

solution(graph)
print(w)
print(b)