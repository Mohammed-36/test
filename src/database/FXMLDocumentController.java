/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author RemasTech
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label labelout;
    @FXML
    private Button Register;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnLogin(ActionEvent event) throws SQLException {
      Model m = new Model();
      boolean b = m.loginuser(txtUserName.getText(), txtPassword.getText());
        if (b){
            labelout.setText("Wellcome");
        }else 
        {
            labelout.setText("Wrong UserName or Password");
        }
    }

    @FXML
    private void btnRegister(ActionEvent event) throws SQLException {
        
        Model m = new Model();
        m.registerUser(txtUserName.getText(), txtPassword.getText());
    }

    @FXML
    private void txtUser(ActionEvent event) {
    }

    @FXML
    private void txtPass(ActionEvent event) {
    }
    
}
