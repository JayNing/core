package com.atguigu.linkedlist;

/**
 * @author ningjianjian
 * @Date 2021/5/18 下午1:56
 * @Description 约瑟夫问题---版本2
 *  *   约瑟夫问题：设编号为1，2，3，...， n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，
 *  *   数到m的那个人又出列，以此类推，直到所有人出列为止，由此产生一个出队编号的序列。
 *  *
 *  *   提示：用一个不带头节点的循环链表来处理Joseph问题。先构成一个有n个节点的单循环链表，然后由k节点起从1开始计数，计到m时，对应节点从链表中删除，
 *  *   然后怒再从被删除节点的下一个节点又从1开始计数，直到最后一个节点从链表中删除，算法结束。
 */
public class JosephDemoV2 {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(5);//添加5个小孩
        circleSingleLinkedList.showBoy();

        System.out.println("出圈游戏～～～～");

        circleSingleLinkedList.countBoy(1,2,5);

    }
}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = null;

    /**
     *
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum,int nums){
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("输入参数有误，请重新输入");
            return;
        }

        //创建一个辅助节点帮助完成小孩出圈
        Boy helper = first;

        //需要创建一个辅助节点helper，先让其指向环形链表的最后一个节点
        while (true){
            if (helper.getNext() == first){
                //说明helper指向了最后一个小孩节点
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让first和helper移动（startNo-1）次
        for (int i = 0; i < startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //此时，first位于startNo起点的前一个节点
        //当小孩开始报数时，让first和helper同时移动(countNum-1)次，然后出圈。
        //循环操作，直到圈中只有一个节点
        while (true){
            if (first == helper){
                //说明圈中只有一个节点
                break;
            }
            //让first和helper同时移动(countNum-1)次
            for (int j = 0; j < countNum - 1; j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时，first指向的节点，就是要出圈的小孩的节点
            System.out.println("要出圈的小孩编号：" + first.getNo());
            //将小孩移出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号:" + first.getNo());
    }

    /**
     * 遍历环形链表
     */
    public void showBoy(){
        if (first == null){
            System.out.println("链表为空,没有任何小孩～～～");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号：" + curBoy.getNo());
            if (curBoy.getNext() == first){
                //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 添加小孩节点数，构建一个环形链表
     * @param nums
     */
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        //辅助指针，用于构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++){
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                boy.setNext(first); //构成环形
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }
}

/**
 * 创建一个boy类，作为一个节点
 */
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}