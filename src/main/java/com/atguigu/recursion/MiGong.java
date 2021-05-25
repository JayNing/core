package com.atguigu.recursion;

/**
 * @author ningjianjian
 * @Date 2021/5/21 5:58 下午
 * @Description 迷宫问题
 */
public class MiGong {

    public static void main(String[] args) {

        //1、创建一个二维数组，模拟迷宫
        int[][] map = generateMap();

        //2、使用递归回溯给小球找路
        //第一次，默认从下标为（1，1）的开始找，作为起点
        findWay(map,1,1);

        System.out.println("小球走过并标识过的地图的情况~~~");
        showMap(map);
    }

    /**
     *
     * @param map
     * @param i
     * @param j
     *
     * 说明：
     *  1、map表示地图
     *  2、i\j表示从地图的哪个位置开始出发,起始(1,1)
     *  3、如果小球能到map[6][5]（终点）位置，则说明通路找到
     *  4、约定：当map[i][j]为0 表示该点没有走过； 当为1 表示墙； 当为2 表示通路可以走； 3 表示该点已经走过，但是走不通
     *  5、在走迷宫时，需要确定一个策略(方法) [如：下->右->上->左，也可以是其他的策略]，如果该点走不通，再回溯
     *
     */
    private static boolean findWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            //说明通路已找到
            return true;
        }

        //判断是否走过
        if (map[i][j] == 0){
            //说明可以走
            map[i][j] = 2;
            //继续按照规则（下->右->上->左）往下一个节点走
            if (findWay(map, i + 1, j)){
                //向上走
                return true;
            } else if (findWay(map, i, j + 1)){
                //向右走
                return true;
            } else if (findWay(map, i - 1, j)){
                //向下走
                return true;
            }else if (findWay(map, i , j - 1)){
                //向左走
                return true;
            } else {
                //说明此路不通
                map[i][j] = 3;
                return false;
            }
        } else {
            // 说明可能是1，2，3
            return false;
        }
    }

    private static int[][] generateMap() {
        //假设迷宫为8行7列
        int[][] map = new int[8][7];
        //使用 1 表示为墙体
        //将迷宫四周边的位置全部设置成墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int j = 1; j < 6; j++){
            map[0][j] = 1;
            map[7][j] = 1;
        }
        //设置隔板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("创建迷宫~~~");
        showMap(map);

        return map;
    }

    private static void showMap(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
