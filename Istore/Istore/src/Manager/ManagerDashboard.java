package Manager;

import Common.JFrameActions;
import Login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ManagerDashboard extends JFrame {
    public JPanel ManagerDashboardPanel;
    private JButton createAccountsBtn;
    private JButton addProductsButton;
    private JButton backBtn;

    public ManagerDashboard() {

        createAccountsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAccount addAccount = new AddAccount();
                JFrameActions jFrameActions = new JFrameActions(addAccount, addAccount.AddAccountsPanel
                        , "Add Accounts");
                close();
                jFrameActions.setFrame();
            }
        });
        addProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProduct addProduct = new AddProduct();
                JFrameActions jFrameActions = new JFrameActions(addProduct, addProduct.AddProductPanel
                        , "Add Products");
                close();
                jFrameActions.setFrame();
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                JFrameActions jFrameActions = new JFrameActions(login, login.LoginPanel, "Login");
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
