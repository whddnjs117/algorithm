# 1
# 1

# 2
# 2

# 3
# 4

# 4
# 7

# 5
# 1 + 1 + 1 + 1 + 1 
# 1 + 1 + 1 + 2
# 1 + 1 + 2 + 1
# 1 + 2 + 1 + 1
# 2 + 1 + 1 + 1
# 2 + 1 + 2 
# 2 + 2 + 1
# 1 + 2 + 2
# 1 + 1 + 3
# 1 + 3 + 1
# 3 + 1 + 1
# 3 + 2 
# 2 + 3
# 13

# dp[n] = dp[n-1] + dp[n-2] + dp[n-3];

n = int(input());

dp = [0] * 4;
dp[1] = 1;
dp[2] = 2;
dp[3] = 4;
for i in range(n):
    number = int(input());
    if number+1 > dp.__len__():
        for j in range(dp.__len__(),number+1):
            dp.append(0);
            dp[j] = (dp[j-1] + dp[j-2] + dp[j-3])% 1000000009;
    print(dp[number]);