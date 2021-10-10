n = int(input());

lst = list(map(int,input().split()));

dl = [1] * n;
dr = [1] * n;
for i in range(0,n):

    for j in range(0,i):

        if lst[i] > lst[j]:
            dl[i] = max(dl[i], dl[j]+1);
for i in range(n-1,-1,-1):

    for j in range(n-1,i,-1):

        if lst[i] > lst[j]:
            dr[i] = max(dr[i], dr[j]+1);

result = [0] * n
for i in range(n):
    result[i] = dl[i] + dr[i] -1

print(max(result))