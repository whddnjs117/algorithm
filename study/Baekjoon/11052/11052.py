n = int(input())
card = [0]
card += list(map(int, input().split()))

# 카드의 길이만큼 배열생성
dp = [0] * card.__len__();
# 카드팩 1개 사기
# dp[1] = card[1]
# 카드팩 2개 사기
# dp[2] = card[2] , card[1] * 2
# 카드팩 3개 사기
# dp[3] = card[3] , card[2] + card[1] , card[1] * 3
# 카드팩 4개 사기
# dp[4] = card[4] , card[3] + card[1] , card[2] + card[2] , card[1] * 4
# 식정리
# dp[n] = card[n] , card[n-1] + card[1] , card[n-2] + card[2] ,card[n-3] + card[3] .... = dp[n] , dp[n-i]+dp[i]


for i in range(1,n+1):
    # dp[n] = card[n] 의 값을 저장한다. 카드팩 n개를 구매하기위해 card[n]값을 지불을 위해 
    dp[i] = card[i];
    for j in range(1,i):
        dp[i] = max(dp[i] , dp[i-j] + dp[j]);

print(dp[n]);