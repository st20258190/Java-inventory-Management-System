package Manager;

import Classes.Product;
import Common.FileHandler;
import Common.JFrameActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddProduct extends JFrame {
    public JPanel AddProductPanel;
    private JTextField nameInput;
    private JTextField idInput;
    private JTextField priceInput;
    private JTextField yearInput;
    private JTextField quantityInput;
    private JRadioButton iPhoneRadioButton;
    private JRadioButton iWatchRadioButton;
    private JRadioButton iPadRadioButton;
    private JRadioButton airpodsRadioButton;
    private JRadioButton macRadioButton;
    private JButton backButton;
    private JButton addProductButton;

    public AddProduct() {
        ButtonGroup category = new ButtonGroup();
        category.add(iPadRadioButton);
        category.add(iWatchRadioButton);
        category.add(iPhoneRadioButton);
        category.add(airpodsRadioButton);
        category.add(macRadioButton);

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = new Product();
                product.setName(nameInput.getText());
                product.setId(idInput.getText());
                product.setPrice(priceInput.getText());
                product.setYear(yearInput.getText());
                product.setQty(Integer.parseInt(quantityInput.getText()));

                if (iPadRadioButton.isSelected()) {
                    product.setIpad(true);
                }
                if (iPhoneRadioButton.isSelected()) {
                    product.setIphone(true);
                }
                if (iWatchRadioButton.isSelected()) {
                    product.setIwatch(true);
                }
                if (airpodsRadioButton.isSelected()) {
                    product.setAirpods(true);
                }
                if (macRadioButton.isSelected()) {
                    product.setMac(true);
                }

                FileHandler fileHandler = new FileHandler();
                fileHandler.writeProducts(product);

                ManagerDashboard managerDashboard = new ManagerDashboard();
                JFrameActions jFrameActions = new JFrameActions(managerDashboard, managerDashboard.ManagerDashboardPanel
                        , "Manager Dashboard");
                close();
                jFrameActions.setFrame();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagerDashboard managerDashboard = new ManagerDashboard();
                JFrameActions jFrameActions = new JFrameActions(managerDashboard, managerDashboard.ManagerDashboardPanel
                        , "Manager Dashboard");
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
