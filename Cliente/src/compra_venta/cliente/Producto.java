/*
 * Esta clase contiene la informacion de nuestro prooducto
 */
package compra_venta.cliente;

/**
 *
 * @author MrAlex6204
 */
public class Producto {
    
    public String 
            nombre = "",
            apellido = "",
            cedula = "",
            producto = "",
            precio = "",
            cantidad ="";
    
    public void limpiar(){
            this.nombre = "";
            this.apellido = "";
            this.cedula = "";
            this.producto = "";
            this.precio = "";
            this.cantidad ="";
    }
    
    @Override
    public String toString(){
        return String.join("|",this.nombre,this.apellido,this.cedula,this.producto,this.precio,this.cantidad);
    }
     
            
    
}
