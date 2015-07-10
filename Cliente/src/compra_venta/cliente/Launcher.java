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
        //===>Creamos una nueva instancia de nuestra ventana
        final FrmCaptura frmCaptura = new FrmCaptura();
        
        //===>Indicamos el titulo de la ventana
        frmCaptura.setTitle("\t** Aplicacion cliente **");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
               frmCaptura.setVisible(true);
            }
        });
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
}
