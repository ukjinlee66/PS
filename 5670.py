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
            curNode=curNode.children[char]
        curNode.value = string # 문자열의 끝 부분은 value로 문자열값 자체를 할당

    def search(self, string):
        curNode = self.head
        cnt = 0
        if curNode.key == None: # Head Case
            if len(curNode.children) == 1:
                cnt+=1
        for char in string:
            if curNode.value != None or len(curNode.children) > 1:
                cnt+=1
            curNode = curNode.children[char]
        return cnt

N = int(input())
while N >= 1:
    trie = Trie()
    In = []
    for _ in range(N):
        string = str(input().rstrip())
        In.append(string)
        trie.insert(string)
    sum = 0
    for string in In:
        sum += trie.search(string)
    print('{:.2f}'.format((sum/len(In))))
    try:
        N = int(input())
    except:
        break