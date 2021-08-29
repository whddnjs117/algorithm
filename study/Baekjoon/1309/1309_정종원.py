# 1
# 3

# 2
# 7

# 3
# 17

# 4
# 41

# dp[n] = (dp[n-1] * 2) + dp[n-2]

n = int(input());

dp = [0,3,7];
for i in range(3,n+1):
    dp.append(i);

    dp[i] = ((dp[i-1] * 2) + dp[i-2] ) % 9901;

print(dp[n]); 