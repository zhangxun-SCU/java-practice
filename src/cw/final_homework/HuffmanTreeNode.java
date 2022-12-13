package cw.final_homework;


import java.io.Serializable;

class HuffmanTreeNode implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 该节点表示的字符（字节）
     */
    private byte character;
    /**
     * 该字符对应的哈夫曼编码
     */
    private String code;
    /**
     * 该字符的权值（频次）或子节点的权值之和
     */
    private final transient int weight;
    /**
     * 子节点
     */
    private final HuffmanTreeNode leftChild, rightChild;

    /**
     * 以字符及其权值构造节点
     *
     * @param character 字符
     * @param weight    符的权值（频次）
     */
    public HuffmanTreeNode(byte character, int weight) {
        this.character = character;
        this.weight = weight;
        leftChild = null;
        rightChild = null;
    }

    /**
     * 以两个节点为子节点构造节点
     *
     * @param left  左子节点
     * @param right 右子节点
     */
    public HuffmanTreeNode(HuffmanTreeNode left, HuffmanTreeNode right) {
        weight = left.getWeight() + right.getWeight();
        leftChild = left;
        rightChild = right;
    }

    public int getWeight() {
        return weight;
    }

    public byte getCharacter() {
        return character;
    }

    public HuffmanTreeNode getLeftChild() {
        return leftChild;
    }

    public HuffmanTreeNode getRightChild() {
        return rightChild;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
