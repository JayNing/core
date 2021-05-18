package com.atguigu.linkedlist;

/**
 * @author ningjianjian
 * @Date 2021/5/18 上午10:40
 * @Description 约瑟夫问题
 *   约瑟夫问题：设编号为1，2，3，...， n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，
 *   数到m的那个人又出列，以此类推，直到所有人出列为止，由此产生一个出队编号的序列。
 *
 *   提示：用一个不带头节点的循环链表来处理Joseph问题。先构成一个有n个节点的单循环链表，然后由k节点起从1开始计数，计到m时，对应节点从链表中删除，
 *   然后怒再从被删除节点的下一个节点又从1开始计数，直到最后一个节点从链表中删除，算法结束。
 */
public class JosephDemo {

    public static void main(String[] args) {
        JosephNode node1 = new JosephNode(1);
        JosephNode node2 = new JosephNode(2);
        JosephNode node3 = new JosephNode(3);
        JosephNode node4 = new JosephNode(4);
        JosephNode node5 = new JosephNode(5);

        JosephLinkedList linkedList = new JosephLinkedList();
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node3);
        linkedList.addNode(node4);
        linkedList.addNode(node5);

        linkedList.list();
        System.out.println("删除0的头节点~~~");
        linkedList.delFirst0();
        linkedList.list();
        System.out.println("约瑟夫算法～～～～");

        linkedList.josephList(2,2);
    }

}

class JosephLinkedList{

    public JosephNode first = new JosephNode(0);

    public void setFirst(JosephNode first) {
        this.first = first;
    }

    public void josephList(int firstNo, int m) {
        JosephNode tmp = first;

        int count = 0;
        while (tmp.next != null){
            if (count > 0){
                //表明之后的节点，均参与计数，直到m为止
                count++;
            }

            if (count == m){
                //当前这个节点出列（要被删除）
                System.out.println("出队列编号：" + tmp.next.no);
                if (tmp.next == tmp.next.next){
                    break;
                }
                tmp.next = tmp.next.next;
                //从下一个节点重新开始从1计数
                count = 1;
            }

            if (tmp.next.no == firstNo){
                //此时开始计数
                count = 1;
            }
            tmp = tmp.next;
        }
    }

    public void delFirst0(){
        JosephNode temp = first;
        while (temp.next != null && temp.next != first){
            temp = temp.next;
        }
        temp.next = first.next;
        setFirst(first.next);
    }

    public void list(){
        JosephNode temp = first;
        System.out.println(first.toString());
        while (temp.next != null && temp.next != first){
            //输出节点信息
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }

    public void addNode(JosephNode node){
        JosephNode tmp = first;
        while (tmp.next != null && tmp.next != first){
            tmp = tmp.next;
        }
        tmp.next = node;
        node.next = first;
    }
}

class JosephNode{
    public int no;
    public JosephNode next;

    public JosephNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "JosephNode{" +
                "no=" + no +
                '}';
    }
}