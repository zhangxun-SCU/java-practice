package cw.final_homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    private CompressPanel panel = null;
    JButton compress = new JButton("compress");
    JButton deCompress = new JButton("decompress");

    String filePath;

    public GUI() throws HeadlessException {
        panel = new CompressPanel();
        this.setSize(400, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        compress.addMouseListener(new ShowDialogLintener(this, filePath));
        deCompress.addMouseListener(new ShowDialogLintener(this, filePath));
        compress.addActionListener(new CompressActionListener(filePath));
        deCompress.addActionListener(new DeCompressActionListener(filePath));
        compress.setFont(new Font("宋体", Font.BOLD, 20));
        compress.setBounds(700, 400, 100, 30);
        deCompress.setFont(new Font("宋体", Font.BOLD, 20));
        deCompress.setBounds(700, 600, 100, 30);

        panel.add(compress);
        panel.add(deCompress);

        this.add(panel);

    }

    public static void main(String[] args) {
        new GUI();
    }
}

class CompressPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("宋体", Font.BOLD, 20));

    }
}

class CompressActionListener implements ActionListener{
    String filePath;

    CompressActionListener(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(filePath);
    }
}

class DeCompressActionListener implements ActionListener{

    String filePath;

    DeCompressActionListener(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(filePath);
    }
}

class ShowDialogLintener extends MouseAdapter {
    JFrame frame;
    String filePath;
    public ShowDialogLintener(JFrame frame, String filePath){
        this.frame = frame;
        this.filePath = filePath;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.showOpenDialog(frame);
        filePath = fileChooser.getSelectedFile().getAbsolutePath();

        System.out.println(filePath);

    }
}