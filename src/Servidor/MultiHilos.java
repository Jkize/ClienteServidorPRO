package Servidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensajesServidor_Cliente.fromClient;
import mensajesServidor_Cliente.fromServer;
import modelo.Caja;
import modelo.DAO.DAO;
import modelo.DAO.DAO_Caja;
import modelo.DAO.DAO_Cliente;
import modelo.DAO.DAO_Detallado;
import modelo.DAO.DAO_Empleado;
import modelo.DAO.DAO_Inventario;
import modelo.DAO.DAO_Persona;
import modelo.DAO.DAO_Supermercado;
import modelo.DAO.DAO_Venta;
import modelo.Producto;

import modelo.Empleado;
import modelo.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jhoan Saavedra
 */
public class MultiHilos implements Runnable {

    private DAO_Empleado dao_empleado;
    private DAO_Persona dao_persona;
    private DAO_Caja dao_caja;
    private DAO_Venta dao_venta;
    private DAO_Detallado dao_detallado;
    private DAO_Cliente dao_cliente;
    private DAO_Inventario dao_producto;
    private Socket socket;

    public MultiHilos(Socket socket) throws FileNotFoundException {
        dao_empleado = new DAO_Empleado();
        dao_persona = new DAO_Persona();
        dao_cliente = new DAO_Cliente();
        dao_caja = new DAO_Caja();
        dao_producto = new DAO_Inventario();
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            // Read a message sent by client application
            ObjectInputStream leer = new ObjectInputStream(socket.getInputStream());
            System.out.println("Leyendo mensaje...\n");
            fromClient rec = (fromClient) leer.readObject();
            System.out.println("Captura perfecta del mensaje\n");

            ObjectOutputStream escribir = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("Mensaje " + rec.getId() + " " + rec.getId2() + " " + rec.getOb().toString());
            String[] aux = (rec.getId()).split(",");

            System.out.println("Preparando para responder\n");
            fromServer msg = new fromServer();

            // System.out.println( ((Empleado)rec.getOb()).getIdPersona()+" "+((Empleado)rec.getOb()).getContrasena());
            switch (aux[0]) {

                case "-1":
                    casmenos1(msg, rec);
                    break;

                case "1":
                    case1(msg, rec);
                    break;

                case "2":

                    break;
                case "3":

                    switch (aux[1]) {
                        //Pestaña Vendedor;
                        case "1":
                            switch_PVendedor(aux[2], msg, rec);
                            break;

                        // Pestaña Cajas 
                        case "2":
                            switch_PCajas(aux[2], msg, rec);
                            break;

                        //Pestaña Productoss
                        case "3":
                            switch_PProductos(aux[2], msg, rec);
                            break;

                        //Pestaña Informes
                        case "4":
                            switch_PInformes(aux[2], msg, rec);
                            break;
                    }

                    break;

            }

            escribir.writeObject(msg);
            System.out.println("\n El servidor ha respondido");
            //  socket.close();
            System.out.println("Waiting for client message...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MultiHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private synchronized void casmenos1(fromServer msg, fromClient rec) throws IOException {

        Persona per = this.dao_persona.buscar((long) rec.getOb());
        Empleado empleado = this.dao_empleado.buscar(per.getIdPersona());
        empleado.setNombre(per.getNombre());
        msg.setBool(true);
        msg.setOb(empleado);
    }

    private synchronized void case1(fromServer msg, fromClient rec) throws IOException {
        int n = this.dao_empleado.usuarioValido(((Empleado) rec.getOb()).getIdPersona(), ((Empleado) rec.getOb()).getContrasena());
        if (n == 0) {
            msg.setBool(false);
        } else {
            msg.setBool(true);
            if (n == 1) {
                msg.setOb(1);
            } else {
                msg.setOb(2);
            }
        }

    }

    private void switch_PVendedor(String h, fromServer msg, fromClient rec) throws IOException {
        switch (h) {
            //Crear
            case "1":
                cas311(msg, rec);
                break;
            //Buscar
            case "2":
                cas312(msg, rec);
                break;
            // Eliminar 
            case "3":
                cas313(msg, rec);
                break;
            //Actualizar
            case "4":
                cas314(msg, rec);
                break;
        }
    }

    private void switch_PCajas(String string, fromServer msg, fromClient rec) throws IOException {

        switch (string) {

            //Crear
            case "1":
                cas321(msg, rec);
                break;
            //Buscar
            case "2":
                cas322(msg, rec);
                break;
            // Eliminar 
            case "3":
                cas323(msg, rec);
                break;
            //Actualizar
            case "4":
                cas324(msg, rec);
                break;
            //Obtener alls
            case "5":
                cas325(msg, rec);
                break;
            case "6":
                cas326(msg, rec);
                break;
        }
    }

    private void switch_PProductos(String string, fromServer msg, fromClient rec) throws IOException {
        switch (string) {

            //Crear
            case "1":
                cas331(msg, rec);
                break;
            //Buscar
            case "2":
                cas332(msg, rec);
                break;
            // Eliminar 
            case "3":
                cas333(msg, rec);
                break;
            //Actualizar
            case "4":
                cas334(msg, rec);
                break;
            //Obtener alls
            case "5":
                cas335(msg, rec);
                break;
        }
    }

    private void switch_PInformes(String string, fromServer msg, fromClient rec) {
        switch (string) {

            //Crear
            case "1":
                break;
            //Buscar
            case "2":
                break;
            // Eliminar 
            case "3":
                break;
            //Actualizar
            case "4":
                break;
            //Obtener alls
            case "5":
                break;
        }

    }

    private synchronized void cas311(fromServer msg, fromClient rec) throws IOException {
        Persona persona = new Persona();
        Empleado empleado = (Empleado) rec.getOb();
        persona.setIdPersona(empleado.getIdPersona());
        persona.setNombre(empleado.getNombre());
        if (this.dao_persona.crear(persona) && this.dao_empleado.crear(empleado)) {
            msg.setBool(true);
        }

    }

    private synchronized void cas312(fromServer msg, fromClient rec) throws IOException {
        long id = (long) rec.getOb();
        Empleado emp = new Empleado();
        Persona persona = new Persona();
        Object ob = this.dao_empleado.buscar((long) id);
        if (ob != null) {
            persona = this.dao_persona.buscar((long) id);
            emp = (Empleado) ob;
            emp.setNombre(persona.getNombre());
            msg.setBool(true);
            msg.setOb(emp);
        }

    }

    private synchronized void cas313(fromServer msg, fromClient rec) throws IOException {

        if (this.dao_persona.eliminar((long) rec.getOb()) && this.dao_empleado.eliminar((long) rec.getOb())) {
            msg.setBool(true);
        }

    }

    private synchronized void cas314(fromServer msg, fromClient rec) throws IOException {
        Empleado emp = (Empleado) rec.getOb();
        Persona persona = new Persona();
        persona.setIdPersona(emp.getIdPersona());
        persona.setNombre(emp.getNombre());
        if (this.dao_persona.actualizar(persona) && this.dao_empleado.actualizar(emp)) {
            msg.setBool(true);
        }

    }

    private synchronized void cas321(fromServer msg, fromClient rec) throws IOException {
   
        msg.setBool(dao_caja.crear((Caja) rec.getOb()));
       
        System.out.println("MIRA " + msg.isBool());

    }

    private synchronized void cas322(fromServer msg, fromClient rec) throws IOException {
        Object ob = this.dao_caja.buscar((String) rec.getOb());
        if (ob != null) {
            msg.setBool(true);
            msg.setOb((Caja) ob);
        }

    }

    private synchronized void cas323(fromServer msg, fromClient rec) throws IOException {

        msg.setBool(this.dao_caja.eliminar((String) rec.getOb()));

    }

    private synchronized void cas324(fromServer msg, fromClient rec) throws IOException {
        if (this.dao_caja.actualizar((Caja) rec.getOb())) {
            msg.setBool(true);
        }

    }

    private synchronized void cas325(fromServer msg, fromClient rec) throws IOException {
        ArrayList<Caja> cajas = this.dao_caja.getCajas((String) rec.getOb());
        if (cajas.size() > 0) {
            msg.setBool(true);
            msg.setOb(cajas);
        }
    }

    private void cas326(fromServer msg, fromClient rec) throws IOException {
        ArrayList<String> cajas = this.dao_caja.disponibles();
        msg.setBool(true);
        msg.setOb(cajas);
    }

    private synchronized void cas331(fromServer msg, fromClient rec) throws IOException {

        msg.setBool(this.dao_producto.crear((Producto) rec.getOb()));

    }

    private synchronized void cas332(fromServer msg, fromClient rec) throws IOException {
        Object ob = this.dao_producto.buscar((long) rec.getOb());
        if (ob != null) {
            msg.setBool(true);
            msg.setOb((Producto) ob);
        }
    }

    private synchronized void cas333(fromServer msg, fromClient rec) throws IOException {

        msg.setBool(this.dao_producto.eliminar((long) rec.getOb()));

    }

    private synchronized void cas334(fromServer msg, fromClient rec) throws IOException {

        msg.setBool(this.dao_producto.eliminar((Producto) rec.getOb()));
    }

    private synchronized void cas335(fromServer msg, fromClient rec) throws IOException {
        ArrayList<Producto> productos = this.dao_producto.getProductos();
        msg.setBool(productos.size() > 0);
        msg.setOb(productos);
    }

}
