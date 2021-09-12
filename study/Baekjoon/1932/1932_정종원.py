n = int(input());


lst = [];



for i in range(n):
    lst.append(list(map(int,input().split())));


#   7
#  3 8
# 8 1 0

#  lst[0]
# 3+7 , 8+7
# 7+3+8 , 7+3+8 or 3+8+1 , 3+8+0

# lst[0][0] + 3 , lst[0][0] + 8
# lst[1][0] + 8 , max(lst[1][0] + 1 , lst[1][1] + 1 ) , lst[1][1] + 0
for i in range(1,n):
    for j in range(len(lst[i])):
        if j==0:
            lst[i][j]=lst[i][j]+lst[i-1][j];

        elif j==len(lst[i])-1: 
            lst[i][j]=lst[i][j]+lst[i-1][j-1];

        else:
            lst[i][j]=max(lst[i-1][j-1],lst[i-1][j])+lst[i][j];

print(lst);
# print(max(lst[n-1]));