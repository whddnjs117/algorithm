
n = int(input());

array = [0,1,2,3];

for i in range(3,n+1):
    array.append(i)
    array[i] = array[i-1] + array[i-2]

print(array[n] % 10007);
