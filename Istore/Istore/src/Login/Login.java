package Login;

import Cashier.CashierDashboard;
import Classes.Product;
import Common.FileHandler;
import Common.JFrameActions;
import Manager.ManagerDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame {
    public JPanel LoginPanel;
    private JButton managerLoginBtn;
    private JButton cashierLoginBtn;


    public Login() {
        managerLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagerDashboard managerDashboard = new ManagerDashboard();
                JFrameActions jFrameActions = new JFrameActions(managerDashboard, managerDashboard.ManagerDashboardPanel
                        , "Manager Dashboard");
                close();
                jFrameActions.setFrame();
            }
        });
        cashierLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashierDashboard cashierDashboard = new CashierDashboard();
                JFrameActions jFrameActions = new JFrameActions(cashierDashboard, cashierDashboard.CashierDashboardPanel
                        , "Cashier Dashboard");
                close();
                jFrameActions.setFrame();
            }
        });
    }

    private void close() {
        WindowEvent windowEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
    }

}
