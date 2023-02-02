import sys
from collections import deque

input = sys.stdin.readline

T = int(input().rstrip())

while T > 0:
    command = str(input().rstrip())
    N = int(input().rstrip())
    arr = str(input().rstrip())
    err = False
    left = True
    if arr != '[]':
        D = deque(list(map(int,arr[1:len(arr)-1].split(','))))
    else:
        D = deque([])
    for com in command:
        if com == 'R':
            left = False if left == True else True
        else:
            if len(D) == 0:
                err = True
                break
            if left:
                D.popleft()
            else:
                D.pop()
    if left == True and D and not err:
        print(str(list(D)).replace(' ', ''))
    elif left == False and D and not err:
        print(str(list(reversed(list(D)))).replace(' ',''))
    elif err:
        print('error')
    else:
        print('[]')
    T-=1