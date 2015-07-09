/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra_venta.cliente;

import java.io.*;
import java.net.*;

/**
 *
 * @author alex
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        Socket s = new Socket("127.0.0.1",5000);
        PrintWriter p = new PrintWriter(s.getOutputStream());
        Producto prod = new Producto();
//        FrmCaptura frmCaptura = new FrmCaptura();
        
        prod.nombre = "Oscar";
        prod.apellido = "Vera";
        prod.cedula = "6204";
        prod.producto = "Jabon";
        prod.cantidad = "50";
        prod.precio  = "2";
        p.println("dwdwd");
        p.write("Hello Again");
        p.flush();
        System.out.println(prod.toString());
//        frmCaptura.showWnd();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
}
