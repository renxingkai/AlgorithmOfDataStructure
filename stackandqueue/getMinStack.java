package cn.rxk.stackandqueue;

import java.time.DayOfWeek;
import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 题目：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：
 * 1.pop、push、getMin操作的时间复杂度都是O(1)
 * 2.设计的栈可以使用现有的栈结构
 */

/**
 * 思路一：
 *      创建两个栈，stackData保存元数据，stackMin保存最小元素，入栈时，判断入栈元素newNum比stackMin栈顶元素是否小，小的话将newNum压入stackMin
 *      否则只将newNum压入stackData
 *
 *      弹出时，先弹出stackData中的元素，然后判断stackData中的元素是否和stackMin的栈顶元素相同，相同的话两个栈同时弹出，否则只弹出stackData元素
 */
public class getMinStack {

    private Stack<Integer> stackData;//原始数据栈
    private Stack<Integer> stackMin;//保存最小值的栈

    /**
     * 构造方法，对两个成员方法进行初始化
     */
    public getMinStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    /**
     * push函数
     *
     * @param newNum
     */
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            //如果stackMin栈为空，直接将元素进行push进入栈
            stackMin.push(newNum);
        } else if (this.getMin() >= newNum) {
            //如果当前值比stackMin栈中的元素小，也需要将元素push进入stackMin
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }


    /**
     * pop函数
     *
     */
    public int pop() {
        if (stackMin.isEmpty()) {
            //stackMin栈为空，抛出异常
            throw new RuntimeException("Your stack is empty!");
        }
        //取出stackData栈顶的值
        int value = stackData.pop();
        if (value == getMin()) {
            //如果stackData栈顶的值等于stackMin栈顶的值说明，stackMin栈顶的值需要被弹出
            stackMin.pop();
        }
        return value;
    }

    /**
     * 获取stackMin的栈顶元素，即最小值
     *
     * @return
     */
    public int getMin() {
        if (stackMin.isEmpty()) {
            //stackMin栈为空，抛出异常
            throw new RuntimeException("Your stack is empty!");
        } else {
            //不为空的话stackMin的栈顶元素即为最小值
            return stackMin.peek();
        }
    }


}
