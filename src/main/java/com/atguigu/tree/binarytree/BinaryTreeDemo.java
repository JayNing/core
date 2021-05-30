package com.atguigu.tree.binarytree;

/**
 * @author ningjianjian
 * @Date 2021/5/30 3:32 下午
 * @Description 二叉树
 *
 * 二叉树遍历说明：
 * 1）前序遍历：根节点->左节点->右节点
 * 2）中序遍历：左节点->根节点->右节点
 * 3）后序遍历：左节点->右节点->根节点
 * 小结：看输出父（根）节点的顺序，就确定是前序、中序还是后序
 *
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1,"张三1");
        BinaryTreeNode node2 = new BinaryTreeNode(2,"张三2");
        BinaryTreeNode node3 = new BinaryTreeNode(3,"张三3");
        BinaryTreeNode node4 = new BinaryTreeNode(4,"张三4");
        BinaryTreeNode node10 = new BinaryTreeNode(10,"张三10");

        node3.left = node2;
        node2.left = node1;
        node3.right = node4;
        node4.right = node10;

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(node3);

        System.out.println("二叉树遍历测试~~~~");
        System.out.println("前序遍历~~~");
        binaryTree.preOrder();
        System.out.println("中序遍历~~~");
        binaryTree.midOrder();
        System.out.println("后序遍历~~~");
        binaryTree.postOrder();
    }
}

/**
 * 二叉树类
 */
class BinaryTree {
    //根节点
    public BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
       if (root != null){
           root.preOrder();
       } else {
           System.out.println("二叉树为空，没有节点~~~");
       }
    }

    //中序遍历
    public void midOrder(){
        if (root != null){
            root.midOrder();
        } else {
            System.out.println("二叉树为空，没有节点~~~");
        }
    }

    //后序遍历
    public void postOrder(){
        if (root != null){
            root.postOrder();
        } else {
            System.out.println("二叉树为空，没有节点~~~");
        }
    }

    //add

    //find

    //delete
}

/**
 * 二叉树节点类
 */
class BinaryTreeNode{

    public int no;

    public String name;

    //左节点
    public BinaryTreeNode left;
    //右节点
    public BinaryTreeNode right;

    public BinaryTreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //前序遍历
    public void preOrder(){
        //输出根节点
        System.out.println(this);
        //递归输出左节点
        if (this.left != null){
            this.left.preOrder();
        }
        //递归输出右节点
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder(){
        //递归输出左节点
        if (this.left != null){
            this.left.midOrder();
        }
        //输出根节点
        System.out.println(this);
        //递归输出右节点
        if (this.right != null){
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        //递归输出左节点
        if (this.left != null){
            this.left.postOrder();
        }
        //递归输出右节点
        if (this.right != null){
            this.right.postOrder();
        }
        //输出根节点
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "{" +
                "no=" + no + "," +
                "name=" + name +
                '}';
    }
}
