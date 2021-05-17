package com.atguigu.linkedlist;

/**
 * @author ningjianjian
 * @Date 2021/5/17 下午7:50
 * @Description 合并两个有序的单链表，合并之后的链表依然有序
 */
public class CombineLinkedListDemo {

    public static void main(String[] args) {
        CombineLinkedList cl1 = new CombineLinkedList();
        CombineNode hero1 = new CombineNode(1,"宋江","及时雨");
        CombineNode hero2 = new CombineNode(2,"卢俊义","玉麒麟");
        CombineNode hero3 = new CombineNode(3,"吴用","智多星");
        CombineNode hero4 = new CombineNode(4,"林冲","豹子头");

        cl1.addNode(hero1);
        cl1.addNode(hero2);
        cl1.addNode(hero3);
        cl1.addNode(hero4);
        System.out.println("cl1~~~");
        cl1.list();
        CombineLinkedList cl2 = new CombineLinkedList();
        CombineNode hero12 = new CombineNode(2,"宋江2","及时雨2");
        CombineNode hero22 = new CombineNode(3,"林冲2","豹子头2");
        CombineNode hero32 = new CombineNode(6,"卢俊义2","玉麒麟2");
        CombineNode hero42 = new CombineNode(7,"吴用2","智多星2");

        cl2.addNode(hero12);
        cl2.addNode(hero22);
        cl2.addNode(hero32);
        cl2.addNode(hero42);
        System.out.println("cl2~~~");
        cl2.list();
        System.out.println("合并～～");
        CombineLinkedList cl3 = new CombineLinkedList();
        cl3.combine(cl1.getHead(),cl2.getHead());
        cl3.list();

    }

}

class CombineLinkedList{

    private CombineNode head = new CombineNode(0,"","");

    public CombineNode getHead() {
        return head;
    }

    public void setHead(CombineNode head) {
        this.head = head;
    }

    /**
     * 合并两个有序单链表
     * @param node1
     * @param node2
     */
    public void combine(CombineNode node1, CombineNode node2){
        //定义一个不会变的头节点
        CombineNode target = new CombineNode(0,"","");

        //tmp为临时节点，会变的
        CombineNode tmp = target;
        CombineNode n1 = node1.next;
        CombineNode n2 = node2.next;
        while (n1 != null || n2 != null){
            if (n1 == null && n2 != null){
                tmp.next = n2;
                n2 = n2.next;
            } else if (n2 == null && n1 != null){
                tmp.next = n1;
                n1 = n1.next;
            } else {
                if (n1.no <= n2.no){
                    tmp.next = n1;
                    n1 = n1.next;
                } else {
                    tmp.next = n2;
                    n2 = n2.next;
                }
            }
            tmp = tmp.next;
        }

        setHead(target);
    }

    public void addNode(CombineNode node){
        CombineNode tmp = head;
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
        CombineNode temp = head;
        while (temp.next != null){
            //输出节点信息
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }
}

class CombineNode{
    public int no;
    public String name;
    public String nickName;
    public CombineNode next;

    public CombineNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "CombineNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}