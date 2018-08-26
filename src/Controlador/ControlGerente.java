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
 * @author sergi
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
    private TextField txtCedulaVendedor;
    @FXML
    private TextField txtNombresyApellidosVendedor;

    @FXML
    private ComboBox<String> comboIDSupermercado;

    @FXML
    private ComboBox<?> comboCargoVendedor;
    @FXML
    private ComboBox<?> comboCajaCargoVendedor;
    @FXML
    private Button btnActualizarDatosVendedor;
    @FXML
    private Button btnIngresarVendedor;
    @FXML
    private Button btnBuscarVendedor;
    @FXML
    private Button btnEliminarvendedor;
    @FXML
    private PasswordField txtContraseñaVendedor;
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
    private Button btnIngresarCaja;
    @FXML
    private Button btnBuscarCaja;
    @FXML
    private Button btnEliminarcaja;
    @FXML
    private Button btnActualizarCaja;
    @FXML
    private Button btnInformacionCaja;
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
    private Button btnIngresarProducto;
    @FXML
    private Button btnBuscarInventario;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private Button btnActualizarInventario;
    @FXML
    private Button btnMostrarInventario;
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
    private TableColumn<?, ?> BarrasVntas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    
    public void obte(){
        this.comboIDSupermercado.getItems().add(this.empleado.getIdSupermercado());
    }
    
    @FXML
    private void IngresaCaja(ActionEvent event) {

    }

    @FXML
    private void BuscaCaja(ActionEvent event) {
    }

    @FXML
    private void EliminaCaja(ActionEvent event) {
    }

    @FXML
    private void ActualizaCaja(ActionEvent event) {
    }

    @FXML
    private void InformacionCajas(ActionEvent event) {
    }

    @FXML
    private void ingresaProducto(ActionEvent event) {
    }

    @FXML
    private void BuscaInventario(ActionEvent event) {
    }

    @FXML
    private void EliminaProducto(ActionEvent event) {
    }

    @FXML
    private void actualizaInventario(ActionEvent event) {
    }

    @FXML
    private void mostrarInventario(ActionEvent event) {
    }

    @FXML
    private void MesConsulta(ActionEvent event) {
    }

    @FXML
    private void AñoConsulta(ActionEvent event) {
    }

}
