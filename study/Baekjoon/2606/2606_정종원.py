from collections import deque
n = int(input());
m = int(input());

stack = [[0] * (n + 1) for _ in range(n+1)];

for i in range(0,m):
    x , y = map(int,input().split());


    stack[x][y] = 1;
    stack[y][x] = 1;

lst = [];
def bfs(depth):

    lst.append(depth);

    queue = deque();
    queue.append(depth);

    while queue:
        n = queue.popleft();
        for i in range(len(stack)):
            if stack[n][i] == 1 and (i not in lst):
                lst.append(i);
                queue.append(i);
bfs(1);
print(len(lst) - 1);