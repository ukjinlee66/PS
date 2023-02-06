import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline

class Node(object):
    def __init__(self, key, value=None):
        self.key = key
        self.value = value
        self.children = {}
class Trie:
    def __init__(self):
        self.head = Node(None)
    
    def insert(self, string):
        curNode = self.head

        for ch in string:
            if ch not in curNode.children:
                curNode.children[ch] = Node(ch)
            curNode = curNode.children[ch]
        curNode.value='\\'.join(string)

    def search(self, string):
        curNode = self.head

        for ch in string:
            if ch in curNode.children:
                print(ch)
                curNode = curNode.children[ch]
            else:
                return False
        if curNode.value != None:
            return curNode.value
        else:
            return False

    def printAll(self):
        def pri(curNode, i):
            if curNode.children == {}:
                return
            li = sorted(list(curNode.children))
            for c in li:
                print(i+c)
                pri(curNode.children[c], i+' ')
        
        curNode = self.head
        pri(curNode,'')


T = int(input().rstrip())
trie = Trie()
for _ in range(T):
    S = str(input().rstrip())
    lis = list(map(str, S.split('\\')))
    trie.insert(lis)
    
trie.printAll()