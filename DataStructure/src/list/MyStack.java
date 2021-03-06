package list;

import node.ListNode;

public class MyStack {
    private ListNode head=null;
    public MyStack(){
    }
    public void push(int val){
        ListNode curr=new ListNode(val);
        curr.next=this.head;
        this.head=curr;
    }
    public int pop(){
        if(isEmpty()){
            throw new UnsupportedOperationException("栈为空");
        }
        int val=this.head.val;
        this.head=this.head.next;
        return val;
    }
    public boolean isEmpty(){
        return this.head==null;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }else{
            return this.head.val;
        }
    }
}

