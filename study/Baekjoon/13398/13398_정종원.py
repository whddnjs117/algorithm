n = int(input());


lst = list(map(int,input().split()));


dplst = [];
dp = [[0] * n for _ in range(0,2)] ;
ans = -1e9;

# 연속합의 최대값을 우선 구하기
# 배열자리 마다 연속합을 저장한다.
# dp[0] = 10
# dp[1] = max(10 -4 , -4)
# dp[2] = max(10 -4 + 3 , 3)
# .. dp[i] = dp[i-1] + lst[i] , dp[i]

# 두번째 최대값에서 해당 자리에 대한 값을 뺀경우의 값을 구한다
# dp[1][0] = 0 
# dp[1][1] = 숫자를 제거한 연속합 , 자기 자릿수 숫자를 제거한 연속합 = 10 , 10 -4
# dp[1][2] = 10 + 3 , 10 - 4
# dp[1][3] = 10 + 3 + 1 , 10 -4 + 3 
# .. 
# dp[1][n] = dp[1][n-1] + lst[n] , dp[0][n-1];
dp[0][0] = lst[0];
for i in range(1,n):


    dp[0][i] = max(dp[0][i-1] + lst[i] , lst[i]);
    dp[1][i] = max(dp[1][i-1] + lst[i] , dp[0][i-1]);
    ans = max(ans , dp[0][i] , dp[1][i]);

if n > 1:

    print(ans)
else:
    print(lst[0]);