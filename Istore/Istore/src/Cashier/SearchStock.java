package Cashier;

import Classes.Product;
import Common.FileHandler;
import Common.JFrameActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStock extends JFrame {
    public JPanel SearchStockPanel;
    private JTextField nameInput;
    private JButton searchByIDButton;
    private JButton searchByNameButton;
    private JButton backButton;
    private JLabel idText;
    private JLabel nameText;
    private JLabel priceText;
    private JLabel yearText;
    private JLabel quantityText;
    private JLabel categoryText;

    public SearchStock() {
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
        searchByIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler fileHandler = new FileHandler();
                try {
                    List<Product> productList = new ArrayList<>(fileHandler.readProducts());

                    for (Product product : productList) {
                        if (product.getId().equals(nameInput.getText())) {
                            idText.setText(product.getId());
                            nameText.setText(product.getName());
                            priceText.setText(product.getPrice());
                            yearText.setText(product.getYear());
                            quantityText.setText(String.valueOf(product.getQty()));
                            if (product.isIphone()) {
                                categoryText.setText("iPhone");
                            }
                            if (product.isIwatch()) {
                                categoryText.setText("iWatch");
                            }
                            if (product.isIpad()) {
                                categoryText.setText("iPad");
                            }
                            if (product.isAirpods()) {
                                categoryText.setText("Airpods");
                            }
                            if (product.isMac()) {
                                categoryText.setText("Mac");
                            }
                            break;
                        }
                        else {
                            idText.setText("Not Found");
                            nameText.setText("Not Found");
                            priceText.setText("Not Found");
                            yearText.setText("Not Found");
                            quantityText.setText("Not Found");
                            categoryText.setText("Not Found");
                        }
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        searchByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler fileHandler = new FileHandler();
                try {
                    List<Product> productList = new ArrayList<>(fileHandler.readProducts());

                    for (Product product : productList) {
                        if (product.getName().equals(nameInput.getText())) {
                            idText.setText(product.getId());
                            nameText.setText(product.getName());
                            priceText.setText(product.getPrice());
                            yearText.setText(product.getYear());
                            quantityText.setText(String.valueOf(product.getQty()));
                            if (product.isIphone()) {
                                categoryText.setText("iPhone");
                            }
                            if (product.isIwatch()) {
                                categoryText.setText("iWatch");
                            }
                            if (product.isIpad()) {
                                categoryText.setText("iPad");
                            }
                            if (product.isAirpods()) {
                                categoryText.setText("Airpods");
                            }
                            if (product.isMac()) {
                                categoryText.setText("Mac");
                            }
                            break;
                        }
                        else {
                            idText.setText("Not Found");
                            nameText.setText("Not Found");
                            priceText.setText("Not Found");
                            yearText.setText("Not Found");
                            quantityText.setText("Not Found");
                            categoryText.setText("Not Found");
                        }
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
