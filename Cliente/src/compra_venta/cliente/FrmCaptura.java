/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra_venta.cliente;

import java.awt.Dialog;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class FrmCaptura extends javax.swing.JFrame {

    //===>Indicamos la IP o Nombre del servidor
    private static final String SERVIDOR = "localhost";
    //===>Indicamos en que puerto IP esta conectado el servidor.
    private static final int PUERTO_IP = 5000;

    private Cliente _cliente = null;//===>Objeto cliente que mantendra la conexion con el servidor.
    private Producto _producto = new Producto();//===>Objeto producto.

    //===>Creamos un nuevo evento para leer las transacciones entrantes del servidor
    private Cliente.ITransaccionEntrante _transaccionEntrante
            = new Cliente.ITransaccionEntrante() {

                @Override
                public void Transaccion(String transaccion) {

                    if (transaccion.contains("REGISTRO|")) {
                        transaccion = transaccion.replace("REGISTRO|", "");//===>Eliminar instruccion del texto
                        String[] informacion = transaccion.split("\\|");
                        //===>Agregamos la informacion recibida por el server
                        //y le damos formato.
                        txtTransacciones.append(
                                informacion[0].toUpperCase() + " " + informacion[1].toUpperCase()
                                + " CEDULA:" + informacion[2] + "\n"
                                + "\t " + informacion[3].toUpperCase() + "\n"
                                + "\t $" + informacion[4] + " X $" + informacion[5] + " = " + informacion[6] + "\n"
                                + "\t Hra. de Transaccion:" + informacion[7] + "\n\n"
                        );
                    }
                    if (transaccion.contains("FACTURA|")) {
                        transaccion = transaccion.replace("FACTURA|", "");//===>Eliminar instruccion del texto
                        String[] registros = transaccion.split("\\|");
                        //===>Limpiar y mostrar la factura
                        txtTransacciones.setText("\t ** TRANSACCIONES REALIZADAS DEL DIA **\n\n");
                        System.out.println("\t{\n\t\t ** FACTURA **");
                        for (int idx = 0; idx <= registros.length - 1; idx++) {
                            System.out.println("\t\t" + (idx + 1) + ".-" + registros[idx].toUpperCase());
                            txtTransacciones.append((idx + 1) + ".-" + registros[idx].toUpperCase() + "\n");
                        }
                        System.out.println("\t}");
                    }

                }
            };

    public FrmCaptura() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCaptura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //===>Inicializar los controles de la ventana
        this.setResizable(false);
        initComponents();
        try {
            //===>Crear objeto y conectar con el servidor.
            _cliente = new Cliente(SERVIDOR, PUERTO_IP);

            //===>Establecemos donde sevan ir las transacciones entrantes.
            _cliente.setTransaccionEntrante(_transaccionEntrante);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error al conectar con el servidor", JOptionPane.PLAIN_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmdEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTransacciones = new javax.swing.JTextArea();
        cmdLimpiar = new javax.swing.JButton();
        cmdTransaccionesDelDia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont((float)12));
        jLabel1.setText("Nombre:");

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)12));
        jLabel2.setText("Apellido:");

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)12));
        jLabel3.setText("Cedula:");

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | java.awt.Font.BOLD, 12));
        jLabel4.setText("Producto");

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getStyle() | java.awt.Font.BOLD, 12));
        jLabel5.setText("Precio ");

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD, 12));
        jLabel6.setText("Cantidad ");

        txtNombre.setFont(txtNombre.getFont().deriveFont((float)12));

        txtApellido.setFont(txtApellido.getFont().deriveFont((float)12));

        txtCedula.setFont(txtCedula.getFont().deriveFont((float)12));

        txtProducto.setFont(txtProducto.getFont().deriveFont((float)12));

        txtPrecio.setFont(txtPrecio.getFont().deriveFont((float)12));

        txtCantidad.setFont(txtCantidad.getFont().deriveFont((float)12));

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getStyle() | java.awt.Font.BOLD, 20));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cliente");

        cmdEnviar.setFont(cmdEnviar.getFont().deriveFont((float)12));
        cmdEnviar.setText("Enviar");
        cmdEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEnviarActionPerformed(evt);
            }
        });

        txtTransacciones.setColumns(20);
        txtTransacciones.setRows(5);
        txtTransacciones.setFocusable(false);
        jScrollPane1.setViewportView(txtTransacciones);

        cmdLimpiar.setFont(cmdLimpiar.getFont().deriveFont((float)12));
        cmdLimpiar.setText("Limpiar");
        cmdLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLimpiarActionPerformed(evt);
            }
        });

        cmdTransaccionesDelDia.setFont(cmdTransaccionesDelDia.getFont().deriveFont(cmdTransaccionesDelDia.getFont().getStyle() | java.awt.Font.BOLD, 12));
        cmdTransaccionesDelDia.setText("Consultar transacciones del dia");
        cmdTransaccionesDelDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTransaccionesDelDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                    .addComponent(txtCedula))))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdTransaccionesDelDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(cmdTransaccionesDelDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdEnviar)
                    .addComponent(cmdLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean esNumerico(String valor, String MsgError) {
        //===>Intenta convertir un texto a numerico
        try {
            Double.parseDouble(valor);//===>Convertir a numerico
            return true;//===>Regresar true por que si es un valor numerico
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, MsgError, "Valor invalido", JOptionPane.PLAIN_MESSAGE);

            return false;//===>Retornar falso por que no es numerico
        }
    }

    private boolean estaVacio(String valor, String MsgError) {
        if (valor.trim().replace("|", "").equals("") || valor == null) {
            JOptionPane.showMessageDialog(this, MsgError, "Valor invalido", JOptionPane.PLAIN_MESSAGE);
            return true;
        } else {
            return false;
        }
    }
    private void cmdEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEnviarActionPerformed
        //===>Evento click del boton.
        try {
//           Cliente cl = new Cliente("localhost", 5000);
            _producto.limpiar();//===>Limpiar el contenido

            /*
             Realizar unas validaciones antes de enviar al servidor para que este no tenga problemas
             al realizar el calculo
             */
            if (estaVacio(this.txtNombre.getText(), "El nombre no puede estar vacio") == true) {
                return;
            }

            if (estaVacio(this.txtApellido.getText(), "El apellido no puede estar vacio") == true) {
                return;
            }
            if (estaVacio(this.txtCedula.getText(), "La cedula no puede estar vacio") == true) {
                return;
            }
            if (estaVacio(this.txtProducto.getText(), "El producto no puede estar vacio") == true) {
                return;
            }

            if (esNumerico(this.txtPrecio.getText().trim(), "El precio no tiene un valor valido") == false) {
                return; //===>Salir para no continuar 
            }
            if (esNumerico(this.txtCantidad.getText().trim(), "La cantidad no tiene un valor valido") == false) {
                return; //===>Salir para no continuar 
            }

            //===>Llenar cada campo de producto.
            _producto.nombre = this.txtNombre.getText().replace("|", "");
            _producto.apellido = this.txtApellido.getText().replace("|", "");
            _producto.cedula = this.txtCedula.getText().replace("|", "");
            _producto.producto = this.txtProducto.getText().replace("|", "");

            _producto.precio = this.txtPrecio.getText();
            _producto.cantidad = this.txtCantidad.getText();

            //===>Enviar la informacion del producto al servidor.
            _cliente.enviarProducto(_producto);

            //===>Limpiar contenido
            this.txtProducto.setText("");
            this.txtPrecio.setText("");
            this.txtCantidad.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Error al conectar con el servidor", JOptionPane.PLAIN_MESSAGE);

        }
    }//GEN-LAST:event_cmdEnviarActionPerformed

    private void cmdLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLimpiarActionPerformed
        // TODO add your handling code here:
        txtTransacciones.setText("");
    }//GEN-LAST:event_cmdLimpiarActionPerformed

    private void cmdTransaccionesDelDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTransaccionesDelDiaActionPerformed
        // TODO add your handling code here:
        //===>Realizar la consulta de las transacciones del dia.
        _cliente.consultarTransacciones();
    }//GEN-LAST:event_cmdTransaccionesDelDiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEnviar;
    private javax.swing.JButton cmdLimpiar;
    private javax.swing.JButton cmdTransaccionesDelDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextArea txtTransacciones;
    // End of variables declaration//GEN-END:variables
}
