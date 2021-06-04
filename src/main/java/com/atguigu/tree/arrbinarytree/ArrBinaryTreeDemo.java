package com.atguigu.tree.arrbinarytree;

/**
 * @author ningjianjian
 * @Date 2021/6/4 2:00 下午
 * @Description 顺序存储二叉树
 *  从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成树，树也可以转换成数组。
 *
 *  顺序存储二叉树的特点：
 *  1）顺序二叉树通常只考虑完全二叉树
 *  2）第n个元素的左子节点为2 * n + 1
 *  3）第n个元素的右子节点为2 * n + 2
 *  4）第n个元素的父节点为 (n - 1) / 2
 *  5）n: 表示二叉树中的第几个元素（按0开始编号）
 *
 *  需求：给你一个数组{1,2,3,4,5,6,7}，要求以二叉树前序遍历的方式进行遍历。
 *      前序遍历的结果应当为1,2,4,5,3,6,7;
 *      中序遍历的结果应当为4,2,5,1,6,3,7;
 *      后序遍历的结果应当为4,5,2,6,7,3,1;
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        arrBinaryTreePostOrder(arr,0);
    }

    public static void arrBinaryTreePreOrder(int[] arr, int n){

        //根节点（当前节点）
        System.out.println(arr[n]);

        //向左子节点遍历
        if ((2 * n + 1) < arr.length){
            arrBinaryTreePreOrder(arr,2 * n + 1);
        }

        //向右子节点遍历
        if ((2 * n + 2) < arr.length){
            arrBinaryTreePreOrder(arr,2 * n + 2);
        }

    }

    public static void arrBinaryTreeMidOrder(int[] arr, int n){

        //向左子节点遍历
        if ((2 * n + 1) < arr.length){
            arrBinaryTreeMidOrder(arr,2 * n + 1);
        }

        //根节点（当前节点）
        System.out.println(arr[n]);

        //向右子节点遍历
        if ((2 * n + 2) < arr.length){
            arrBinaryTreeMidOrder(arr,2 * n + 2);
        }

    }

    public static void arrBinaryTreePostOrder(int[] arr, int n){

        //向左子节点遍历
        if ((2 * n + 1) < arr.length){
            arrBinaryTreePostOrder(arr,2 * n + 1);
        }

        //向右子节点遍历
        if ((2 * n + 2) < arr.length){
            arrBinaryTreePostOrder(arr,2 * n + 2);
        }

        //根节点（当前节点）
        System.out.println(arr[n]);
    }

}
