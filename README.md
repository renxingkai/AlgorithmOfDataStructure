# AlgorithmOfDataStructure
此Repositories主要参考左程云老师《程序员代码面试指南--IT名企算法与数据结构题目最优解》一书进行学习并实现相关例题


#### 此Repositories主要参考左程云老师《程序员代码面试指南--IT名企算法与数据结构题目最优解》一书进行学习并实现相关例题，ReadMe只是简单说明，具体题解在代码中详细描述

#### 算法是硬伤！！！算法也伴随了一个Coder的一生！！！活到老，学到老！！！

# 第一章  栈和队列

### 1. 设计一个有getMin功能的栈

提供两种思路：

思路一：

创建两个栈，stackData保存元数据，stackMin保存最小元素，入栈时，判断入栈元素newNum比stackMin栈顶元素是否小，小的话将newNum压入stackMin，否则只将newNum压入stackData
 
弹出时，先弹出stackData中的元素，然后判断stackData中的元素是否和stackMin的栈顶元素相同，相同的话两个栈同时弹出，否则只弹出stackData元素

[代码直通车](https://github.com/renxingkai/AlgorithmOfDataStructure/blob/master/stackandqueue/getMinStack.java)

思路二：

创建两个栈，stackData保存元数据，stackMin保存最小元素，入栈时，如果入栈元素newNum比stackMin栈顶元素小，则将newNum同时入stackData和stackMin，如果入栈元素newNum比stackMin栈顶元素大，需要将stackMin栈顶元素再次入stackMin栈，类似填充效果

出栈时候，两个栈同时pop元素

[代码直通车](https://github.com/renxingkai/AlgorithmOfDataStructure/blob/master/stackandqueue/MyStack2.java)

### 2. 设计由两个栈组成的队列

思路：

可以将两个栈的顺序反过来，即可实现先进先出效果；具体使用两个栈，一个栈作为压入栈stackPush，仅压入数据，另一个栈作为弹出栈stackPop，仅弹出数据，
弹出栈stackPop需要将压入栈stackPush的元素压入自己的栈中，保证顺序

但是必须做到两点：

- 如果stackPush要往stackPop压入数据，必须一次性将stackPush中的元素全部压入stackPop

- 如果stackPop不为空，stackPush绝对不能向stackPop中压入数据

[代码直通车](https://github.com/renxingkai/AlgorithmOfDataStructure/blob/master/stackandqueue/QueueConsistedTwoStacks.java)

### 3. 仅用递归和栈操作实现逆序栈

思路：

将栈stack的栈底元素返回并移除

逆序一个栈


[代码直通车](https://github.com/renxingkai/AlgorithmOfDataStructure/blob/master/stackandqueue/RecursiveReversedStack.java)
