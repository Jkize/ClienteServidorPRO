/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.Empleado;
import mensajesServidor_Cliente.fromClient;
import mensajesServidor_Cliente.fromServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sergio
 */
public class ControlInicio implements Initializable {

    @FXML
    private AnchorPane PanelPrincipal;
    @FXML
    private ImageView imagen;
    @FXML
    private AnchorPane Panel;
    @FXML
    private Label Usuario;
    @FXML
    private Label Contraseña;
    @FXML
    private TextField TxUsuario;
    @FXML
    private Button Entrar;
    @FXML
    private PasswordField TxContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TxUsuario.setText("1010");
        TxContraseña.setText("holasoy");
    }

    public void pv() throws Exception {

    }

    @FXML
    private void handleButtonEntar(ActionEvent event) throws Exception {
        //Primer envio de Socket
        Socket socket = new Socket("localhost", 8000);

        ObjectOutputStream escribir = new ObjectOutputStream(socket.getOutputStream());

        Empleado em = new Empleado();

        em.setIdPersona(Long.parseLong(TxUsuario.getText()));
        em.setContrasena(TxContraseña.getText());

        System.out.println(em.getIdPersona() + " " + em.getContrasena());

        System.out.println("Enviando mensaje al Servidor");
        fromClient msg = new fromClient("1", "null", em);
        escribir.writeObject(msg);
        ObjectInputStream leer = new ObjectInputStream(socket.getInputStream());
        System.out.println("Mensaje del servido: ");

        fromServer reci = (fromServer) leer.readObject();
        escribir.close();
        leer.close();
        socket.close();
        if (reci.isBool()) {
            int n = (int) reci.getOb();
            if (n == 1) {
                CambioScena(event, "Gerente", em.getIdPersona());
            } else {
                CambioScena(event, "Ventas", em.getIdPersona());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR");
        }

    }

    private void CambioScena(ActionEvent event, String name, long id) throws IOException, ClassNotFoundException {

        // this line gets the Stage Information
        //tutorial video https://www.youtube.com/watch?v=XCgcQTQCfJQ + combinación https://www.youtube.com/watch?v=x3UlAwS6dEE
        Socket socket = new Socket("localhost", 8000);
        ObjectOutputStream escribir = new ObjectOutputStream(socket.getOutputStream());

        fromClient fr = new fromClient("-1", "null", (long) id);
        escribir.writeObject(fr);

        ObjectInputStream leer = new ObjectInputStream(socket.getInputStream());
 
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/Vista/" + name.toString() + ".fxml")); 
        Loader.load(); 
        
        Scene GerenteScene = new Scene(Loader.getRoot()); 
        
        ControlGerente as = Loader.getController();

        as.setEmpleado(((Empleado) ((fromServer) leer.readObject()).getOb()));
        as.obte();
        socket.close();
        escribir.close();
        leer.close();
        
        Stage windows = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        windows.setScene(GerenteScene);
        windows.show();
    }

}
