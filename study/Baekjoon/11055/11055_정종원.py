n = int(input());


lst = list(map(int,input().split()));



# 1 100 2 50 60 3 5 6 7 8
# 1 101 3 53 113 ...

dp = [i for  i in lst];
for i in range(0,n):

    for j in range(i):
        if lst[i] > lst[j] :
            dp[i] = max(dp[i] , dp[i] + lst[j]);

print(max(dp));