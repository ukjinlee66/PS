import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000000)
score = {
    1 : 0,
    2 : 0,
    3 : 1,
    4 : 1,
    5 : 2,
    6 : 3,
    7 : 5,
    8 : 11
}
class Node(object):
    def __init__(self, key, value=None):
        self.key = key
        self.value = value
        self.children = {}
class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self, string):
        curnode = self.head

        for ch in string:
            if ch not in curnode.children:
                curnode.children[ch] = Node(ch)
            curnode = curnode.children[ch]
        curnode.value=string

    def search(self, string):
        curnode = self.head

        for ch in string:
            if ch in curnode.children:
                curnode = curnode.children[ch]
            else:
                return False
        if curnode.value != None:
            return curnode.value
        else:
            return False

trie = Trie()
def DFS(curx, cury, st):
    global trie, retcnt, retscore, retstring, arr, rr, visit
    if len(st) > 8:
        return
    if st not in rr and trie.search(st) == st:
        retcnt+=1
        rr[st] = True
        if len(retstring) == len(st):
            if retstring > st:
                retstring = st
        elif len(retstring) < len(st):
            retstring = st
        retscore += score[len(st)]
    for nextx, nexty in ((curx + 1, cury), (curx - 1, cury), (curx, cury + 1), (curx, cury - 1), (curx - 1, cury - 1), (curx + 1, cury + 1), (curx + 1, cury - 1), (curx - 1, cury + 1)):
        if nextx < 0 or nexty < 0 or nextx >=4 or nexty >=4 or visit[nextx][nexty]:
            continue
        visit[nextx][nexty] = True
        DFS(nextx, nexty, st+arr[nextx][nexty])
        visit[nextx][nexty] = False
    return
T = int(input().rstrip())
for _ in range(T):
    In = str(input().rstrip())
    trie.insert(In)
dummy = input()
M = int(input().rstrip())
for _ in range(M):
    arr = [list(map(str,input().rstrip())) for _ in range(4)]
    rr = {}
    retscore = 0
    retstring = ''
    retcnt = 0
    for i in range(4):
        for j in range(4):
            visit = [[False for _ in range(4)] for _ in range(4)]
            visit[i][j]=True
            DFS(i, j, str(arr[i][j]))
    if retstring != '':
        print(str(retscore) + ' ' + retstring + ' ' +str(retcnt))
    else:
        print(str(retscore) + ' ' +str(retcnt))
    dummy = input()