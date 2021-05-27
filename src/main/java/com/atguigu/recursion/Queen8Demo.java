package com.atguigu.recursion;

/**
 * @author ningjianjian
 * @Date 2021/5/27 5:12 下午
 * @Description 八皇后问题
 *   提出问题：在8x8格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法（92）
 *   思路分析：
 *   1、第一个皇后先放第一行第一列
 *   2、第二个皇后放在第二行第一列，然后判断是否OK，如果不OK，继续放在第二列、第三列、依次把所有的列都放完，找到一个合适的
 *   3、继续放第三个皇后，还是第一列、第二列、...直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 *   4、当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到。
 *   5、然后回头继续第一个皇后放第二列，后面继续循环执行1，2，3，4的步骤。
 *
 *   说明：
 *   理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题。
 *   arr[8]={0,4,7,5,2,6,1,3}
 *   //对应arr下标表示第几行，即第几个皇后，而arr[i]=val， 值val，表示第i+1个皇后，放在第i+1行的第val+1列
 *
 */
public class Queen8Demo {

    private static final Integer max = 8;
    //定义数组，保存皇后放置位置的结果
    private static int[] arr = new int[8];

    private static int count = 0;

    public static void main(String[] args) {
        setQueen(0);
        System.out.println("一共有" + count + "种放置方式");
    }

    /**
     * 编写一个方法，放置第n个皇后
     * @param n
     */
    public static void setQueen(int n){
        if (n == max){
            //说明8个皇后都放好了
            show();
            count++;
            return;
        }

        //先从第一列开始放置，依次放入皇后，判断是否冲突
        for (int i = 0; i < 8; i++) {
            arr[n] = i;
            //判断是否冲突
            if (!checkConflict(n)){
                //如果不冲突，继续放置下一个皇后
                setQueen(n + 1);
            } else {
                //如果冲突，则继续循环，将第n个皇后放在（i + 1）列
            }
        }

    }

    private static boolean checkConflict(int n) {
        for (int i = 0; i < n; i++){
            //判断是否是重复列
            if (arr[i] == arr[n]){
                //说明是同一列
                return true;
            }
            //判断是否是一条斜线上
            //同一斜线上的点的特点，就是两点的横轴与竖轴的间距相同，好似正方形对角线
            if (Math.abs(arr[n] - arr[i]) == Math.abs(n - i)){
                //说明是一条斜线上
                return true;
            }
        }
        return false;
    }

    public static void show(){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
