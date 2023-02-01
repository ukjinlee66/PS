import sys
input = sys.stdin.readline

sys.setrecursionlimit(15000)
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
        return True

first = {}
N, M = list(map(int,input().split()))
trie = Trie()
ans = 0
for _ in range(N):
    temp = str(input().strip())
    trie.insert(temp)
for _ in range(M):
    temp = str(input().strip())
    if trie.search(temp):
        ans+=1
print(ans)