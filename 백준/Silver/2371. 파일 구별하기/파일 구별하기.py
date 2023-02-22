import sys
input = sys.stdin.readline

N = int( input().rstrip())
arr =[]
minlen=100000000000
maxlen=0
for _ in range(N):
    li = list(map(str,input().split()))
    arr.append(li[:len(li)-1])
    minlen=min(minlen, len(li)-1)
    maxlen=max(maxlen, len(li)-1)

for i in range(minlen, maxlen+1):
    check = {}
    flag = True
    for j in range(N):
        S = ''
        if i == len(arr[j]):
            S = ''.join(arr[j])
        elif i < len(arr[j]):
            S = ''.join(arr[j][:i])
        else:
            S = ''.join(arr[j]) + (i-len(arr[j])) * '0'
        if S in check:
            flag = False
            break
        else:
            check[S] = True
    if flag:
        print(i)
        exit()