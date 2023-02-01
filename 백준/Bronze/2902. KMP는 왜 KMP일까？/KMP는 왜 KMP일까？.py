import sys
input = sys.stdin.readline

st = str(input().rstrip())
ar = st.split('-')
ret = ''
for c in ar:
    ret += c[0]
print(ret)