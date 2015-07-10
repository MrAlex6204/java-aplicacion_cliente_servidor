/*
 * Esta clase mantendra la comunicacion con el servidor.
 */
package compra_venta.cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MrAlex6204
 */
public class Cliente {

    private Socket _serverSocket = null;
    private PrintWriter _write = null;
    private BufferedReader _reader = null;
    private ITransaccionEntrante _transaccion = null;

    public Cliente(String IP, int Puerto) throws Exception {
        try {
            _serverSocket = new Socket(IP, Puerto);
            _write = new PrintWriter(_serverSocket.getOutputStream(), true);
            _reader = new BufferedReader(new InputStreamReader(_serverSocket.getInputStream()));
            Thread thr = new Thread(new ClienteReader());
            thr.start();
            System.out.println("-Se a establecido la conexion con el servidor" + this.toString());
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void setTransaccionEntrante(ITransaccionEntrante transaccion){
        _transaccion = transaccion;
    }
    
    public void enviarProducto(Producto producto) {
        try {
            System.out.println(producto.toString());
            _write.println(producto.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error al enviar informacion al servidor", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public interface ITransaccionEntrante {
        /*
            Esta clase interface nos ayudara a notificarle a la aplicacion
            cuando una transaccion sea enviada por el servidor.
        */
        public void Transaccion(String transaccion);
    }
    
    private class ClienteReader implements Runnable {

        @Override
        public void run() {
            String transaccionRealizada = "";
            System.out.println("Mensajes del Servidor");
            System.out.println("{");
            try {
                while ((transaccionRealizada = _reader.readLine()) != null) {
                    System.out.println("\t-" + transaccionRealizada);
                    
                    if(_transaccion !=null){
                        //===>Realizar notificacion 
                        _transaccion.Transaccion(transaccionRealizada);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            System.out.println("\t * Se ha cerrado la conexion con el servidor *");
            System.out.println("}");

        }

    }
}
