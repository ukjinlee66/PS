import sys

input = sys.stdin.readline
N, K = map(int,input().split())
conv = list(map(int,input().split()))
robot = [False for _ in range(2 * N)]
time = 0

# 0. 로봇 올릴 수 있으면 올리고 내릴 수 있으면 내림
# 1. 내구도와 로봇의 위치 이동
# 2. 로봇 이동가능하다면 이동 (이동칸에 로봇없으며 내구도 1 이상 조건)
# 3. 올리는위치 내구도 1이상일 경우 로봇 올림
# 4. 내구도 0인 칸의 개수 K개 이상일 경우 종료 -> 반환 ->아닐경우 1 반복

def checkCount(): # 4
    global conv
    cnt = 0
    for i in range(2 * N):
        if conv[i] == 0:
            cnt+=1
    return False if cnt >= K else True

def moveconv():
    global conv, robot

    prevconv = conv[:] # 컨베이어벨트 위치
    prevrobot = robot[:] # 로봇 위치

    for i in range(0, 2 * N):
        if i == N - 1 and robot[i]: # 이동 후 로봇이 내리는지점에 도착 할 경우 내림
            robot[i] = False
        idx = i + 1 if i + 1 <= (2*N) - 1 else 0
        conv[idx] = prevconv[i]
        robot[idx] = prevrobot[i]
        
        
def moverobot():
    global conv, robot
    for i in range(N - 2, 0, -1):
        idx = i + 1
        if robot[idx] == False and robot[i] and conv[idx] >= 1: # 이전 위치 로봇이 존재할 때
            robot[idx] = True # 로봇 이동
            robot[i] = False
            conv[idx] -= 1
    if robot[N-1]:
        robot[N-1] = False
while True:
    time+=1
    moveconv()
    moverobot()
    if conv[0] >= 1 and robot[0] == False: # 3. 로봇 올림
        robot[0] = True
        conv[0] -= 1
    if checkCount() == False:
        break
print(time)






                