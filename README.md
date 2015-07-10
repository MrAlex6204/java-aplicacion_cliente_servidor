
Esta aplicacion la desarrolle para uso didactico 
basada en un problema publicado en yahoo
https://answers.yahoo.com/question/index?qid=20150707090433AAQ1Y2A

**Problematica :**
Se requiere la creación de dos procesos en Java, un proceso cliente y un proceso servidor, para la simulación del funcionamiento de una transacción de compra-venta:

**El Servidor:**

1. Con el paquete recibido desde el cliente (ver definición del cliente) debe hacer el siguiente cálculo:
a. Precio total a pagar
b. Tomar la fecha y hora del sistema
c. Armar paquete a devolver al cliente
d. Responder al cliente
e. Generar un archivo que se actualizará generando una nueva línea por venta. El nombre del archivo tendrá el siguiente formato: regisrodeldia_ddmmyyy.txt. Ejemplo: registrodeldia_25072015.txt. Cada línea del archivo debe contener todos los datos de la venta separados por coma: José, Contreras, 12333444, Jabón de baño, 50, 2, 100, 10:34:13 am

2. Enviar el archivo por socket cuando le sean consultadas las ventas del día.

**El Cliente 1:**

3. Solicitar por pantalla los datos del cliente necesarios para realizar la transacción de compra de un producto:
a. Nombre
b. Apellido
c. Cédula
d. Producto
e. Precio
f. Cantidad

4. Armar el paquete con los datos que necesita el servidor para realizar la transacción separando cada campo con un carácter “|”:

a. Ejemplo: José|Contreras|11222333|Jabón de baño|50|2|

5. El servidor debe devolver el mismo paquete con los siguientes campos adicionales:
a. Total a pagar
b. Fecha de la transacción
c. Hora de la transacción
d. Ejemplo: José|Contreras|11222333|Jabón de baño|50|2|100|25/07/2015|10:34:13 a.m.|


6. Crear un archivo llamado factura_dd-mm-yyyy_hhmmss.txt. Ejemplo del nombre: factura_25-07-2015_103413.txt

7. Consultar por las ventas del día al mismo servidor, este debe enviarle el archivo que registra las ventas diarias. El contenido del archivo debe imprimirse por pantalla.


**Solucion:**

**Paso #1**
El cliente enviara al servidor la transaccion concatenado la palabra **REGISTRO** al inicio
para indicarle al servidor que se trata de una transaccion.
Ej. 
  **REGISTRO|José|Contreras|11222333|Jabón de baño|50|2|**
El servidor valida si contiene el texto **REGISTRO** antes de iniciar la transaccion.

Si el cliente requiere realizar la consulta de ventas manda el siguiente texto: **CONSULTAR_TRANSACCIONES**
con este texto el servidor evitara realizar una transaccion y leera el archivo de factura generado del dia actual.

**Paso #2**
El servido al recibir la transaccion decompone la informacion en un String array utiliando la funcion split
el cual obtiene el precio y cantidad para realizar el calculo de la transaccion y guardar la informacion
en el archivo de factura.




