package Cashier;

import Common.JFrameActions;
import Login.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CashierDashboard extends JFrame {
    public JPanel CashierDashboardPanel;
    private JButton backBtn;
    private JButton searchProductsButton;
    private JButton searchStockDetailsButton;
    private JButton viewAllProductsButton;

    public CashierDashboard() {
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                JFrameActions jFrameActions = new JFrameActions(login, login.LoginPanel, "Login");
                close();
                jFrameActions.setFrame();
            }
        });
        searchStockDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchStock searchStock = new SearchStock();
                JFrameActions jFrameActions = new JFrameActions(searchStock, searchStock.SearchStockPanel
                        , "Search Stocks");
                close();
                jFrameActions.setFrame();
            }
        });
        searchProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchProducts searchProducts = new SearchProducts();
                JFrameActions jFrameActions = new JFrameActions(searchProducts, searchProducts.SearchProductsPanel
                        , "Search Products");
                close();
                jFrameActions.setFrame();
            }
        });
        viewAllProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewAllProducts viewAllProducts = new ViewAllProducts();
                JFrameActions jFrameActions = new JFrameActions(viewAllProducts, viewAllProducts.ViewAllPanel
                        , "All Products");
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
