import sys

N = int(sys.stdin.readline().strip())
new_list = []
ret = 0
idx = 0
N2 = sys.stdin.readline().split()
for i in N2:
    new_list.append(int(i))
new_list = sorted(new_list)
for idx, i in enumerate(new_list):
    start = 0
    end = len(new_list)-1
    target = i
    while (start < end):
        if start == idx:
            start+=1
            continue
        if end == idx:
            end-=1
            continue
        if new_list[start] + new_list[end] == target:
            ret+=1
            break
        elif new_list[start] + new_list[end] < target:
            start+=1
        elif new_list[start] + new_list[end] > target:
            end-=1
print(ret)