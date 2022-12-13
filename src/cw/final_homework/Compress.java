package cw.final_homework;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 压缩和解压类
 *
 * @author Mean
 */
public class Compress {
    private static final String COMPRESS_COMMAND = "compress";
    private static final String DECOMPRESS_COMMAND = "decompress";
    private static final int BYTE_LENGTH = 8;
    private static final int TWO_BYTES_LENGTH = 16;
    private static final int EXPECTED_ARGS_LENGTH = 3;

    /**
     * 压缩文件
     *
     * @param in  原文件
     * @param out 压缩文件
     */
    public static void compress(File in, File out) {
        // 不同字节的频次
        int[] count = new int[256];
        // 保存字符及其频次
        HashMap<Byte, Integer> map = new HashMap<>(64);
        try {
            InputStream inputStream = new FileInputStream(in);
            int b;
            while ((b = inputStream.read()) != -1) {
                count[b]++;
            }
            // 将词频加入map
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    map.put((byte) i, count[i]);
                }
            }
            // 构造哈夫曼树
            HuffmanTree tree = new HuffmanTree(map);
            HashMap<Byte, String> codes = tree.getCodes();
            // 关闭输入流
            inputStream.close();
            OutputStream outputStream = new FileOutputStream(out);
            // 写入文件头（哈夫曼树的根节点）
            ObjectOutputStream header = new ObjectOutputStream(outputStream);
            header.writeObject(tree.getRoot());
            // 重新打开输出流，从头读取
            inputStream = new FileInputStream(in);
            // 写入缓冲区，达到一字节后写入
            long buffer = 0;
            // 缓冲区位数
            int n = 0;
            // 逐字节读取并压缩
            while ((b = inputStream.read()) != -1) {
                // 未读到文件末尾，将新读取的字节的哈夫曼编码加入缓冲区
                buffer = (buffer << codes.get((byte) b).length()) + Integer.parseInt(codes.get((byte) b), 2);
                // 缓冲区位数增加
                n += codes.get((byte) b).length();
                while (n >= BYTE_LENGTH) {
                    // 达到一字节就写入
                    outputStream.write((int) (buffer >> (n - 8)));
                    n -= 8;
                }
            }
            if (n == 0) {
                // 读到文件末尾，且缓冲区已写入，写入一字节0，表示倒数第二字节填充0位
                outputStream.write(0);
            } else {
                // 读到文件末尾，但缓冲区还有数据，填充0后写入
                outputStream.write((int) (buffer << (8 - n)));
                // 最后写入填充位数
                outputStream.write(8 - n);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压缩文件
     *
     * @param in  压缩文件
     * @param out 解压文件
     */
    public static void decompress(File in, File out) {
        try {
            InputStream inputStream = new FileInputStream(in);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            OutputStream outputStream = new FileOutputStream(out);
            // 读取文件头，重构哈夫曼树
            HuffmanTreeNode root = (HuffmanTreeNode) objectInputStream.readObject();
            // 缓冲区，存放读取但未解压的数据
            long buffer = 0;
            // 缓冲区位数
            int n = 0;
            int b;
            while (true) {
                if (n < 32 && (b = inputStream.read()) != -1) {
                    // 当缓冲区不到32位且未读到文件末尾时，继续读入
                    n += 8;
                    buffer = (buffer << 8) + b;
                } else if (n >= 32) {
                    // 当缓冲区超过32位时，解压缓冲区的第一个字符
                    n = write(buffer, n, root, outputStream);
                } else {
                    // 已读到末尾
                    while (n > TWO_BYTES_LENGTH) {
                        // 缓冲区超过2字节时持续解压
                        n = write(buffer, n, root, outputStream);
                    }
                    // 只剩下最后两字节，去掉最后一字节和填充位
                    n -= ((buffer & 0xff) + 8);
                    buffer >>= ((buffer & 0xff) + 8);
                    // 解压剩下的编码
                    while (n > 0) {
                        n = write(buffer, n, root, outputStream);
                    }
                    break;
                }
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压并写入缓冲区中第一个字符
     *
     * @param buffer 缓冲区
     * @param n      缓冲区位数
     * @param root   哈夫曼树根节点
     * @param out    文件输出流
     * @return 解压一个字符后缓冲区的位数
     */
    private static int write(long buffer, int n, HuffmanTreeNode root, OutputStream out) {
        HuffmanTreeNode node = root;
        try {
            if (root.getLeftChild() == null) {
                // 若根节点无子节点，即只有一种字符，写入该字符
                n--;
            } else {
                // 若有多个字符，根据编码找到原字符
                while (node.getLeftChild() != null) {
                    // 节点有子节点，表示该节点无编码
                    if (((buffer >> (n - 1)) & 1) == 0) {
                        // 编码的下一位为0，说明是左子树上的编码
                        node = node.getLeftChild();
                    } else {
                        // 编码的下一位为1，说明是右子树上的编码
                        node = node.getRightChild();
                    }
                    // 缓冲区减少一位
                    n--;
                }
                // 此时已找到叶节点，写入对应的原字符
            }
            out.write(node.getCharacter());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }

    /**
     * 主方法
     *
     * @param args 无参数或命令和文件路径
     */
    public static void main(String[] args) {
        File in, out;
        if (args.length == 0) {
            // 未传入参数，根据提示进行操作
            System.out.println("1. Compress\n2. Decompress");
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();
            if (op == 1) {
                System.out.println("The file to be compressed: ");
                in = new File(scanner.next());
                System.out.println("Output file path:");
                out = new File(scanner.next());
                Compress.compress(in, out);
            } else {
                System.out.println("The file to be decompressed: ");
                in = new File(scanner.next());
                System.out.println("Output file path:");
                out = new File(scanner.next());
                Compress.decompress(in, out);
            }
            scanner.close();
        } else {
            // 根据命令“compress”或“decompress”以及文件路径进行操作
            if (args[0].compareTo(COMPRESS_COMMAND) == 0 || args[0].compareTo(DECOMPRESS_COMMAND) == 0) {
                if (args.length == EXPECTED_ARGS_LENGTH) {
                    in = new File(args[1]);
                    out = new File(args[2]);
                    if (args[0].compareTo(COMPRESS_COMMAND) == 0) {
                        Compress.compress(in, out);
                    } else {
                        Compress.decompress(in, out);
                    }
                } else {
                    System.out.println("Failed");
                }
            } else {
                System.out.println("Command \"" + args[0] + "\" not found");
            }
        }
    }
}
