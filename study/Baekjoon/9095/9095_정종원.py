n = int(input());


# 1 일 경우
# dp[1] = 1 가지
# 2 일 경우
# dp[2] = (1+1) , (2) = 2 가지
# 3 일 경우
# dp[3] = (1+1+1) , (1+2) , (2+1) , (3) = 4가지
# 4 일 경우
# dp[4] = (1+1+1+1) , (1+1+2) , (1+2+1) , (2+1+1) , (2+2) , (1+3) , (3+1) = 7가지
# 5 일 경우
# dp[5] = (1+1+1+1+1) , (1+1+1+2) , (1+1+2+1) , (1+2+1+1) , (2+1+1+1) , (1+2+2) , (2+1+2) , (2+2+1) , (1+1+3) , (1+3+1) , (3+1+1) , (3+2) , (2+3) = 13가지
# 점화식
# dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
dp = [1,2,4];

for i in range(0,n):
    
    num = int(input());
    if num >= 4 :
        for j in range(3,num+1):
            dp.append(j)
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
    print(dp[num-1]);