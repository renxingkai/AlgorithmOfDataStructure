package cn.rxk.stackandqueue;


import java.util.Stack;

/**
 * 思路二：
 *      创建两个栈，stackData保存元数据，stackMin保存最小元素，入栈时，如果入栈元素newNum比stackMin栈顶元素小，则将newNum
 *      同时入stackData和stackMin，如果入栈元素newNum比stackMin栈顶元素大，需要将stackMin栈顶元素再次入stackMin栈，类似填充效果
 *
 *      出栈时候，两个栈同时pop元素
 */
//备注:Stack中peek()获取栈顶元素，并且不会弹出元素
public class MyStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }

    /**
     * push函数
     * @param newNum
     */
    public void push(int newNum){
        if (stackMin.isEmpty()){
            //栈空直接入栈
            stackMin.push(newNum);
        }else  if(newNum<this.getMin()){
            //如果newNum小于stackMin(最小元素)栈顶元素，则直接将newNum入栈
            stackMin.push(newNum);
        }else{
            //如果newNum>=stackMin(最小元素)栈顶元素，则将stackMin(最小元素)栈顶元素取出并且再次入栈
            int newMin=stackMin.peek();
            stackMin.push(newMin);
        }
        stackData.push(newNum);
    }

    /**
     * pop()函数
     * @return
     */
    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    /**
     * 获取stackMin中栈顶元素，即栈中最小元素
     * @return
     */
    public int getMin(){
        if(stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }else{
            return stackMin.peek();
        }
    }


}
