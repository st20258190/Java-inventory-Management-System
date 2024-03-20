package Cashier;

import Classes.Product;
import Common.FileHandler;
import Common.JFrameActions;
import Common.Search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewAllProducts extends JFrame {
    public JPanel ViewAllPanel;
    private JList nameList;
    private JList priceList;
    private JList quantityList;
    private JList yearList;
    private JButton backButton;

    public ViewAllProducts() {

        Search search = new Search();
        FileHandler fileHandler = new FileHandler();
        try {
            List<Product> productList = new ArrayList<>(fileHandler.readProducts());
            nameList.setListData(search.makeNameList(productList).toArray());
            priceList.setListData(search.makePriceList(productList).toArray());
            quantityList.setListData(search.makeQuantityList(productList).toArray());
            yearList.setListData(search.makeYearList(productList).toArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        backButton.addActionListener(new ActionListener() {
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
