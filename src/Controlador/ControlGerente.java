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
import modelo.Empleado;

/**
 * FXML Controller class
 *
 * @author Jhoan Saavedra
 */
public class ControlGerente implements Initializable {

    private Empleado empleado;

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
    private ComboBox<?> comboCargoEmpleado;
    @FXML
    private ComboBox<?> comboCajaCargoEmpleado;
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
