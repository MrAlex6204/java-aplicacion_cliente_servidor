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
        /*
            Generamos el texto pero con la informacion capturada
            y le indicamos al servidor que se trata de un Registro con la 
            palabra clave REGITRO
        */
        return String.join("|","REGISTRO",this.nombre,this.apellido,this.cedula,this.producto,this.precio,this.cantidad);
    }
     
            
    
}
