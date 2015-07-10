/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra_venta.servidor;

import java.net.*;
import java.io.*;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Calendar;

/**
 *
 * @author MrAlex6204
 */
public class Servidor {

    public static String obtenerNombreArchivo() {
        //===>Generar nombre del archivo.
        Calendar fecha = Calendar.getInstance();
        String nombre = "";

        nombre
                = "registrodeldia_"
                + fecha.get(Calendar.DAY_OF_MONTH)
                + (fecha.get(Calendar.MONTH)+1)
                + fecha.get(Calendar.YEAR)
                + ".txt";

        return nombre;
    }

    public static void guardarRegistro(String filePath, String registro) throws IOException {
        //===>Guardar el registro en el archivo
        File factura = new File(filePath);
        FileWriter streamWrite = new FileWriter(factura.getAbsoluteFile());
        BufferedWriter write = new BufferedWriter(streamWrite);

        write.write(registro.replace("|", ","));
        write.close();

    }

    public static String obtenerHra() {
        //===>Obtener la hra del sistema.
        Calendar fecha = Calendar.getInstance();

        String time = "";
        time += Integer.toString(fecha.get(Calendar.HOUR)) + ":";
        time += Integer.toString(fecha.get(Calendar.MINUTE)) + ":";
        time += Integer.toString(fecha.get(Calendar.SECOND));
        if (fecha.get(Calendar.AM_PM) == Calendar.AM) {
            time += " AM";
        } else {
            time += " PM";
        }

        return time;
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        try {
            ServerSocket servidor = new ServerSocket(5000);//===>Esperar conexiones entrantes en el Puerto 5000
            String archivo = obtenerNombreArchivo();
            while (true) {
                String msg = "";
                BufferedReader reader = null;
                PrintWriter writer = null;

                System.out.println("Esperando conexon del cliente...*");

                //===>Aceptar conexon entrante del cliente
                Socket cliente = servidor.accept();

                //===>Inicializar el objeto que nos permitira leer el texto que nos envia el cliente.
                reader = new BufferedReader(
                        new InputStreamReader(cliente.getInputStream()));

                //===>Crear el objeto que nos permitira escribirle al cliente
                writer = new PrintWriter(cliente.getOutputStream(), true);

                System.out.println("\n Se a conecto un cliente en la IP:" + cliente.getInetAddress().toString());
                System.out.println("{");
                System.out.println("\t * Transacciones realizadas *");
                System.out.println("\t   Factura : " + archivo);

                //===>Leer todo lo que dice el cliente hasta que nos retorne un mensaje en null
                while ((msg = reader.readLine()) != null) {
                    String[] producto = msg.split("\\|");//===>Separamos la informacion que viene separa por "|"

                    //===>Realizar el calculo de la transaccion
                    double precio = Double.parseDouble(producto[4]);
                    double cantidad = Double.parseDouble(producto[5]);
                    double total = precio * cantidad;
                    String registro = String.join("|", String.join("|", producto), total + "",obtenerHra());

                    //===>Guardar registro en el archivo de factura.
                    guardarRegistro(archivo, registro);
                    //===>Enviar respuesta al cliente
                    writer.println(registro);
                    
                    //===>Mostrar la transaccion en pantalla.
                    System.out.println("\t" + registro);//===>Mostrar en pantalla el mensaje que nos envio el cliente
                }
                System.out.println("\t *El cliente a cerrado session *");
                System.out.println("}");
                cliente.close();
                System.out.println("\n");
            }

        } catch (IOException ex) {
            System.out.println("Error:\n" + ex.getMessage());
        }

    }

}
