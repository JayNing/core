package com.atguigu.hashtable;

import java.util.Scanner;

/**
 * @author ningjianjian
 * @Date 2021/5/30 2:47 下午
 * @Description 哈希表操作
 *  哈希表的基本介绍
 *  散列表(Hash table， 也叫哈希表)，是根据关键码值(key value)而直接进行访问的数据结构。也就是说，它通过把关键码值映射到表中一个位置来访问记录，
 *  以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表。
 */
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(10);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入指令：1 add、 2 showList、 3 delete、 4 exit、 5 findByNo");
            int key = scanner.nextInt();
            switch (key){
                case 1:
                    System.out.println("请输入要添加的no");
                    int no =scanner.nextInt();
                    hashTab.add(no);
                    break;
                case 2:
                    hashTab.showList();
                    break;
                case 3 :
                    System.out.println("请输入要删除的no");
                    no =scanner.nextInt();
                    hashTab.delete(no);
                    break;
                case 4 :
                    scanner.close();
                    break;
                case 5 :
                    System.out.println("请输入要查找的no");
                    no =scanner.nextInt();
                    MyNode byNode = hashTab.findByNode(no);
                    System.out.println("查询到的节点：" + byNode);
                    break;
            }
        }

    }

}

class HashTab {
    private HashTabLinkedList[] hashTabLinkedList;
    private int size;

    /**
     * 初始化
     *
     * @param size
     */
    public HashTab(int size) {
        this.size = size;
        this.hashTabLinkedList = new HashTabLinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTabLinkedList[i] = new HashTabLinkedList();
        }
    }

    public void delete(int no){
        int id = hash(no);
        hashTabLinkedList[id].delete(no);
    }

    public MyNode findByNode(int no){
        int id = hash(no);
        return hashTabLinkedList[id].findByNo(no);
    }

    /**
     * 遍历哈希表
     */
    public void showList(){
        for (int i = 0; i < size; i++){
            hashTabLinkedList[i].list(i + 1);
        }
    }

    public void add(int no) {
        int id = hash(no);
        hashTabLinkedList[id].add(new MyNode(no, "我是" + no));
    }

    /**
     * 散列函数
     * @param no
     * @return
     */
    public int hash(int no) {
        return no % size;
    }
}

/**
 * hashtable链表类
 */
class HashTabLinkedList {
    public MyNode head; //默认为null

    public void delete(int no){
        if (head == null){
            System.out.println("链表为空~~");
            return;
        }
        if (head.no == no){
            //找到了,删除
            head = head.next;
            return;
        }


        MyNode curNode = head;
        MyNode tmpNode;
        while (curNode.next != null) {
            tmpNode = curNode; //存储待删除节点的上一个节点
            curNode = curNode.next;
            if (curNode.no == no){
                tmpNode.next = curNode.next;
                break;
            }
        }
    }

    public MyNode findByNo(int no){
        if (head == null){
            System.out.println("链表为空~~");
            return null;
        }
        if (head.no == no){
            //找到了
            return head;
        }
        MyNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
            if (curNode.no == no){
                //找到了
                return curNode;
            }
        }
        return null;
    }

    public void add(MyNode node) {
        if (head == null) {
            head = node;
            return;
        }
        MyNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = node;
    }

    public void list(int no) {
        if (head == null){
            System.out.println("第" + no +"段链表为空~~");
            return;
        }
        MyNode curNode = head;
        System.out.println("====> " + curNode);
        while (curNode.next != null) {
            curNode = curNode.next;
            System.out.print("====> " + curNode);
        }
    }

}

/**
 * hashtable链表节点类
 */
class MyNode {

    public int no;

    public String name;

    public MyNode next;

    public MyNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "no=" + no +
                ", name='" + name +
                '}';
    }
}
