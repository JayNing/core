package com.algorithm.linkedlist;

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
public class AddTwoNumbersV2 {

    public static void main(String[] args) {

//        int[] arr01 = new int[]{2,4,3};
//        int[] arr02 = new int[]{5,6,4};
//        int[] arr01 = new int[]{9,9,9,9,9,9,9};
//        int[] arr02 = new int[]{9,9,9,9};

        int[] arr01 = new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int[] arr02 = new int[]{5,6,4};

        ListNode listNode01 = generateListNode(arr01);
        ListNode listNode02 = generateListNode(arr02);

        addTwoNumbers(listNode01, listNode02);

    }

    private static ListNode generateListNode(int[] arr) {
        ListNode listNode = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = listNode;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new ListNode(arr[i]);
        }
        return listNode;
    }

    /**
     *
     * @param l1
     * @param l2
     * @return
     * 思路：
     * 1、因为是逆序，则取出两个链表的对应节点值进行相加，如果>10，需要进一位到下一个节点[注意，当最后一位数字遍历完后，需要考虑是否进一位的问题]
     * 2、直到有一个链表左右节点遍历完
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean isNeedAdd1 = false;

        ListNode listNode;
        ListNode tail;

        StringBuilder sb = new StringBuilder();

        int firstSum = l1.val + l2.val;
        if (firstSum >= 10){
            isNeedAdd1 = true;
            sb.append(firstSum - 10);
            listNode = new ListNode(firstSum - 10);
        } else {
            sb.append(firstSum);
            listNode = new ListNode(firstSum);
        }

        //循环条件，任何一个链表还有数值没遍历完或所有的链表遍历完了，但是有个进制位还没有+1
        while (l1.next != null || l2.next != null || isNeedAdd1){
            int sum = 0;
            if (l1.next != null){
                sum += l1.next.val;
                l1 = l1.next;
            }
            if (l2.next != null){
                sum += l2.next.val;
                l2 = l2.next;
            }
            if (isNeedAdd1){
                sum += 1;
            }
            if (sum >= 10){
                sb.append(sum - 10);
                isNeedAdd1 = true;
                tail = new ListNode(sum - 10);
            } else {
                sb.append(sum);
                isNeedAdd1 = false;
                tail = new ListNode(sum);
            }
            //将节点加入链表
            ListNode tmp = listNode;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = tail;
        }

        System.out.println("======");
        System.out.println(sb.toString());

        return listNode;
    }

}
