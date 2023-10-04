package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Login extends JFrame{
    private JTextField txtUser;
    private JButton loginButton;
    private JPasswordField txtPassword;
    private JLabel info;
    private JPanel mainPanel;

    public Login(){
        this.setResizable(false);
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        info.setForeground(Color.red);
        loginButton.addActionListener(e -> {
            loginUser();
        });
    }
    private void loginUser(){
        String user = txtUser.getText();
        String password = new String(txtPassword.getPassword());
        if(!validateUser(user,password)){
            info.setText("Usuario Incorrecto");
            txtUser.setText("");
            txtPassword.setText("");
        }else {
            this.dispose();
            Principal ventana = new Principal();
            ventana.load();
            //Acceder al siguiente paso.
        };

    }
    private boolean validateUser(String user, String password){
        return(("Francisco".equals(user)) && ("1234".equals(password)));
    }
    public void load(){
        this.setVisible(true);
    }
}
