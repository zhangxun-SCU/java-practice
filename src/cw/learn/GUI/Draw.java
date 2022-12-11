package cw.learn.GUI;

import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame {
    private MyPanel mp = null;

    public Draw(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Draw();
    }

}

class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        // ���ø��෽����ɳ�ʼ��
        super.paint(g);
        // ��Բ
        g.drawOval(150, 150, 100, 100);
        // ֱ��
        g.drawLine(150, 150, 350, 350);
        // ����
        g.drawRect(10, 10, 10, 10);
        // ������
        g.setColor(Color.cyan);
        g.fillRect(10, 20, 10, 10);
        // ͼƬ
        //   1. ��ȡͼƬ��Դ
        //   2. draw
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/644/100715997_p0_master1200.jpg"));
//        g.drawImage(image, 10, 30, 100, 100, this);
        g.setColor(Color.cyan);
        g.setFont(new Font("����", Font.BOLD, 20));
        g.drawString("Hello", 30, 30);
    }
}
