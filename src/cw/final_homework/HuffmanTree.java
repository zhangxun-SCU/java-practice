package cw.final_homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class HuffmanTree extends Tree {
    /**
     * HashMap作词典，保存原字符（字节）的编码和对应的哈夫曼编码
     */
    HashMap<Byte, String> codes = new HashMap<>(64);

    /**
     * 构造哈夫曼树
     *
     * @param map 不同字符（字节）及对应的权重（频次）
     */
    public HuffmanTree(HashMap<Byte, Integer> map) {
        // 动态数组保存树林
        ArrayList<Tree> trees = new ArrayList<>();
        // 用于合并树的临时变量
        Tree tmp;
        // 遍历map，以每个字符及其频次构建一颗无子节点的树，加入树林
        map.forEach((character, weight) -> trees.add(new Tree(character, weight)));
        // 对树林以权值升序排列
        trees.sort(Comparator.naturalOrder());
        System.out.println("字节种类: " + trees.size());
        System.out.println("频次方差: " + fc(trees));
        // 合并值最小的树直到只剩下一棵树
        while (trees.size() > 1) {
            // 将两棵权值最小的树合并为新树
            tmp = new Tree(trees.get(0), trees.get(1));
            // 删除这两棵树
            trees.remove(0);
            trees.remove(0);
            // 将新树添加到树林中
            addTree(tmp, trees);
        }
        // 将这棵树的根节点作为哈夫曼树的根节点
        root = trees.get(0).getRoot();
        // 生成哈夫曼编码
        if (root.getLeftChild() == null) {
            root.setCode("0");
        } else {
            generateCode(root, "");
        }
        // 保存哈夫曼编码
        saveCodes(root);
    }

    /**
     * 生成哈夫曼编码
     *
     * @param root 哈夫曼树的根节点
     * @param code 初始编码（前缀）
     */
    private void generateCode(HuffmanTreeNode root, String code) {
        // 如果该节点不是叶节点
        if (root.getLeftChild() != null) {
            // 分别以code||0和code||1为前缀生成子节点的编码
            generateCode(root.getLeftChild(), code + "0");
            generateCode(root.getRightChild(), code + "1");
        } else {
            // 如果该节点为叶节点，则编码就是code
            root.setCode(code);
        }
    }

    /**
     * 保存哈夫曼编码
     *
     * @param root 哈夫曼树的根节点
     */
    private void saveCodes(HuffmanTreeNode root) {
        // 如果该节点为叶节点
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            // 保存该节点的编码至codes
            codes.put(root.getCharacter(), root.getCode());
        } else {
            // 如果该节点不是叶节点，则保存子节点的编码
            saveCodes(root.getLeftChild());
            saveCodes(root.getRightChild());
        }
    }

    /**
     * 将一棵树插入到升序排列的树林中
     *
     * @param tree  待插入的树
     * @param trees 树林
     */
    private static void addTree(Tree tree, ArrayList<Tree> trees) {
        int i;
        for (i = 0; i < trees.size(); i++) {
            if (tree.compareTo(trees.get(i)) <= 0) {
                break;
            }
        }
        trees.add(i, tree);
    }

    public HashMap<Byte, String> getCodes() {
        return codes;
    }

    /**
     * 计算字节频次方差
     * @param trees 树林
     * @return 字节频次方差
     */
    public static double fc(ArrayList<Tree> trees) {
        int size = trees.size();
        long total = 0;
        for (Tree tree : trees) {
            total += tree.weight;
        }
        double a = total / size;
        for (Tree tree : trees) {
            total += Math.pow(tree.weight - a, 2);
        }
        return total / size;
    }
}


