# 혼자 문제를 이해하고 풀어본 방식

n , m , k = map(int,input().split());

lst = list(map(int,input().split()));

lst.sort();
maxNum = lst[-1];
maxNum2 = lst[-2];

result = 0;
for i in range(m):
    
    if i%(k+1) == 0:
        result = result + maxNum2;
    else:
        result = result + maxNum;
    
print(result);

# 책에서 알려주는 효율적인 풀이 방식

# N, M, K를 공백으로로 구분하여 입력받기
n, m, k = map(int,input().split());

# N개의 수를 공백으로 구분하여 입력받기
data = list(map(int,input().split()));

data.sort();
first = data[n-1];
second = data[n-2];

# 가장 큰 수가 더해지는 횟수 계산
count = int(m / (k+1) ) * k;
count += m % (k+1)


result = 0;
result += (count) * first; # 가장 큰 수 더하기
result += (m - count) * second; # 두 번째로 큰 수 더하기

print(result);
