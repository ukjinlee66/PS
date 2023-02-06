import sys

input = sys.stdin.readline

score = {
    'A+' : 4.5,
    'A0' : 4.0,
    'B+' : 3.5,
    'B0' : 3.0,
    'C+' : 2.5,
    'C0' : 2.0,
    'D+' : 1.5,
    'D0' : 1.0,
    'F' : 0.0
}

hsum = 0
sum = 0

S = str(input().rstrip())
while True:
    try:
        a, b, c = S.split()
        if c != 'P':
            hsum += float(b)
            sum += (float(b) * float(score[c]))
    
        S = str(input().rstrip())
    except:
        print(sum/hsum)
        break