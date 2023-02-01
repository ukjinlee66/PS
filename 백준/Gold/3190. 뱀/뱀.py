from collections import deque
import sys
map = [[0]*101 for i in range(101)]
dir = [[0,1],[1,0],[0,-1],[-1,0]]
cur_dir = 0
sna = deque()
curtime = 0
time = deque()
check = False
N = int(sys.stdin.readline().strip())
K = int(sys.stdin.readline().strip())
for i in range(K):
    app = (sys.stdin.readline().strip()).split(" ")
    map[int(app[0])-1][int(app[1])-1] = 1
map[0][0]=2
L = int(sys.stdin.readline().strip())
# L 반시계 D 시계
for i in range(L):
    dd = (sys.stdin.readline().strip()).split(" ")
    time.append([int(dd[0]), dd[1]])
sna.append([0,0])
if len(time) > 0:
    next = time.popleft()
    next_time = int(next[0])
    next_dir = 1 if next[1] == 'D' else -1
while len(sna) > 0:
    curtime+=1
    # move
    i = sna.pop()
    sna.append(i)
    cur_x = i[0] + dir[cur_dir][0]
    cur_y = i[1] + dir[cur_dir][1]
    # Game Over
    if cur_x < 0 or cur_y < 0 or cur_x > N-1 or cur_y > N-1 or [cur_x,cur_y] in sna:
        print(curtime)
        sys.exit(0)
    # find apple
    if map[cur_x][cur_y] == 1:
        map[cur_x][cur_y] = 0
    else:
        if len(sna) > 0:
            sna.popleft()
    map[i[0]][i[1]] = 0
    sna.append([cur_x,cur_y])
    map[cur_x][cur_y] = 2
    # direction
    if curtime == next_time:
        cur_dir += next_dir
        if cur_dir < 0:
            cur_dir = 4 + cur_dir
        elif cur_dir > 3:
            cur_dir = cur_dir - 4
        if len(time) > 0:
            next = time.popleft()
            next_time = int(next[0])
            next_dir = 1 if next[1] == 'D' else -1