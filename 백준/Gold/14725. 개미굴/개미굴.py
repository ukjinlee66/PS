import sys
input = sys.stdin.readline

sys.setrecursionlimit(15000)

class Node(object):
    def __init__(self, key, value = None):
        self.key = key
        self.value = value
        self.children = {}

class Trie:
    def __init__(self):
        self.head = Node(None)

    def searchInsert(self, string):
        cur = self.head
        cnt = -1
        for ch in string:
            cnt+=1
            if ch in cur.children:
                cur = cur.children[ch]
            else:
                str = '--' * cnt
                print(str + ch)
                cur.children[ch] = Node(ch)
                cur = cur.children[ch]
        cur.value = string
            

N = int(input().strip())
tree = []
for i in range(N):
    eat = list(map(str,input().split()))
    tree.append(eat[1:])
tree = sorted(tree)
trie = Trie()
for eat in tree:
    trie.searchInsert(eat)