import Common.JFrameActions;
import Login.Login;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        JFrameActions jFrameActions = new JFrameActions(login, login.LoginPanel, "Login");
        jFrameActions.setFrame();

//        login.setContentPane(login.LoginPanel);
//        login.setTitle("Login");
//        login.setSize(300,200);
//        login.setVisible(true);
//        login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
