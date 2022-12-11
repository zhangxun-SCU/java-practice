package cw.final_homework;


import java.util.ArrayList;

public class HuffmanTree {
    HuffmanTreeNode root;
    HuffmanTreeNode corPos;
    HuffmanTreeNode[] leafNodes;
    ArrayList<HuffmanTreeNode> nodeLists;

}

class HuffmanTreeNode{
    HuffmanTreeNode left, right ,parent;
    long weight;

    public HuffmanTreeNode(long weight, HuffmanTreeNode left, HuffmanTreeNode right, HuffmanTreeNode parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.weight = weight;
    }
}
