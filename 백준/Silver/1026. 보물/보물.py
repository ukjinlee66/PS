import sys
input = sys.stdin.readline

N = int(input().rstrip())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
A = sorted(A)
B = sorted(B, reverse=True)
sum = 0
for i in range(N):
    sum+= A[i] * B[i]
print(sum)