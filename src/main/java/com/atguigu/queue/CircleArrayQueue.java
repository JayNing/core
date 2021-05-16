package com.atguigu.queue;

import java.util.Scanner;

/**
 * @author ningjianjian
 * @Date 2021/5/16 上午9:58
 * @Description 使用数组模拟环形队列
 *
 * 思路分析：
 * 1、front变量的含义：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front的初始值=0
 * 2、rear变量的含义：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定，rear的初始值=0
 * 3、当队列满时，条件是(rear + 1) % maxSize = front【满】
 * 4、当队列为空的条件，rear = front空
 * 5、当我们这样分析，队列中有效数据的个数(rear + maxSize - front) % maxSize 【小算法小技巧】
 * 6、得到一个环形队列
 */
public class CircleArrayQueue {

    public static void main(String[] args) {

        System.out.println("测试数组模拟环形队列的案例～～～");

        //创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明：这里的设置4，其队列的有效数据容量最大是3，空出一个空间作为约定

        char key = ' ';//接收用户指令
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列获取数据");
            System.out.println("h:显示队列的头数据");
            key = scanner.next().charAt(0);
            switch (key){

                case 's':
                    queue.showQueue();
                    break;

                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;

                case 'g':
                    System.out.println("获取到的数据：" + queue.get());
                    break;

                case 'h':
                    System.out.println("队列头数据：" + queue.headQueue());
                    break;
            }
        }
        System.out.println("退出程序～～～");

    }

    static class CircleArray{
        private int maxSize;

        private int front = 0;

        private int rear = 0;

        private int[] arr;

        public CircleArray(int maxSize){
            this.maxSize = maxSize;
            this.arr = new int[maxSize];
            this.front = 0;
            this.rear = 0;
        }

        public boolean isFull(){
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        public void add(int data){
            if (isFull()){
                System.out.println("队列已满，不能添加元素");
                return;
            }
            //直接将数据加入

            //将rear后移，这里必须考虑取模
            arr[rear] = data;
            rear = (rear + 1) % maxSize;
        }

        public int get(){
            if (isEmpty()){
                System.out.println("队列为空，不能获取元素");
                return -1;
//                throw new RuntimeException("队列为空，不能获取元素");
            }
            //这里需要分析出front是指向队列的第一个元素
            //1、先把front对应的值保留到一个临时变量
            //2、将front后移，考虑取模
            //3、将临时保存的变量返回
            int data = arr[front];
            front = (front + 1) % maxSize;
            return data;
        }

        public void showQueue(){
            if (isEmpty()){
                System.out.println("队列为空，没有数据～～～");
                return;
            }
            //思路：从front开始遍历，遍历多少个元素
            for (int i = front; i < front + size(); i++){
                System.out.printf("arr[%d]=%d\n",i % maxSize, arr[i % maxSize]);
            }
        }

        public int headQueue(){
            if (isEmpty()){
                System.out.println("队列为空，没有数据～～～");
                return -1;
            }
            return arr[front];
        }

        //求出当前队列有效数据的个数
        public int size(){
            return (rear + maxSize - front) % maxSize;
        }

    }









}
