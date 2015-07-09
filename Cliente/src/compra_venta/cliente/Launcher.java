/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra_venta.cliente;


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
        FrmCaptura frmCaptura = new FrmCaptura();
        
        frmCaptura.showWnd();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
}
