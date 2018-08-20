package cn.rxk.stackandqueue;


import java.util.Stack;

/**
 * 题目：
 *      仅用递归函数和栈操作逆序一个栈，实现栈中元素的逆序，仅能用递归函数来写，不能用其他数据结构
 *
 *
 */
public class RecursiveReversedStack {

   //递归函数一
    /**
     * 将栈stack的栈底元素返回并移除
     * @param stack
     * @return
     */
   public static int getAndRemoveLastElement(Stack<Integer> stack){
       int result=stack.pop();
       if(stack.isEmpty()){
           return result;
       }else {
           int last=getAndRemoveLastElement(stack);
           stack.push(result);
           return last;
       }
   }

   //递归函数二

    /**
     * 逆序一个栈
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
       if(stack.isEmpty()){
           return;
       }
       int i=getAndRemoveLastElement(stack);
       reverse(stack);
       stack.push(i);
    }




}
