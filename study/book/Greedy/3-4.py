n ,k = map(int,input().split());

result = 0;
count = 0;
while True:
    if n==1:
        break;

    if n%k==0:
        n = int(n/k);
    else:
        n = n-1;
    count += 1;

    if n==1:
        break;
print(count);