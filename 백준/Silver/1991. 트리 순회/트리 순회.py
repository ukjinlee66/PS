import sys
input = sys.stdin.readline

class Node(object):
    def __init__(self, val, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

def preorder(node):
    print(tree[node.val].val, end='')
    if node.left != None:
        preorder(tree[node.left])
    if node.right != None:
        preorder(tree[node.right])
    return

def postorder(node):
    if node.left != None:
        postorder(tree[node.left])
    if node.right != None:
        postorder(tree[node.right])
    print(tree[node.val].val, end='')
    return

def inorder(node):
    if node.left != None:
        inorder(tree[node.left])
    print(tree[node.val].val, end='')
    if node.right != None:
        inorder(tree[node.right])
    return

N = int(input().rstrip())
cur_node = None
root = None
tree = {}
for _ in range(N):
    val , left, right = list(map(str,input().split()))
    left = None if left == '.' else left
    right = None if right == '.' else right
    new_node = Node(val,left,right)
    tree[val] = new_node

preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])