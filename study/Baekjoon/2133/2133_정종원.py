# 홀수는 아예경우의 수가 0

# dp[2] = 3
# dp[4] = dp[2] * 3 + 2;
# dp[6] = dp[4] * 3 + dp[2] * 2 + 2
# dp[8] = dp[6] * 3 + dp[4] * 2 + dp[2] * 2 + 2 

n = int(input());

dp = [0 for _ in range(31)];
dp[2] = 3;

for i in range(4,31,2):
    dp[i] = dp[i-2] * 3 + 2;
    for j in range(4,i,2):
        dp[i] += dp[i-j] * 2;

print(dp[n]);
