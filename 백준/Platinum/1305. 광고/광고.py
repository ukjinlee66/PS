import sys
input = sys.stdin.readline

def KMP_Init(pattern):
    arr = [0 for _ in range(len(pattern))]

    idx2 = 0
    for idx in range(1, len(pattern)): # fill arr
        
        while idx2 > 0 and pattern[idx] != pattern[idx2]:
            idx2 = arr[idx2 - 1]

        if pattern[idx] == pattern[idx2]:
            idx2 += 1
            arr[idx] = idx2
    return arr

def KMP(word, pattern):
    arr = KMP_Init(pattern)

    res = []
    idx2 = int(0)

    for idx in range(len(word)):
        while idx2 > 0 and word[idx] != pattern[idx2]:
            idx2 = arr[idx2 - 1]
            
        if word[idx] == pattern[idx2]:
            if idx2 == len(pattern) - 1:
                res.append(str(idx - len(pattern) + 2))
                idx2 = arr[idx2]
            else:
                idx2 += 1
    return res

L = int(input().strip())
st = str(input().rstrip())
arr = KMP_Init(st)
print(L - arr[L-1] if arr[L - 1] != 0 else L)