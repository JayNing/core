package com.atguigu.sparsearray;

/**
 * @author ningjianjian
 * @Date 2021/5/15 下午4:44
 * @Description 稀疏数组【五子棋】
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11 * 11
        //0：表示没有棋子， 1：表示黑子， 2：表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转成稀疏数组的思路
        //1、 先遍历二维数组，获取非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11 ; i++){
            for (int j=0; j<11;j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("非0的数据个数为" + sum);
        //2、创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //3、给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //将非0数据赋值到稀疏数组中
        int count = 0; //count用于记录第几个非0数据
        for (int i = 0; i < 11 ; i++){
            for (int j=0; j<11;j++){
                if (chessArr1[i][j] != 0){
                    sparseArr[count + 1][0] = i;
                    sparseArr[count + 1][1] = j;
                    sparseArr[count + 1][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        System.out.println("得到的稀疏数组～～");
        for (int[] data : sparseArr) {
            for (int datum : data) {
                System.out.printf("%d\t",datum);
            }
            System.out.println();
        }

    }

}
