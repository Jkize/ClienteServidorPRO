/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import mensajesServidor_Cliente.fromClient;
import mensajesServidor_Cliente.fromServer;
import modelo.Caja;
import modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author Jhoan Saavedra
 */
public class ControlGerente implements Initializable {

    private Empleado empleado;
    @FXML
    private ComboBox<String> comboCaja;

    public ControlGerente() {
        empleado = new Empleado();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @FXML
    private TextField txtIdGerente;
    @FXML
    private TextField txtNombreGerente;
    @FXML
    private TextField txtIdSupermercadoGerente;
    @FXML
    private TextField txtCedulaEmpleado;
    @FXML
    private TextField txtNombresyApellidosEmpleado;

    @FXML
    private ComboBox<String> comboCargoEmpleado;
    @FXML
    private Button bttnActualizarDatosEmpleado;
    @FXML
    private Button bttnRegistrarEmpleado;
    @FXML
    private Button bttnBuscarEmpleado;
    @FXML
    private Button bttnEliminarEmpleado;
    @FXML
    private PasswordField txtContraseñaEmpleado;
    @FXML
    private ComboBox<?> comboIDSupermercado;
    @FXML
    private TableView<?> TablaCajas;
    @FXML
    private TableColumn<?, ?> ColumnaIDcajaCaja;
    @FXML
    private TableColumn<?, ?> ColumnaMontoCaja;
    @FXML
    private TextField txtIDcaja;
    @FXML
    private TextField txtMontoCaja;
    @FXML
    private Button bttnRegistrarCaja;
    @FXML
    private Button btnBuscarCaja;
    @FXML
    private Button bttnEliminarcaja;
    @FXML
    private Button bttnActualizarCaja;
    @FXML
    private Button bttnInformacionCaja;
    @FXML
    private TableView<?> TablaInventario;
    @FXML
    private TableColumn<?, ?> CeldaCodigoInventario;
    @FXML
    private TableColumn<?, ?> CeldaProductoInventario;
    @FXML
    private TableColumn<?, ?> CeldaPrecioInventario;
    @FXML
    private TableColumn<?, ?> CeldaCantidadInventario;
    @FXML
    private TextField txtCodigodeBarras;
    @FXML
    private TextField txtNombreProducto;
    @FXML
    private TextField txtPrecioUnitario;
    @FXML
    private TextField txtCantidad;
    @FXML
    private Button bttnRegistrarProducto;
    @FXML
    private Button bttnBuscarProducto;
    @FXML
    private Button bttnEliminarProducto;
    @FXML
    private Button bttnActualizarProducto;
    @FXML
    private Button bttnMostrarInventario;
    @FXML
    private PieChart PastelVentas;
    @FXML
    private TableView<?> TablaPastel;
    @FXML
    private TableColumn<?, ?> PastelProducto;
    @FXML
    private TableColumn<?, ?> PastelVenta;
    @FXML
    private TableColumn<?, ?> PastelPorcentage;
    @FXML
    private BarChart<?, ?> BarrasVentas;
    @FXML
    private TableView<?> TablaBarras;
    @FXML
    private TableColumn<?, ?> BarrasVendedor;
    @FXML
    private TableColumn<?, ?> BarrasVntas;
    @FXML
    private TableColumn<?, ?> BarrasPorcentage;
    @FXML
    private LineChart<?, ?> LineEst;
    @FXML
    private TableView<?> TablaLine;
    @FXML
    private TableColumn<?, ?> MesLine;
    @FXML
    private TableColumn<?, ?> EvolucionVentasLine;
    @FXML
    private StackedAreaChart<?, ?> estMetas;
    @FXML
    private TableView<?> TablaMetas;
    @FXML
    private TableColumn<?, ?> TablaMetasProducto;
    @FXML
    private TableColumn<?, ?> TablaMetasEstado;
    @FXML
    private TableColumn<?, ?> TablaMetasMeta;
    @FXML
    private TableColumn<?, ?> TablaMetasPorcentage;
    @FXML
    private TableColumn<?, ?> TablaMetasCondicion;
    @FXML
    private ComboBox<?> ComboMes;
    @FXML
    private ComboBox<?> ComboAño;
    @FXML
    private Button bttnImprimirReporte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.comboCargoEmpleado.getItems().addAll(
                "AD",
                "VD"
        );
        try {
            actualizarComboBoxCaja();
        } catch (IOException ex) {
            Logger.getLogger(ControlGerente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControlGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarComboBoxCaja() throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8000);

        ObjectOutputStream escribir = new ObjectOutputStream(socket.getOutputStream());
        fromClient rec = new fromClient("3,2,6", "", "");
        escribir.writeObject(rec);

        ObjectInputStream leer = new ObjectInputStream(socket.getInputStream());

        fromServer msg = (fromServer) leer.readObject();

        ArrayList<String> as = (ArrayList<String>) msg.getOb();
        System.out.println(as.toString());
        ObservableList<String> options
                = FXCollections.observableArrayList(as);

        this.comboCaja.setItems(options);
        
        leer.close();
        escribir.close();
        socket.close();

    }

    public void obte() {
        this.txtIdGerente.setText(String.valueOf(this.empleado.getIdPersona()));
        this.txtNombreGerente.setText(this.empleado.getNombre());
        this.txtIdSupermercadoGerente.setText(this.empleado.getIdSupermercado());
        this.txtIdGerente.setDisable(true);
        this.txtNombreGerente.setDisable(true);
        this.txtIdSupermercadoGerente.setDisable(true);
    }

    @FXML
    private void ActualizarEmpleado(ActionEvent event) {
    }

    @FXML
    private void RegistrarEmpleado(ActionEvent event) {

    }

    @FXML
    private void BuscarEmpleado(ActionEvent event) {
    }

    @FXML
    private void EliminarEmpleado(ActionEvent event) {
    }

    @FXML
    private void RegistrarCaja(ActionEvent event) {

        try {
            String idCaja = this.txtIDcaja.getText();
            if (idCaja.length() > 3) {
                double monto = Double.parseDouble(this.txtMontoCaja.getText());
                String idSup = this.txtIdSupermercadoGerente.getText();
                Caja caja = new Caja(idCaja, monto, idSup, 1);
                Socket socket = new Socket("localhost", 8000);

                ObjectOutputStream escribir = new ObjectOutputStream(socket.getOutputStream());
                fromClient rec = new fromClient("3,2,1", "", caja);
                escribir.writeObject(rec);

                ObjectInputStream leer = new ObjectInputStream(socket.getInputStream());

                fromServer msg = (fromServer) leer.readObject();
                System.out.println(msg.isBool());
                leer.close();
                escribir.close();
                socket.close();

                if (msg.isBool()) {
                    JOptionPane.showMessageDialog(null, "Registro Correcto");

                    actualizarComboBoxCaja();

                } else {
                    JOptionPane.showMessageDialog(null, "No se Pudo Registrar ID en uso");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR DATOS");
        }

    }

    @FXML
    private void BuscarCaja(ActionEvent event) {
    }

    @FXML
    private void EliminarCaja(ActionEvent event) {
    }

    @FXML
    private void ActualizarCaja(ActionEvent event) {
    }

    @FXML
    private void InformacionCajas(ActionEvent event) {
    }

    @FXML
    private void RegistrarProducto(ActionEvent event) {
    }

    @FXML
    private void BuscarProducto(ActionEvent event) {
    }

    @FXML
    private void EliminarProducto(ActionEvent event) {
    }

    @FXML
    private void ActualizarProducto(ActionEvent event) {
    }

    @FXML
    private void MostrarInventario(ActionEvent event) {
    }

    @FXML
    private void ImprimirReporte(ActionEvent event) {
    }

}
