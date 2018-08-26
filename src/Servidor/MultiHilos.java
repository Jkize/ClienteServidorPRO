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
                    System.out.println("\n Entra al caso -1");
                    Persona per = this.dao_persona.buscar((long) rec.getOb());
                    Empleado empleado = this.dao_empleado.buscar(per.getIdPersona());
                    empleado.setNombre(per.getNombre());
                    msg.setBool(true);
                    msg.setOb(empleado);
                    escribir.writeObject(msg);
                    break;

                case "1":
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
                    escribir.writeObject(msg);
                    break;

            }

            // escribir.writeObject(msg);
            System.out.println("\n El servidor ha respondido");
            //  socket.close();
            System.out.println("Waiting for client message...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MultiHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
