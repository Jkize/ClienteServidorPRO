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
import modelo.Empleado;

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
    private Socket socket;

    public MultiHilos(Socket socket) throws FileNotFoundException {
        dao_empleado = new DAO_Empleado();
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            // Read a message sent by client application
            ObjectInputStream leer = new ObjectInputStream(socket.getInputStream());
            System.out.println("Leyendo mensaje...");
            fromClient rec = (fromClient) leer.readObject();
            System.out.println("Captura perfecta del mensaje");

            ObjectOutputStream escribir = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("dat " + rec.getId());
            String[] aux = (rec.getId()).split(",");

            System.out.println("Preparando para responder");
            fromServer msg = new fromServer();

            System.out.println( ((Empleado)rec.getOb()).getIdPersona()+" "+((Empleado)rec.getOb()).getContrasena());

            switch (aux[0]) {

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

            escribir.writeObject(rec);

            //  socket.close();
            System.out.println("Waiting for client message...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MultiHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
