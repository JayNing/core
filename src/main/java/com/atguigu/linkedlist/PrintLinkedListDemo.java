package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * @author ningjianjian
 * @Date 2021/5/17 下午7:26
 * @Description 反向打印链表节点[逆序打印---利用栈解决]
 */
public class PrintLinkedListDemo {

    public static void main(String[] args) {
        Node hero1 = new Node(1,"宋江","及时雨");
        Node hero2 = new Node(2,"卢俊义","玉麒麟");
        Node hero3 = new Node(3,"吴用","智多星");
        Node hero4 = new Node(4,"林冲","豹子头");

        PrintLinkedList printLinkedList = new PrintLinkedList();

        printLinkedList.addNode(hero1);
        printLinkedList.addNode(hero3);
        printLinkedList.addNode(hero2);
        printLinkedList.addNode(hero4);

        printLinkedList.list();
        System.out.println("逆序打印～～～");
        printLinkedList.reservePrintf();
    }


}

class PrintLinkedList{
    //先初始化一个头节点，头节点不要动
    private Node head = new Node(0,"","");

    /**
     * 逆序打印---利用栈解决
     */
    public void reservePrintf(){
        Stack<Node> nodeStack = new Stack<>();

        Node tmp = head;
        while (tmp.next != null){
            nodeStack.push(tmp.next);
            tmp = tmp.next;
        }

        while (nodeStack.size() > 0){
            System.out.println(nodeStack.pop());
        }
    }

    public void addNode(Node node){
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空～～～");
            return;
        }
        Node temp = head;
        while (temp.next != null){
            //输出节点信息
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }

}

class Node{
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
