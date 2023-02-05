import sys
input = sys.stdin.readline

N, d, k, c = map(int, input().split()) # c를 제외한 k개를 선택하는 경우 > < c를 포함한 k개를 선택하는 경우
In = []

for _ in range(N):
    var = int(input().strip())
    In.append(var)
    
start = 0
end = k
maxcnt = 0
checker = {}
while True:
    if end > len(In)-1:
        end2 = end % len(In)
        if start == len(In):
            break
        curSet = set(In[start:] + In[:end2])
    else:
        curSet = set(In[start:end])
    if c in curSet:
        maxcnt = max(maxcnt, len(curSet)) 
    else:
        maxcnt = max(maxcnt, len(curSet) + 1)
    start+=1
    end+=1
print(maxcnt)