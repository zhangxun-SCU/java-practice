package cw.final_homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Objects;

public class GUI extends JFrame {
    private CompressPanel panel = null;
    JButton compress = new JButton("compress");
    JButton deCompress = new JButton("decompress");

    JButton chooseFile = new JButton("选择文件");

    JTextArea compressText = new JTextArea();

    JTextArea deCompressText = new JTextArea();


    String filePath;

    String suffix = ".gyz";

    File in;
    File out;

    public GUI() throws HeadlessException {
        panel = new CompressPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        panel.add(chooseFile);
        panel.add(compress);
        panel.add(deCompress);
        // 设置按钮
        chooseFile.setText("选择文件");
        chooseFile.addMouseListener(new ShowDialogLintener(this));
        chooseFile.setBounds(140, 20, 120, 60);
        compress.setText("压缩");
        compress.setBounds(40, 90, 120, 50);
        deCompress.setText("解压");
        deCompress.setBounds(240, 90, 120, 50);

        compressText = new JTextArea();
        compressText.setBounds(60, 140, 60, 20);
        panel.add(compressText);
        deCompressText = new JTextArea();
        deCompressText.setBounds(260, 140, 60, 20);
        panel.add(deCompressText);

        this.add(panel);
        this.setVisible(true);

        this.setSize(400, 250);
    }

    class ShowDialogLintener extends MouseAdapter {
        JFrame frame;
        public ShowDialogLintener(JFrame frame){
            this.frame = frame;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.showOpenDialog(frame);
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println(filePath);

            compress.addActionListener(new CompressActionListener(filePath));
            deCompress.addActionListener(new DeCompressActionListener(filePath));
        }
    }

    class CompressActionListener implements ActionListener{
        String filePath;

        CompressActionListener(String filePath){
            this.filePath = filePath;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(filePath == null){
                compressText.setText("请先选择文件");
                panel.updateUI();
                panel.updateUI();
                panel.updateUI();
                panel.updateUI();
            }
            System.out.println(filePath);
            in = new File(filePath);
            out = new File(filePath + suffix);
            // 开始压缩
            panel.updateUI();
            compressText.setText("压缩中...");
            panel.updateUI();
            Compress.compress(in, out);
            compressText.setText("压缩完成");
            panel.updateUI();
        }
    }

    class DeCompressActionListener implements ActionListener{

        String filePath;

        DeCompressActionListener(String filePath){
            this.filePath = filePath;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(filePath == null){
                compressText.setText("请先选择文件");
                panel.updateUI();
            }
            System.out.println(filePath);
            in = new File(filePath);
            String fileName = filePath.split("\\.")[0];
            String suffix_1 = filePath.split("\\.")[1];
            String suffix_2 = "";
            if(filePath.split("\\.").length >2){
                suffix_2 = filePath.split("\\.")[2];
            }
            if((suffix).equals("." + suffix_2)){
                String outFilePath = fileName + "." + suffix_1;
                out = new File(outFilePath);
                deCompressText.setText("解压中...");
                panel.updateUI();
                Compress.decompress(in, out);
                deCompressText.setText("解压完成");
                panel.updateUI();
            } else {
                System.out.println(suffix);
                deCompressText.setText("错误文件");
                panel.updateUI();
            }
        }

    }
}

class CompressPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("宋体", Font.BOLD, 20));
    }
}



