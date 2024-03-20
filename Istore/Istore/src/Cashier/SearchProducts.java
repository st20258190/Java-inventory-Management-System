package Cashier;

import Classes.Product;
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

public class SearchProducts extends JFrame {
    public JPanel SearchProductsPanel;
    private JButton backButton;
    private JButton searchPriceButton;
    private JTextField input;
    private JButton searchByCategoryButton;
    private JButton searchByNameButton;
    private JList nameList;
    private JList pricelList;
    private JList qtyList;
    private JList yearList;

    public SearchProducts() {
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
        searchPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search search = new Search();
                try {
                    if (search.searchByPrice(input.getText()).size() != 0)
                    {
                        List<Product> productList = new ArrayList<>(search.searchByPrice(input.getText()));
                        nameList.setListData(search.makeNameList(productList).toArray());
                        pricelList.setListData(search.makePriceList(productList).toArray());
                        qtyList.setListData(search.makeQuantityList(productList).toArray());
                        yearList.setListData(search.makeYearList(productList).toArray());
                    }
                    else {
                        String[] array = {"Not found"};
                        nameList.setListData(array);
                        pricelList.setListData(array);
                        qtyList.setListData(array);
                        yearList.setListData(array);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        searchByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search search = new Search();
                try {
                    if (search.searchByName(input.getText()).size() != 0)
                    {
                        List<Product> productList = new ArrayList<>(search.searchByName(input.getText()));
                        nameList.setListData(search.makeNameList(productList).toArray());
                        pricelList.setListData(search.makePriceList(productList).toArray());
                        qtyList.setListData(search.makeQuantityList(productList).toArray());
                        yearList.setListData(search.makeYearList(productList).toArray());
                    }
                    else {
                        String[] array = {"Not found"};
                        nameList.setListData(array);
                        pricelList.setListData(array);
                        qtyList.setListData(array);
                        yearList.setListData(array);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        searchByCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search search = new Search();
                try {
                    if (search.searchByCategory(input.getText()).size() != 0)
                    {
                        List<Product> productList = new ArrayList<>(search.searchByCategory(input.getText()));
                        nameList.setListData(search.makeNameList(productList).toArray());
                        pricelList.setListData(search.makePriceList(productList).toArray());
                        qtyList.setListData(search.makeQuantityList(productList).toArray());
                        yearList.setListData(search.makeYearList(productList).toArray());
                    }
                    else {
                        String[] array = {"Not found"};
                        nameList.setListData(array);
                        pricelList.setListData(array);
                        qtyList.setListData(array);
                        yearList.setListData(array);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void close() {
        WindowEvent windowEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
    }
}
