n , m = map(int ,input().split());

stack = [];



def backT(depth):

    if m == depth: ## 탈출 조건 : 최상위노드
        for i in stack:
            print(i,end=' ');
        print();
        return;
    for i in range(1,n+1):
        if i not in stack:
            stack.append(i);
            backT(depth+1);
            stack.pop();
backT(0);