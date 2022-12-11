package cw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("button");

        button.addMouseListener(new ShowDialogLintener(frame));
        frame.add(button, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
class ShowDialogLintener extends MouseAdapter {
    JFrame frame;

    public ShowDialogLintener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        super.mouseClicked(arg0);
        JFileChooser chooser = new JFileChooser(".");
        chooser.showOpenDialog(frame);
        String filePath = chooser.getSelectedFile().getAbsolutePath();
        System.out.println(filePath);
    }
}
