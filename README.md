
Esta aplicacion la desarrolle para uso didactico 
basada en un problema publicado en yahoo
https://answers.yahoo.com/question/index?qid=20150707090433AAQ1Y2A

**Problematica :**
Se requiere la creación de dos aplicaciones en Java, una aplicacion es el cliente y la otra es servidor, para la simulación del funcionamiento de una transacción de compra-venta:

**Requerimientos del cliente**

**El Servidor:**

1. Con el paquete recibido desde el cliente (ver definición del cliente) debe hacer el siguiente cálculo:<br>
a. Precio total a pagar<br>
b. Tomar la fecha y hora del sistema<br>
c. Leer la transaccion y responder al cliente haciendo el calculo del total a pagar<br>
d. Generar un archivo que se actualizará generando una nueva línea por venta.<br>
El nombre del archivo tendrá el siguiente formato: regisrodeldia_ddmmyyy.txt.<br>
Ejemplo: registrodeldia_25072015.txt. Cada línea del archivo debe contener todos los datos de la venta separados por coma:<br>
José, Contreras, 12333444, Jabón de baño, 50, 2, 100, 10:34:13 am<br>

2. Leer y enviar el contenido del archivo cuando le sean consultadas las ventas del día por el cliente.<br>

**El Cliente 1:**

3. Solicitar por pantalla los datos del cliente necesarios para realizar la transacción de compra de un producto:<br>
a. Nombre<br>
b. Apellido<br>
c. Cédula<br>
d. Producto<br>
e. Precio<br>
f. Cantidad<br>

4. Armar el paquete con los datos que necesita el servidor para realizar la transacción separando cada campo con un carácter “|”:<br>

a. Ejemplo: **José|Contreras|11222333|Jabón de baño|50|2|**<br>

5. El servidor debe devolver el mismo paquete con los siguientes campos adicionales:<br>
a. Total a pagar<br>
b. Fecha de la transacción<br>
c. Hora de la transacción<br>
d. Ejemplo: José|Contreras|11222333|Jabón de baño|50|2|100|25/07/2015|10:34:13 a.m.|<br>

7. Consultar las ventas del día al mismo servidor y este debe leer el archivo generado y enviarle el contenido de las ventas registradas del dia.<br>
<br>
El contenido del archivo debe imprimirse en pantalla.<br>
<br>
<br>
**Solucion:**

**Paso #1**
El cliente enviara al servidor la transaccion concatenado la palabra **REGISTRO** al inicio
para indicarle al servidor que se trata de una transaccion.<br>
Ej. <br>
  **REGISTRO|José|Contreras|11222333|Jabón de baño|50|2|**<br>
El servidor valida si contiene el texto **REGISTRO** antes de iniciar la transaccion.<br>
<br>
Si el cliente requiere realizar la consulta de ventas manda el siguiente texto: **CONSULTAR_TRANSACCIONES**
con este texto el servidor evitara realizar una transaccion y leera el archivo de factura generado del dia actual.<br>
<br>
**Paso #2**<br>
El servidor al recibir la cadena de transaccion del cliente descompone la informacion en un String array utiliando la funcion split y valida el tipo de transaccion a realizar segun el valor del **index 0** REGISTRO  o CONSULTAR_TRANSACCIONES<br>
<br>
<br>
**Ejemplo**<br>
<br>
![url_tag](https://github.com/MrAlex6204/java-aplicacion_cliente_servidor/blob/master/screen-recorded-170718-101410.gif)




