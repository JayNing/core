package com.atguigu.stack;

/**
 * @author ningjianjian
 * @Date 2021/5/18 下午5:02
 * @Description 使用链表模拟stack进行入栈和出栈
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedStackNode node1 = new LinkedStackNode(1);
        LinkedStackNode node2 = new LinkedStackNode(2);
        LinkedStackNode node3 = new LinkedStackNode(3);
        LinkedStackNode node4 = new LinkedStackNode(4);
        LinkedStackNode node5 = new LinkedStackNode(4);
        LinkedStackNode node6 = new LinkedStackNode(4);

        LinkedListStack stack = new LinkedListStack();
        stack.push(node1);
        stack.push(node2);
        stack.push(node4);
        stack.push(node3);
        stack.push(node5);
        stack.push(node6);

        stack.list();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

}

class LinkedListStack{
    public LinkedStackNode firstNode = null;

    public LinkedStackNode pop(){
        LinkedStackNode tmp = firstNode;
        while (tmp != null){
            firstNode = firstNode.next;
            System.out.println("获取栈顶元素：" + tmp);
            return tmp;
        }
        System.out.println("栈为空～～～");
        return null;
    }

    public void list(){
        LinkedStackNode tmp = firstNode;
        System.out.println("从栈顶到栈底打印元素～～～");
        while (tmp != null){
            System.out.println("元素编号：" + tmp.no);
            tmp = tmp.next;
        }
    }

    public void push(LinkedStackNode node){

        if (firstNode == null){
            firstNode = node;
            return;
        }
        node.next = firstNode;
        firstNode = node;
    }
}

class LinkedStackNode{

    public int no;
    public LinkedStackNode next;

    public LinkedStackNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "LinkedStackNode{" +
                "no=" + no +
                '}';
    }
}




