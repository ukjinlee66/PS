import sys,copy
N = sys.stdin.readline().split()
R = int(N[0])
C = int(N[1])
ret = 0
temp = 1
arr = [[0 for col in range(1001)] for row in range(1001)]
for i in range(R):
    N2 = sys.stdin.readline().strip()
    for idx,j in enumerate(N2):
        arr[i][idx] = j
new_dict={}
for i in range(C):
    st=""
    for j in range(R):
        st+=arr[j][i]
    new_dict[st]=True
for k in range(R):
    temp = copy.deepcopy(new_dict)
    for i,val in new_dict.items():
        if i[k+1:] in temp.keys():
            print(k)
            sys.exit(0)
        else:
            temp[i[k+1:]] = True
print(R)