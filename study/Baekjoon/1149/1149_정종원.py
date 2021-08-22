# 3
# 26 40 83
# 49 60 57
# 13 89 99

# 26 + 57 + 96
# 96

# 26 + 60 + 13
# lst[0][0] + lst[1][1] + lst[2][0]
# 26 + 60 + 99
# lst[0][0] + lst[1][1] + lst[2][2]

# 26 + 57 = 13
# lst[0][0] + lst[1][2] + lst[2][0]
# 26 + 57 + 89
# lst[0][0] + lst[1][2] + lst[2][1]

# 40 + 49 + 89
# lst[0][1] + lst[1][0] + lst[2][1]
# 40 + 49 +99
# lst[0][1] + lst[1][0] + lst[2][2]

# 40 + 57 + 13
# lst[0][1] + lst[1][2] + lst[2][0]
# 40 + 57 + 89
# lst[0][1] + lst[1][2] + lst[2][1]



# lst[0][0] + lst[1][1] + lst[2][0]
# lst[0][0] + lst[1][1] + lst[2][2]
# lst[0][0] + lst[1][2] + lst[2][0]
# lst[0][0] + lst[1][2] + lst[2][1]


# lst[0][1] + lst[1][0] + lst[2][1]
# lst[0][1] + lst[1][0] + lst[2][2]
# lst[0][1] + lst[1][2] + lst[2][0]
# lst[0][1] + lst[1][2] + lst[2][1]

# lst[0][2] + lst[1][0] + lst[2][1]
# lst[0][2] + lst[1][0] + lst[2][2]
# lst[0][2] + lst[1][1] + lst[2][0]
# lst[0][2] + lst[1][1] + lst[2][2]

n = int(input());

lst = [list(map(int,input().split())) for _ in range(n)]


for i in range(1,n):
    lst[i][0] = lst[i][0] + min(lst[i-1][1] ,lst[i-2][2])
    lst[i][1] = lst[i][1] + min(lst[i-1][0] ,lst[i-2][2])
    lst[i][2] = lst[i][2] + min(lst[i-1][1] ,lst[i-2][0])

print(lst);
