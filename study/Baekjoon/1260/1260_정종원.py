from collections import deque

a ,b,c = map(int,input().split());

stack = [[0] * (a+1) for _ in range(a+1)];
dfsLst = [];
bfsLst = [];

for i in range(0,b):

    x,y = map(int,input().split());

    stack[x][y] = 1;
    stack[y][x] = 1;


def dfs(start):
    dfsLst.append(start);


    for i in range(a+1):
        if stack[start][i] == 1 and (i not in dfsLst):
            dfs(i);

def bfs(start):
    bfsLst.append(start);

    queue = deque();

    queue.append(start);

    while queue:
        n = queue.popleft();

        for i in range(len(stack[start])):
            if stack[n][i] == 1 and (i not in bfsLst):
                bfsLst.append(i);
                queue.append(i);



dfs(c);
bfs(c);

for i in dfsLst:
    print(i, end = ' ');
print();
for i in bfsLst:
    print(i , end= ' ');

