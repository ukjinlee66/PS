import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ret;
    static int N,M;
    static String In[];

    public static void main(String[] args)    throws IOException {
        N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for(int i=0;i<N;i++) {
            In = br.readLine().split(" ");
            Node node = new Node(In[0]);
            if (!In[1].equals(".")) {
                node.setLeft(new Node(In[1]));
            }
            if (!In[2].equals(".")) {
                node.setRight(new Node(In[2]));
            }

            if (tree.root == null) {
                tree.setRoot(node);
            } else {
                tree.insert(tree.root, node);
            }
        }
        preOrder(tree.getRoot());
        bw.write("\n");
        inorder(tree.getRoot());
        bw.write("\n");
        postorder(tree.getRoot());
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    public static void preOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        bw.write(node.data);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public static void inorder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        bw.write(node.data);
        inorder(node.getRight());
    }

    public static void postorder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        bw.write(node.data);
    }

    public static class Tree{
        Node root;
        public Tree(Node root) {
            this.root = root;
        }
        public Tree() {
            this.root = null;
        }
        public void setRoot(Node root) {
            this.root = root;
        }
        public Node getRoot() {
            return this.root;
        }
        public void insert(Node root , Node node) {
            Node cur = root;
            if (cur.left != null && cur.left.data.equals(node.data)) {
                cur.setLeft(node);
            } else if (cur.right != null && cur.right.data.equals(node.data)) {
                cur.setRight(node);
            } else {
                if (cur.left != null) {
                    insert(cur.left, node);
                }
                if (cur.right != null) {
                    insert(cur.right, node);
                }
            }
            return;
        }
    }


    public static class Node {
        Node left;
        Node right;
        String data;
        public Node(String data) {
            this.data = data;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public Node getLeft() {
            if (this.left == null) {
                return null;
            }
            return this.left;
        }
        public Node getRight() {
            if (this.right == null) {
                return null;
            }
            return this.right;
        }
    }
}
