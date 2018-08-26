/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sergi
 */
public class ControlVenta implements Initializable {

    @FXML
    private TableView<?> ProductosMarcados;
    @FXML
    private TableColumn<?, ?> ColumnaCodigoBarras;
    @FXML
    private TableColumn<?, ?> ColumnaPrecioUnitario;
    @FXML
    private TableColumn<?, ?> ColumnaCantidad;
    @FXML
    private TextField txtNumeroCaja;
    @FXML
    private TextField txtCodigoProducto;
    @FXML
    private TextField txtCantidadProducto;
    @FXML
    private TextField txtTotalPagar;
    @FXML
    private Button btnAgregarProducto;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TextField txtpago;
    @FXML
    private TextField txtCambio;
    @FXML
    private TextField txtCedulaCliente;
    @FXML
    private Button btnBuscr;
    @FXML
    private TextField txtDireccionCliente;
    @FXML
    private TextField txtNombreCliente;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnActualizarDatos;
    @FXML
    private TextField txtCedulaVendedor;
    @FXML
    private Button btnLiquidarVenta;
    @FXML
    private Button btnImprimirFactura;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AgregaProducto(ActionEvent event) {
    }

    @FXML
    private void EliminaProducto(ActionEvent event) {
    }

    @FXML
    private void BuscarCliente(ActionEvent event) {
    }

    @FXML
    private void RegistrarCliente(ActionEvent event) {
    }

    @FXML
    private void ActualizarDatosCliente(ActionEvent event) {
    }

    @FXML
    private void LiquidaVenta(ActionEvent event) {
    }

    @FXML
    private void ImprimeFactura(ActionEvent event) {
    }
    
}
