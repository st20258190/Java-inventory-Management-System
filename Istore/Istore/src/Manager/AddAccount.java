package Manager;

import Classes.Account;
import Common.FileHandler;
import Common.JFrameActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AddAccount extends JFrame {
    public JPanel AddAccountsPanel;
    private JTextField nameInput;
    private JTextField ageInput;
    private JTextField emailInput;
    private JTextField telephoneInput;
    private JTextField idInput;
    private JRadioButton managerRadioButton;
    private JRadioButton cashierRadioButton;
    private JButton backButton;
    private JButton addAccountButton;


    public AddAccount() {
        ButtonGroup accountType = new ButtonGroup();
        accountType.add(managerRadioButton);
        accountType.add(cashierRadioButton);

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
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account account = new Account();
                account.setId(idInput.getText());
                account.setName(nameInput.getText());
                account.setAge(ageInput.getText());
                account.setEmail(emailInput.getText());
                account.setTel(telephoneInput.getText());

                if (managerRadioButton.isSelected()) {
                    account.setCashier(true);
                }
                if (cashierRadioButton.isSelected()) {
                    account.setManager(true);
                }

                FileHandler fileHandler = new FileHandler();
                fileHandler.writeAccounts(account);

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
