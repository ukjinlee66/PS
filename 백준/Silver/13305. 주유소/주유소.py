import sys
import heapq
input = sys.stdin.readline
N = int( input().rstrip())
dist = list(map(int, input().split()))
cost = list(map(int, input().split()))
min_cost = cost[0]
sum = 0
for i in range(len(dist)):
    sum += min_cost*dist[i]
    if min_cost > cost[i+1]:
        min_cost = cost[i+1]
print(sum)