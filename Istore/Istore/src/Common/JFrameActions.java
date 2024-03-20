package Common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class JFrameActions extends JFrame {
    private JFrame jframe;
    private JPanel jpanel;
    private String title;
    private int width = 800;
    private int height = 600;

    public JFrameActions(JFrame jframe, JPanel jpanel, String title) throws HeadlessException {
        this.jframe = jframe;
        this.jpanel = jpanel;
        this.title = title;
    }
    public void setFrame() {
        jframe.setContentPane(jpanel);
        jframe.setTitle(title);
        jframe.setSize(width, height);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
