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
    private Socket _serverSocket=null;
    PrintWriter write=null;
    BufferedReader reader = null;
    public Cliente(String IP,int Puerto) throws Exception {
        try{
            _serverSocket = new Socket(IP, Puerto);
            write = new PrintWriter(_serverSocket.getOutputStream());
            reader = new BufferedReader( new InputStreamReader( _serverSocket.getInputStream()));
            Thread thr = new Thread(new ClienteReader());
            thr.start();
            System.out.println("Initilized Network");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void enviarProducto(Producto producto){
        try{
            System.out.println(producto.toString());
            write.println(producto.toString());
            write.flush();
        }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex.toString(),"Error al enviar informacion al servidor",JOptionPane.PLAIN_MESSAGE);

                    
        }
    }
    
    private class ClienteReader implements Runnable {

        @Override
        public void run() {
            String msg = "";
            try{
                while((msg = reader.readLine()) != null){
                    System.out.println(msg);
                }                            
            }catch(Exception ex){
                System.out.println(ex.toString());
            }
        }
        
    }
}
