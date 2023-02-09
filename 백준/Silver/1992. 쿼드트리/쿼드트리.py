import sys
input = sys.stdin.readline
N = int(input().rstrip())
lis = [list(map(str,input().rstrip())) for _ in range(N)]

def solution(li):
    if len(li) == 1 and len(li[0]) == 1:
        print(li[0][0], end='')
        return

    if checker(li):
        print(li[0][0],end='')
        return

    n = len(li)
    print('(',end='')
    solution([row[:n//2] for row in li[:n//2]])
    solution([row[n//2:n] for row in li[:n//2]])
    solution([row[:n//2] for row in li[n//2:n]])
    solution([row[n//2:n] for row in li[n//2:n]])
    print(')',end='')
    return
    
def checker(li):
    t = li[0][0]
    for i in range(len(li)):
        for j in range(len(li[0])):
            if li[i][j] != t:
                return False
    return True

solution(lis)