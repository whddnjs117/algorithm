n = 9;

lst = [0] * n;



for i in range(n):

    lst[i] = int(input());

total = sum(lst);
for i in range(n):
    for j in range(i+1 , n):
        num1 , num2 = lst[i] , lst[j]

        if 100 == total - (num1 + num2):
            
            lst.remove(num1);
            lst.remove(num2);
            lst.sort()
        
            print("**************************");
            for num in lst:
                print(num);
            break;
    if lst.__len__() < 8:
        break;

