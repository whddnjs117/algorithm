n , m = map(int,input().split());



result = 0;
for i in range(m):
    data = list(map(int,input().split()));
    
    minNum = min(data);

    result = max(result , minNum);

print(result);
