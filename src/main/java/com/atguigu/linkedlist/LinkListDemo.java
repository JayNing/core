package com.atguigu.linkedlist;

/**
 * @author ningjianjian
 * @Date 2021/5/16 上午11:03
 * @Description 单向链表
 *  添加（创建）
 *  1、先创建一个head节点，作用是表示单链表的头
 *  2、后面每添加一个节点，就直接加入到链表的最后
 *
 */
public class LinkListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero4);

        singleLinkedList.list();
        System.out.println("反转～～");
        singleLinkedList.reserveList();
        singleLinkedList.list();

    }

}

//定义一个singleLinkedList管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 反转链表
     */
    public void reserveList(){
        HeroNode reserve = new HeroNode(0,"","");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null){
            next = cur.next; //先暂时保存当前节点的下一个节点，因为后面需要
            cur.next = reserve.next;
            reserve.next = cur;
            cur = next;
        }
        head = reserve;
    }

    //添加节点到单向链表
    /**
     * 思路：当不考虑编号顺序时
     * 1、找到当前链表的最后节点
     * 2、将最后这个节点的next指向新的节点
     * @param node
     */
    public void addNode(HeroNode node){
        //因为head节点不能动，所以需要一个辅助遍历的temp
        HeroNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        //循环结束，表明temp即为最后一个尾节点
        //将最后这个节点的next指向新的节点
        temp.next = node;
    }
    // 遍历
    public void list(){
        if (head.next == null){
            System.out.println("链表为空～～～");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null){
            //输出节点信息
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}