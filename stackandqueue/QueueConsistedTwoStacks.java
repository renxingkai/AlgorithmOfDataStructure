package cn.rxk.stackandqueue;
/**
 * 设计一个由两个栈组成的队列
 * 题目：
 * 用两个栈实现队列，支持队列的基本操作(add、poll、peek)
 */

import java.util.Stack;

/**
 * 思路：
 *      可以将两个栈的顺序反过来，即可实现先进先出效果；具体使用两个栈，一个栈作为压入栈stackPush，仅压入数据，另一个栈作为弹出栈stackPop，仅弹出数据，
 *      弹出栈stackPop需要将压入栈stackPush的元素压入自己的栈中，保证顺序
 *
 *      但是必须做到两点：
 *          1.如果stackPush要往stackPop压入数据，必须一次性将stackPush中的元素全部压入stackPop
 *          2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
 *
 */
public class QueueConsistedTwoStacks {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    /**
     * 构造函数
     *
     */
    public QueueConsistedTwoStacks(){
        stackPop=new Stack<Integer>();
        stackPush=new Stack<Integer>();
    }

    /**
     * 入队函数
     * @param pushInt
     */
    public void add(int pushInt){
        stackPush.add(pushInt);
    }

    /**
     * 出队列函数
     * @return
     */
    public int poll(){
        if(stackPush.isEmpty()&&stackPop.isEmpty()){
            //判断stackPush和stackPop是否为空
            throw new RuntimeException("Your stack is empty!");
        }else if (stackPop.isEmpty()){
            //如果stackPop为空，但是stackPush不为空，需要将stackPush中的元素压入stackPop中
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();

    }

    /**
     * 栈peek()函数
     * @return
     */
    public int peek(){
        if (stackPop.isEmpty()&&stackPush.isEmpty()){
            //判断stackPush和stackPop是否为空
            throw new RuntimeException("Your stack is empty");
        }else if (stackPop.isEmpty()){
            //如果stackPop为空，但是stackPush不为空，需要将stackPush中的元素压入stackPop中
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }












}
