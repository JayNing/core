package com.algorithm.linkedlist;

import java.util.Stack;

/**
 * @author ningjianjian
 * @Date 2021/6/1 7:12 下午
 * @Description 两数相加
 *
 *  问题：
 *      给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *      请你将两个数相加，并以相同形式返回一个表示和的链表。
 *      你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *  示例1：
 *      输入：l1 = [2,4,3], l2 = [5,6,4]
 *      输出：[7,0,8]
 *      解释：342 + 465 = 807.
 *  示例2：
 *      输入：l1 = [0], l2 = [0]
 *      输出：[0]
 *  示例3：
 *      输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *      输出：[8,9,9,9,0,0,0,1]
 *  提示：
 *      每个链表中的节点数在范围 [1, 100] 内
 *      0 <= Node.val <= 9
 *      题目数据保证列表表示的数字不含前导零
 *
 */
public class AddTwoNumbers {

    /**
     *  因为每个链表中节点数范围在[1,100]，所以数字过长后，超出Long转换范围
     *  当前类执行出错：
     *      java.lang.NumberFormatException: For input string: "1000000000000000000000000000001"
         *   at line 68, java.base/java.lang.NumberFormatException.forInputString
         *   at line 699, java.base/java.lang.Long.parseLong
         *   at line 824, java.base/java.lang.Long.parseLong
         *   at line 75, Solution.addTwoNumbers
         *   at line 54, __DriverSolution__.__helper__
         *   at line 87, __Driver__.main
     * @param args
     */

    public static void main(String[] args) {

//        int[] arr01 = new int[]{2,4,3};
//        int[] arr02 = new int[]{5,6,4};
//        int[] arr01 = new int[]{9,9,9,9,9,9,9};
//        int[] arr02 = new int[]{9,9,9,9};

        int[] arr01 = new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int[] arr02 = new int[]{5,6,4};

        ListNode listNode01 = generateListNode(arr01);
        ListNode listNode02 = generateListNode(arr02);

        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);

        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);

        l2.next = l21;
        l21.next = l22;
//        ListNode listNode = addTwoNumbers(l1, l2);
        addTwoNumbers(listNode01, listNode02);
        list();

    }

    private static ListNode generateListNode(int[] arr) {
        head = null;
        if (arr.length == 0) {
            return null;
        }
        for (int i : arr) {
            add(new ListNode(i));
        }
        return head;
    }

    // 遍历
    public static void list(){
        if (head == null){
            System.out.println("链表为空～～～");
            return;
        }
        ListNode temp = head;
        System.out.println(temp.val);
        while (temp.next != null){
            //输出节点信息
            System.out.println(temp.next.val);
            temp = temp.next;
        }
    }

    public static ListNode head;

    public static void add(ListNode listNode){

        if (head == null){
            head = listNode;
            return;
        }

        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = listNode;

    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     * 思路：
     * 1、遍历节点l1和l2，取出元素转出long数值
     * 2、将long相加，结果再存储到链表中
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        head = null;
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();

        ListNode curTmp1 = l1;
        s1.push(curTmp1.val);
        while (curTmp1.next != null) {
            curTmp1 = curTmp1.next;
            s1.push(curTmp1.val);
        }

        ListNode curTmp2 = l2;
        s2.push(curTmp2.val);
        while (curTmp2.next != null) {
            curTmp2 = curTmp2.next;
            s2.push(curTmp2.val);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (!s1.empty()){
            sb1.append(s1.pop());
        }

        while (!s2.empty()){
            sb2.append(s2.pop());
        }

        Double sum = Double.parseDouble(sb1.toString()) + Double.parseDouble(sb2.toString());
        String sumStr = String.valueOf(sum);
        sumStr = sumStr.substring(0,sumStr.indexOf("."));
        //反转
        for (int i = sumStr.length() - 1; i >= 0; i--){
            ListNode childListNode = new ListNode(Integer.parseInt(sumStr.substring(i,i+1)));
            add(childListNode);
        }

        return head;
    }

}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                '}';
    }
}
