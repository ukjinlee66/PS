import sys

input = sys.stdin.readline

H, W = list(map(int,input().split()))

sgraph = list(map(int,input().split()))
ret = 0

def solve(graph):
    ret1 = 0
    lef = -1
    rig = -1
    for i in range(1,len(graph)-1):
        lef = max(graph[:i])
        rig = max(graph[i+1:])
        cost = (lef if lef <= rig else rig) - graph[i]
        ret1 += cost if cost > 0 else 0
    return ret1

ret += solve(sgraph)
print(ret)