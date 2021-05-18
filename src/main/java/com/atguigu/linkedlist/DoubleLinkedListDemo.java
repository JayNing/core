package com.atguigu.linkedlist;

/**
 * @author ningjianjian
 * @Date 2021/5/18 上午9:18
 * @Description 双向链表demo
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleNode node1 = new DoubleNode(1,"张三","飞天猴");
        DoubleNode node2 = new DoubleNode(2,"李四","土行孙");
        DoubleNode node3 = new DoubleNode(3,"万古屋","海里游");
        DoubleNode node4 = new DoubleNode(4,"陈留","天上飞");

        doubleLinkedList.addNodeByOrder(node1);
        doubleLinkedList.addNodeByOrder(node4);
        doubleLinkedList.addNodeByOrder(node3);
        doubleLinkedList.addNodeByOrder(node2);

        doubleLinkedList.list();

        System.out.println("删除一个节点～～～");

        doubleLinkedList.remove(node2);

        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    /**
     * 先初始化一个头节点，头节点不要动，不存放具体数据
     */
    public DoubleNode head = new DoubleNode(0,"","");

    /**
     *  删除某个节点
     */
    public void remove(DoubleNode node){
        DoubleNode tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
            if (tmp.no == node.no){
                //删除
                tmp.pre.next = tmp.next;
                if (tmp.next != null){
                    //防止要删除的node是最后一个节点时，空指针异常
                    tmp.next.pre = tmp.pre;
                }
                break;
            }
        }
    }
    /**
     * 遍历展示节点
     */
    public void list(){
        if (head.next == null){
            System.out.println("链表为空～～～");
            return;
        }
        DoubleNode temp = head;
        while (temp.next != null){
            //输出节点信息
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }

    /**
     * 添加节点，根据序号排序
     * @param node
     */
    public void addNodeByOrder(DoubleNode node){
        DoubleNode tmp = head;

        if (tmp.next == null){
            tmp.next = node;
            node.pre = tmp;
            return;
        }

        boolean isFind = false;
        while (tmp.next != null){
            if (node.no < tmp.next.no) {
                isFind = true;
                //tmp.next为老的节点
                node.next = tmp.next;
                tmp.next.pre = node;
                //此时tmp.next已经发生变化，tmp.next为新的节点
                tmp.next = node;
                node.pre = tmp;
                break;
            }
            tmp = tmp.next;
        }

        if (!isFind){
            tmp.next = node;
            node.pre = tmp;
        }
    }

    /**
     * 添加节点，默认添加到最后
     * @param node
     */
    public void addNode(DoubleNode node){
        DoubleNode tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
        node.pre = tmp;
    }

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }
}

class DoubleNode{
    public int no;
    public String name;
    public String nickName;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}