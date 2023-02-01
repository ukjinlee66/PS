import sys
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
        curNode = self.head # 시작은 Head노드부터

        for char in string:
            if char not in curNode.children:
                curNode.children[char] = Node(char) # 해당 문자가 존재하지 않을 경우 새로운 노드를 생성
            elif curNode.children[char].value != None:
                return False
            curNode=curNode.children[char]
        curNode.value = string # 문자열의 끝 부분은 value로 문자열값 자체를 할당
        if len(curNode.children) > 0:
            return False

T = int(input().rstrip())
for _ in range(T):
    trie = Trie()
    N = int(input().rstrip())
    checker = False
    for _ in range(N):
        string = map(str,input().rstrip())
        if trie.insert(string) == False:
            checker=True
    print('NO') if checker else print('YES')