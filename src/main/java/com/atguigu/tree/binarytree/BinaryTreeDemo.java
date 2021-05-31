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
//        System.out.println("中序遍历~~~");
//        binaryTree.midOrder();
//        System.out.println("后序遍历~~~");
//        binaryTree.postOrder();

        binaryTree.delNode(10);
        System.out.println("删除元素之后前序遍历~~~");
        binaryTree.preOrder();
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
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，没有节点~~~");
        }
    }

    //中序遍历
    public void midOrder() {
        if (root != null) {
            root.midOrder();
        } else {
            System.out.println("二叉树为空，没有节点~~~");
        }
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空，没有节点~~~");
        }
    }

    /**
     * delete 递归删除节点
     * @param no
     * 1、如果要删除的是叶子节点，则删除该节点
     * 2、如果要删除的是非叶子节点，则删除该子树
     *
     * 思路：
     * 1、因为二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，而不能去判断当前这个节点是不是需要删除节点
     * 2、如果当前节点的左子节点不为空，并且左子节点就是要删除节点，就将this.left=null;并且就返回（结束递归删除）
     * 3、如果当前节点的右子节点不为空，并且右子节点就是要删除节点，就将this.right=null;并且就返回（结束递归删除）
     * 4、如果第2和3步没有删除节点，那么我们就需要向左子树进行递归删除
     * 5、如果第4步也没有删除节点，则应当向右子树进行递归删除
     */
    public void delNode(int no) {
        if (root == null){
            System.out.println("空树，不能删除~~~");
            return;
        }

        if (root.no == no){
            root = null;
        } else {
            //递归删除
            root.delNode(no);
        }
    }
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

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
            this.left.delNode(no);
        }

        if (this.right != null){
            this.right.delNode(no);
        }
    }

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
