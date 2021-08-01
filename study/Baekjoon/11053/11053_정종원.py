
# 처음에는 정렬을 하고 정렬된 수를 뽑으면 되지않을까를 판단.

# n = int(input());

# array = list(map(int,input().split()));

# dp = [];

# for i in range(0,array.__len__(), 1):

    
#     if i == 0 :
#         dp.append(array[i]);
#     elif int(max(dp)) < array[i]:
#         dp.append(array[i]);

# print(dp);

# 그러나 문제의 의도는 그것이 아니다.
# 최대 증가 부분 수열은 
# 예를 들어 배열 1 5 3 6 7 일경우에는 최대로 증가할수잇는 배열의 수는 1 3 6 7 이므로 4이다.
# 연속적으로 증가하는 배열의 최대값을 구하는것이 문제의 의도이다.
# 각 자릿수 마다 배열의 증가하는 최대값을 구하여 배열이 완성한다.-


n = int(input());

array = list(map(int , input().split()));

# 배열의 길이만큼 생성 
# 벡준 카드 구매하기 랑 비슷한 맥락이다.
# 10 20 10 30 20 50 일경우
# 1  2  1  3  2  4
# 배열을 반복하며, 전에 숫자보다 클경우 +1을 해주는 형식

dp = [1] * array.__len__();

for i in range(0,array.__len__()):

    for j in range(0,i):
        if array[i] > array[j]:
            dp[i] = max(dp[i] , dp[j] + 1);

print(max(dp));