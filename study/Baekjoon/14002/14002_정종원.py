n = int(input());

array = list(map(int , input().split()));

dp = [1] * array.__len__();

for i in range(0,array.__len__()):
    for j in range(0,i):
        if array[i] > array[j]:
            dp[i] = max(dp[i] , dp[j] + 1);

print(max(dp));
# 여기까지는 11053문제를 구하는 가장긴 배열을 구하는 문제
# 배열을 이용하여 각자 자리값을 구하였으니
# 그자리값에 포함되는 숫자를 출력하면 배열에 들어가는 숫자를 구하게 된다.
# 문제   10 20 10 30 20 50
# 결과    1  2  1  3  2  4 
# 배열   10 20 30 50
# 인덱스  1  2  3  4 

order = max(dp);
lst = [];
for i in range(n-1,-1,-1):
    if dp[i] == order :
        lst.append(array[i])
        order -= 1;
# 배열을 뒤집어 주는 작업
lst.reverse();
for i in lst:
    print(i,end=' ');

