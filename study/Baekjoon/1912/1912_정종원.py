
n = int(input());

lst = list(map(int,input().split()));

dp = [];
# 10 -4 3 1 5 6 -35 12 21 -1 의 최대값을 구해야함. 연속되게
# 10
# 10 -4
# 10 -4 +3
# 10 -4 +3 +1 ... 중최대값은

# -4
# 10 -4
# -4 +3
# -4 +3 +1 ..

# 3
# 10 -4 +3
# -4 +3
# +3 +1
# +3 +1 +5...

# 1
# 10 -4 +3 +1
# -4 +3 +1
# +3 +1 
# +1 +5 ...

# dp[0] = lst[0]
# dp[1] = lst[0] + lst[1]
# dp[2] = lst[0] + lst[1] + lst[2] .... 중 최대값
# dp[2] = dp[1] + lst[2]
# dp[n] = dp[n-1] + lst[n];


for i in range(0,n):
    dp.append(lst[i]);
    if i!=0:
        dp[i] = max(dp[i-1] +lst[i] , dp[i]);

print(max(dp));
