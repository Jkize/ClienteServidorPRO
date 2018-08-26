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
import modelo.DAO.DAO_Empleado;
import modelo.DAO.DAO_Persona;
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
    private Socket socket;

    public MultiHilos(Socket socket) throws FileNotFoundException {
        dao_empleado = new DAO_Empleado();
        dao_persona = new DAO_Persona();
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

    private void switch_PVendedor(String h, fromServer msg, fromClient rec) {
        switch (h) {
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
        }
    }

    private void switch_PCajas(String string, fromServer msg, fromClient rec) {

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

    private void switch_PProductos(String string, fromServer msg, fromClient rec) {
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

    }

    private synchronized void cas312(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas313(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas314(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas321(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas322(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas323(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas324(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas325(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas331(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas332(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas334(fromServer msg, fromClient rec) throws IOException {

    }

    private synchronized void cas335(fromServer msg, fromClient rec) throws IOException {

    }
}
